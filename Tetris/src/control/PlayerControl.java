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
	 * ���̰����¼�
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_E:
			this.gameControl.keyUp();
			break;
		case KeyEvent.VK_D:
			this.gameControl.keyDown();
			break;
		case KeyEvent.VK_S:
			this.gameControl.keyLeft();
			break;
		case KeyEvent.VK_F:
			this.gameControl.keyRight();
			break;
		}
	}

	

}