package ui;
import javax.swing.*;

import util.FrameUtil;
import config.FrameConfig;
import config.GameConfig;
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
		FrameUtil.setFrameCenter(this);
		//����Ĭ��panel
		this.setContentPane(panelGame);
		//Ĭ�ϸô���Ϊ��ʾ
		this.setVisible(true);
	}

}
