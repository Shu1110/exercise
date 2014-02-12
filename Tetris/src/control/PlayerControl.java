package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerControl extends KeyAdapter{
	
	private GameControl gameControl;
	
	public PlayerControl(GameControl gameControl){
		this.gameControl=gameControl;
		
	}
	
	/**
	 * 键盘按下事件
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			this.gameControl.keyUp();
			break;
		case KeyEvent.VK_DOWN:
			this.gameControl.keyDown();
			break;
		case KeyEvent.VK_LEFT:
			this.gameControl.keyLeft();
			break;
		case KeyEvent.VK_RIGHT:
			this.gameControl.keyRight();
			break;
		}
	}

	

}
