package lianxi;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DELL on 2018/7/12.
 */
public class Homework extends JFrame implements ActionListener {
    JLabel lbaccount;
    JLabel lbpassword;
    JLabel lbemail;

    JTextField tfon;
    JTextField tfcenter;
    JTextField tfdown;

    JButton btnsave;
    JButton btndelete;
    public  Homework() {
        this.setSize(800, 700);
        this.setLayout(null);

        this.setVisible(true);
        //��ǩ����ʼ
        lbaccount = new JLabel("�˺�");
        lbpassword = new JLabel("����");
        lbemail = new JLabel("����");
        //�ı���
        tfon = new JTextField(200);
        tfcenter = new JTextField(200);
        tfdown = new JTextField(200);
        //��ť����
         btnsave = new JButton("ȷ��");
        btndelete = new JButton("����");
        btndelete.setActionCommand("����");

//��ǩλ��
        lbaccount.setBounds(300, 0, 400, 100);
        lbpassword.setBounds(300, 100, 400, 100);
        lbemail.setBounds(300, 200, 400, 100);
        //�ı���λ��
        tfon.setBounds(500, 0, 400, 100);
        tfcenter.setBounds(500, 100, 400, 100);
        tfdown.setBounds(500, 200, 400, 100);
        //��ťλ��;
        btnsave.setBounds(450, 400, 100, 60);
        btndelete.setBounds(600, 400, 100, 60);

        //this.add(lb_account);
        this.add(tfon);
        this.add(lbaccount);

        //this.add(lb_password);
        this.add(tfcenter);
        this.add(lbpassword);

        //  this.add(lb_email);
        this.add(tfdown);
        this.add(lbemail);

        this.add(btnsave);
        this.add(btndelete);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnsave.addActionListener(this);
        btndelete.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print(e.getActionCommand());
        if(e.getActionCommand().equals("ȷ��") || e.getActionCommand().equals("����")) {

            JOptionPane.showConfirmDialog( Homework.this,tfon.getText()+tfcenter.getText()+tfdown.getText());
        }
    }
}
