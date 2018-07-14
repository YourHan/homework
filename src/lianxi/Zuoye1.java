package lianxi;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Zuoye1 extends JFrame {
		public Zuoye1() {
			this.setSize(300,400);
			this.setTitle("...");
			//FlowLayout flowLayout=new FlowLayout();
			GridLayout gridLayout=new GridLayout(4,2);
			this.setLayout(gridLayout );
			JButton left1=new JButton("title");
			JButton right1=new JButton("");
			JButton left2=new JButton("account");
			JButton right2=new JButton("");
			JButton left3=new JButton("password");
			JButton right3=new JButton("");
			JButton left4=new JButton("remark");
			JButton right4=new JButton("");

			left1.setActionCommand("title1");
			right1.setActionCommand("");
			left2 .setActionCommand("account1");
			right2.setActionCommand("");
			left3 .setActionCommand("password1");
			right3.setActionCommand("");
			left4.setActionCommand("remark1");
			right4.setActionCommand("");

	ActionListener actionListener1=new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String command =e.getActionCommand();
					JButton button =(JButton) e.getSource();
					if(command.equals("title1")) {
						button.setBackground(Color.gray);
						JOptionPane.showMessageDialog(Zuoye1.this,"aa,bb,cc");
				    }	else if (command.equals("account1")) {
						button.setBackground(Color.BLUE);
						JOptionPane.showMessageDialog(Zuoye1.this,"aa,bb,cc");
					}else if (command.equals("password1")) {
						button.setBackground(Color.yellow);
						JOptionPane.showMessageDialog(Zuoye1.this,"aa,bb,cc");
					}else if (command.equals("remark1")) {
						JOptionPane.showMessageDialog(Zuoye1.this,"aa,bb,cc");
					}
				}
			};
			left1.addActionListener(actionListener1);
			right1.addActionListener(actionListener1);
			left2.addActionListener(actionListener1);
			right2.addActionListener(actionListener1);
			left3 .addActionListener(actionListener1);
			right3 .addActionListener(actionListener1);
			left4.addActionListener(actionListener1);
			right4 .addActionListener(actionListener1);

			this.add(left1);
			this.add(right1);
			this.add(left2);
			this.add(right2);
			this.add(left3);
			this.add(right3);
			this.add(left4 );
			this.add(right4);

			setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
}
}
	