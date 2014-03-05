package ui.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import util.FrameUtil;
import control.GameControl;

public class JFrameConfig extends JFrame{
	
	private JButton btnOk=new JButton("ȷ��");
	
	private JButton btnCancel=new JButton("ȡ��");
	
	private JButton btnUser=new JButton("Ӧ��");
	
	private TextCtrl[] keyText=new TextCtrl[8];
	
	private JLabel errorMsg=new JLabel();
	
	private JLabel jlSkin=new JLabel();
	
	private GameControl gameControl;
	
	private final static Image IMG_PSP=new ImageIcon("data/psp.jpg").getImage();
	
	private final static String[] METHOD_NAMES={
		"keyRight","keyUp","keyLeft","keyDown",
		"keyFunLeft","keyFunUp","keyFunRight","keyFunDown"
	};
	
	private final static String PATH="data/control.dat";
	
	public JFrameConfig(GameControl gameControl){
		//�����Ϸ����������
		this.gameControl=gameControl;
		//���ò��ֹ�����Ϊ���߽粼�֡�
		this.setLayout(new BorderLayout());
		this.setTitle("����");
		//��ʼ�����������
		this.initKeyText();
		//��������
		this.add(createMainPanel(),BorderLayout.CENTER);
		//��Ӱ�ť���
		this.add(this.createButtonPanel(),BorderLayout.SOUTH);
		//���ò��ܸı��С
		this.setResizable(false);
		//���ô��ڴ�С
		this.setSize(644,350);
		// ����
		FrameUtil.setFrameCenter(this);
	}

	/**
	 * ��ʼ�����������
	 */
	private void initKeyText() {
		int x=10;
		int y=50;
		int w=64;
		int h=20;
		for(int i=0;i<4;i++){
			keyText[i]=new TextCtrl(x,y,w,h,METHOD_NAMES[i]);
			y+=32;
		}
		x=568;
		y=50;
		for(int i=4;i<8;i++){
			keyText[i]=new TextCtrl(x,y,w,h,METHOD_NAMES[i]);
			y+=32;
		}
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(PATH));
			@SuppressWarnings("unchecked")
			HashMap<Integer,String> cfgSet=(HashMap<Integer,String>)ois.readObject();
			ois.close();
			Set<Entry<Integer,String>> entryset=cfgSet.entrySet();
			for(Entry<Integer,String> e:entryset){
				for(TextCtrl tc:keyText){
					if(tc.getMethodName().equals(e.getValue())){
						tc.setKeyCode(e.getKey());
					}
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * ������ť���
	 * @return
	 */
	private JPanel createButtonPanel() {
		//������ť��壬��ʽ����
		JPanel jp=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		//����ȷ������ť�����¼�����
		this.btnOk.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(writeConfig()){
					setVisible(false);
					gameControl.setOver();
				}
			}
		});
		this.errorMsg.setForeground(Color.red);
		jp.add(errorMsg);
		jp.add(this.btnOk);
		this.btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				gameControl.setOver();
			}
		});
		jp.add(this.btnCancel);
		this.btnUser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				writeConfig();
			}
		});
		jp.add(this.btnUser);
		return jp;
	}

	/**
	 * ��������壨ѡ���壩
	 * @return
	 */
	private JTabbedPane createMainPanel() {
		JTabbedPane jtp=new JTabbedPane();
		jtp.addTab("��������",this.createControlPanel());
		jtp.addTab("Ƥ������",this.createSkinPanel());
		return jtp;
	}
	
	/**
	 * ���Ƥ�����
	 */
	private Component createSkinPanel() {
		JPanel panel=new JPanel(new BorderLayout());
		this.jlSkin=new JLabel("û�и����ͼƬ�زģ��뽫����ʹ�� (��.��|||");
		this.jlSkin.setFont(new Font("����",Font.BOLD,20));
		this.setForeground(Color.red);
		panel.add(this.jlSkin);
		panel.add(this.jlSkin,BorderLayout.CENTER);
		return panel;
	}

	/**
	 * ��ҿ����������
	 * @return
	 */
	private JPanel createControlPanel() {
		JPanel jp=new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(IMG_PSP, 0, 0, null);
			}
		};
		//���ò��ֹ�����
		jp.setLayout(null);
		for(int i=0;i<keyText.length;i++){
			jp.add(keyText[i]);
		}
		return jp;
	}
	
	/**
	 * д����Ϸ���� 
	 */
	private boolean writeConfig() {
		HashMap<Integer,String> keySet=new HashMap<Integer,String>();
		for(int i=0;i<this.keyText.length;i++){
			int keyCode=this.keyText[i].getKeyCode();
			if(keyCode==0){
				this.errorMsg.setText("���󰴼�");
				return false;
			}
			keySet.put(keyCode, this.keyText[i].getMethodName());
		}
		if(keySet.size()!=8){
			this.errorMsg.setText("�ظ�����");
			return false;
		}
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(PATH));
			oos.writeObject(keySet);
			oos.close();
		} catch (Exception e) {
			this.errorMsg.setText(e.getMessage());
			return false;
		}
		this.errorMsg.setText(null);
		return true;
	}
}
