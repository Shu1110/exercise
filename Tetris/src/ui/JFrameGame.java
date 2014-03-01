package ui;
import javax.swing.*;
import config.FrameConfig;
import config.GameConfig;

import java.awt.Dimension;
import java.awt.Toolkit;
public class JFrameGame extends JFrame {
	public JFrameGame(JPanelGame panelGame){
		//�����Ϸ����
		FrameConfig fCfg=GameConfig.getFrameConfig();
		//���ñ���
		this.setTitle(fCfg.getTitle());
		//���Ĭ�Ϲر����ԣ����������
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//���ô��ڴ�С
		this.setSize(fCfg.getWidth(), fCfg.getHeight());
		//�������û��ı䴰�ڴ�С
		this.setResizable(false);
		//����
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
		int x=screen.width-this.getWidth()>>1;
		int y=(screen.height-this.getHeight()>>1)-fCfg.getWindowUp();
		this.setLocation(x, y);
		//����Ĭ��panel
		this.setContentPane(panelGame);
		//Ĭ�ϸô���Ϊ��ʾ
		this.setVisible(true);
	}

}
