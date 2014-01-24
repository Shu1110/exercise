import java.awt.*;
import javax.swing.*;

public class FrameWithPanel {
	public static void main(String[] args) {

		new MyFrame("FrameAndPanel", 200, 200, 658, 400);
		// TODO Auto-generated method stub

	}

}

class MyFrame extends Frame {
	private Panel p1;

	MyFrame(String s, int x, int y, int w, int h) {
		super(s);
		setLayout(null);
		p1 = new Panel();
		p1.setBounds(w / 4, h / 4, w / 2, h / 2);
		p1.setBackground(Color.magenta);
		add(p1);
		setBounds(x, y, w, h);
		setVisible(true);
	}
}