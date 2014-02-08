package ui;
import javax.swing.*;

import config.ConfigFactory;
import config.GameConfig;

import java.awt.Dimension;
import java.awt.Toolkit;
public class JFrameGame extends JFrame {
	public JFrameGame(){
		//»ñµÃÓÎÏ·ÅäÖÃ
		GameConfig cfg=ConfigFactory.getGameConfig();
		this.setTitle(cfg.getTitle());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(cfg.getWidth(), cfg.getHeight());
		this.setResizable(false);
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
		int x=screen.width-this.getWidth()>>1;
		int y=(screen.height-this.getHeight()>>1)-cfg.getWindowUp();
		this.setLocation(x, y);
		this.setContentPane(new JPanelGame());
	}

}
