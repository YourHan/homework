package lianxi;

import javax.swing.JFrame;

public class Myframe {

	public static void main(String[] args) {
		// 创建一个窗体对象
		JFrame  frame=new JFrame();
		frame.setSize(300,200);//设置窗体的大小为300*200像素大小
		frame.setTitle("...");//设置窗体的标题
		frame.setVisible(true);//设置窗体的可见性，没有该语句窗体将不可见
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户单击窗口的关闭按钮时程序执行的操作
		
	}

}
