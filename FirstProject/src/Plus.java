import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Plus {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame1 ff = new Frame1();
		ff.setTitle("Plus");
		// TODO Auto-generated method stub

	}

}

class Frame1 extends JFrame {
	JTextField num1, num2, num3;
	JLabel l1;
	JButton b1;

	Frame1() {
		num1 = new JTextField(10);
		num2 = new JTextField(10);
		num3 = new JTextField(15);
		l1 = new JLabel("+");
		b1 = new JButton("=");
		b1.addActionListener(new Monitor1(this));
		setLayout(new FlowLayout());
		add(num1);
		add(l1);
		add(num2);
		add(b1);
		add(num3);
		pack();
		setVisible(true);
	}
}

class Monitor1 implements ActionListener {
	Frame1 f = null;

	Monitor1(Frame1 f) {
		this.f = f;
	}

	public void actionPerformed(ActionEvent e) {
		int n1 = Integer.parseInt(f.num1.getText());
		int n2 = Integer.parseInt(f.num2.getText());
		f.num3.setText("" + (n1 + n2));
	}
}