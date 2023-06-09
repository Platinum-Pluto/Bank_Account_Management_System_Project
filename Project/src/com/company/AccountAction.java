package com.company;
        import java.awt.*;
        import javax.swing.*;
        import java.awt.event.*;

class AccountAction implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b6;

    AccountAction(){
        f=new JFrame("Admin Panel");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bg6.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        l1.setIcon(i3);
        f.add(l1);

        l2 = new JLabel("Customer Services");
        l2.setBounds(430,20,200,40);
        l2.setFont(new Font("serif",Font.BOLD,25));
        l2.setForeground(Color.white);
        l1.add(l2);

        b1=new JButton("Add");
        b1.setBounds(420,80,100,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        l1.add(b1);

        b2=new JButton("Search");
        b2.setBounds(530,80,100,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        l1.add(b2);

        b3=new JButton("Remove");
        b3.setBounds(530,200,100,40);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        l1.add(b3);

        b4=new JButton("Update");
        b4.setBounds(420,200,100,40);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.addActionListener(this);
        l1.add(b4);

        b5=new JButton("Withdraw");
        b5.setBounds(530,140,100,40);
        b5.setFont(new Font("serif",Font.BOLD,15));
        b5.addActionListener(this);
        l1.add(b5);

        b6=new JButton("Deposit");
        b6.setBounds(420,140,100,40);
        b6.setFont(new Font("serif",Font.BOLD,15));
        b6.addActionListener(this);
        l1.add(b6);

        f.setVisible(true);
        f.setSize(700,500);
        f.setLocation(450,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            f.setVisible(false);
            new Add_Customer();
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            new Search_Customer();
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
            new Remove();
        }
        if(ae.getSource()==b4){
            f.setVisible(false);
            new UpdateInfo();
        }
        if(ae.getSource()==b5){
            f.setVisible(false);
            new Withdraw();
        }
        if(ae.getSource()==b6){
            f.setVisible(false);
            new Deposit();
        }
    }
}
