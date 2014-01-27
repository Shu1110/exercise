package ui;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.Toolkit;
public class FrameGame extends JFrame {
	public FrameGame(){
		this.setTitle("Java¶íÂÞË¹·½¿é");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1200, 700);
		this.setResizable(false);
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
		int x=(screen.width-this.getWidth())/2;
		int y=(screen.height-this.getHeight())/2-32;
		this.setLocation(x, y);
		this.setContentPane(new PanelGame());
	}

}
