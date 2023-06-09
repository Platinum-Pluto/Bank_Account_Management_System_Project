package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Add_Customer implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JButton b1,b2;

    Add_Customer(){
        f=new JFrame("New Customer Account");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bg5.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        l1.setIcon(i3);
        f.add(l1);

        l2 = new JLabel("Customer Services");
        l2.setBounds(250,20,200,40);
        l2.setFont(new Font("serif",Font.BOLD,25));
        l2.setForeground(Color.black);
        l1.add(l2);

        b1=new JButton("Checking Account");
        b1.setBounds(250,80,200,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        l1.add(b1);

        b2=new JButton("Savings Account");
        b2.setBounds(250,150,200,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        l1.add(b2);

        f.setVisible(true);
        f.setSize(700,500);
        f.setLocation(450,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            f.setVisible(false);
            new CheckingAcct();
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            new SavingsAcct();
        }
    }

}
