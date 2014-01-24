import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TestEvent {
	public static void main(String[] args) {
		My m = new My("My");
		m.setBounds(100, 100, 300, 300);

	}

}

class My extends JFrame {
	private JButton b1;
	private JTextField text;

	My(String s) {
		super(s);
		b1 = new JButton("button");
		text = new JTextField(10);
		text.setText("1");
		add(b1);
		add(text);
		b1.addActionListener(new Monitor(text));
		setLayout(new FlowLayout());
		setVisible(true);
	}

}

class Monitor implements ActionListener {
	JTextField text;

	Monitor(JTextField text) {
		this.text = text;
	}

	public void actionPerformed(ActionEvent e) {
		int n = Integer.parseInt(text.getText());
		text.setText("" + (n + 1));
	}
}