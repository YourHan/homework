package lianxi;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

	public class Myframe extends JFrame {
		public Myframe() {
			this.setSize(300,400);
			this.setTitle("...");
			//FlowLayout flowLayout=new FlowLayout();
			GridLayout gridLayout=new GridLayout(3,2);
			this.setLayout(gridLayout );
			JButton btnNorth=new JButton("北方");
			JButton btnSouth=new JButton("南方");
			JButton btnEast=new JButton("东方");
			JButton btnWest=new JButton("西方");
			final JButton btnCenter=new JButton("中间");
//			btnNorth.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					JButton button=(JButton)e.getSource();
//					button.setBackground(Color.black);
//				}
//			});
			
			btnNorth .setActionCommand("north");
			btnSouth .setActionCommand("south");
			btnEast .setActionCommand("east");
			btnCenter.setActionCommand("center");
			btnWest.setActionCommand("west");
			ActionListener actionListener1=new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String command =e.getActionCommand();
					JButton button =(JButton) e.getSource();
					if(command.equals("north")) {
						button.setBackground(Color.gray);
				    }	else if (command.equals("south")) {
						button.setBackground(Color.BLUE);
					}else if (command.equals("east")) {
						button.setBackground(Color.yellow);
					}else if (command.equals("center")) {
						JOptionPane.showMessageDialog(Myframe.this,"aa,bb,cc");
					}else if (command.equals("west")) {
						button.setBackground(Color.PINK);
						}
				}
			};
			
			

			btnNorth.addActionListener(actionListener1);
			btnSouth.addActionListener(actionListener1);
			btnEast.addActionListener(actionListener1);
			btnWest.addActionListener(actionListener1);
			btnCenter.addActionListener(actionListener1);
			this.add(btnNorth);
			this.add(btnSouth);
			this.add(btnEast);
			this.add(btnWest);
			this.add(btnCenter);
			
			//this.add(btnNorth,BorderLayout.NORTH);
			//this.add(btnSouth,BorderLayout.SOUTH);
			//this.add(btnEast,BorderLayout.EAST);
			//this.add(btnWest,BorderLayout.WEST);
			//this.add(btnCenter,BorderLayout.CENTER);
			
		    setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
	}


