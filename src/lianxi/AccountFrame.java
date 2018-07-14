package lianxi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PrivateKey;

/**
 * Created by DELL on 2018/7/13.
 */
public class AccountFrame extends JFrame {
    private JPanel panelon=new JPanel();
    private JPanel panelcenter=new JPanel();
    private JPanel paneldown=new JPanel();
    private JPanel paneladd=new JPanel();
    //澹版槑涓婇儴闈㈡澘鐨勫彉閲�
    private JTextField tfsearch=new JTextField();
    private Button btnsearch=new Button("Search");
    //澹版槑涓棿闈㈡澘鐨勫彉閲�
    private JLabel lbcenter=new JLabel("缁撴灉");
    private JTextField tfcenter=new JTextField();
    //澹版槑涓嬮儴闈㈡澘鐨勫彉閲�
    private  Button btnadd=new Button("Add");
    private  Button btndelete=new Button("Delete");
    private  Button btnmodify=new Button("Modify");
    //澹版槑娣诲姞闈㈡澘鐨勫彉閲�
    private  JLabel lbaccount=new JLabel("璐﹀彿");
    private JLabel lbpassword=new JLabel("瀵嗙爜");
    private JLabel lbother=new JLabel("鍏朵粬淇℃伅");

    private JTextField tfon=new JTextField();
    private JTextField tfpassword=new JTextField();
    private JTextField tfdown=new JTextField();
    public AccountFrame(){
        //璁剧疆鐣岄潰
        this.setSize(800,700);
        this.setTitle("Day2");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //璁剧疆涓婇儴闈㈡澘
        this.add(panelon, BorderLayout.NORTH);
        panelon.setLayout(new BorderLayout());
        panelon.add(tfsearch );
        panelon.add(btnsearch,BorderLayout.EAST);
        //璁剧疆涓棿闈㈡澘
        this.add(panelcenter,BorderLayout.CENTER);
        panelcenter.setLayout(new BorderLayout());
        panelcenter.setVisible(true);
        //panelcenter.add(lbcenter);
        panelcenter.add(tfcenter);
       panelcenter.add(lbcenter,BorderLayout.WEST);
       panelcenter.setVisible(true);
        //璁剧疆涓嬮儴闈㈡澘
        this.add(paneldown,BorderLayout.SOUTH);
        paneldown.add(btnadd,new FlowLayout());
        paneldown.add(btndelete,new FlowLayout());
        paneldown.add(btnmodify,new FlowLayout());
        //璁剧疆娣诲姞闈㈡澘
        this.add(paneladd,BorderLayout.CENTER);
        paneladd.setLayout(new GridLayout(3,2));
        paneladd.add(lbaccount);
        paneladd.add(tfon);
        paneladd.add(lbpassword);
        paneladd.add(tfpassword);
        paneladd.add(lbother);
        paneladd.add(tfdown);
        paneladd.setVisible(false);
        //鐩戝惉瑙﹀彂浜嬩欢
         this.btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            String textadd=btnadd.getLabel();
            if(textadd.equals("add")){
                textadd="save";
              paneladd.setVisible(true);
              panelcenter.setVisible(false);
              btndelete.setLabel("cancel");
              btnmodify.setVisible(false);
            }else{
                textadd="add";
               panelcenter.setVisible(true);
               paneladd.setVisible(false);
               btndelete.setLabel("delete");
               btnmodify.setVisible(true);
            }
            btnadd.setLabel(textadd);
            }
        });
         this.btndelete.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String textdt=btndelete.getLabel();
                 if(textdt.equals("cancel")){
                     textdt="delete";
                     panelcenter.setVisible(true);
                     paneladd.setVisible(false);
                     btnadd.setLabel("add");
                     btnmodify.setVisible(true);
                 }else {
                     textdt="cancel";
                     panelcenter.setVisible(false);
                     paneladd.setVisible(true);
                     btnadd.setLabel("save");
                     btnmodify.setVisible(false);

                 }
                 btndelete.setLabel(textdt);
             }
         });
    }

    public static void main(String [] args){
        new AccountFrame();
    }
}
