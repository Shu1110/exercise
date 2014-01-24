package com.ting;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Test extends JFrame implements ActionListener{
	 JButton b1,b2,b3,b4;
	 JTextArea t1;
	 public static void main(String args[]){
		Test t=new Test();
	 }
	 Test(){
		 setSize(300, 400);
		 b1=new JButton("enter");
		 b2=new JButton("cancel");
		 b3=new JButton("blue");
		 b4=new JButton("red");
		 t1=new JTextArea(6,12);
		 
		 add(b1);
		 add(b2);
		 add(b3);
		 add(b4);
		 add(t1);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 setLayout(new FlowLayout());
		 setVisible(true);
	 }
	 public void actionPerformed(ActionEvent e){
		 if(e.getSource()==b1){
			 t1.append("this is enter button.\n");
		 }
		 else if(e.getSource()==b2){
			 t1.append("this is cancel button.\n");
		 }
	 }
}
