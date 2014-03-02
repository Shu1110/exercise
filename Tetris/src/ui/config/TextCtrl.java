package ui.config;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class TextCtrl extends JTextField{

	private int keyCode;
	
	private final String methodName;
	
	public TextCtrl(int x,int y,int w,int h,String methodName){
		//�����ı���λ��
		this.setBounds(x,y,w,h);
		//��ʼ��������
		this.methodName=methodName;
		//�����¼�����
		this.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
			/**
			 * �����ɿ�
			 */
			public void keyReleased(KeyEvent e) {
				setKeyCode(e.getKeyCode());
			}
		});
	}

	public int getKeyCode() {
		return keyCode;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setKeyCode(int keyCode) {
		// ��ʼ��KeyCode
		this.keyCode = keyCode;
		this.setText(KeyEvent.getKeyText(this.keyCode));
	}
	
}
