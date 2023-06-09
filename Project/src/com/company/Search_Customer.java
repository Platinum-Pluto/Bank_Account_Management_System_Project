package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Search_Customer implements ActionListener{
    JFrame f;
    JLabel l,l5;
    JButton b,b2,b3;
    Search_Customer(){
        f=new JFrame("search");
        f.setBackground(Color.green);
        f.setLayout(null);

        l5=new JLabel();
        l5.setBounds(0,0,500,270);
        l5.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/Layout.png"));
        Image i2 = img.getImage().getScaledInstance(500,270,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        l5.setIcon(i3);

        l=new JLabel("Search Customer");
        l.setVisible(true);
        l.setBounds(150,20,250,30);
        l.setForeground(Color.BLACK);
        Font F1=new Font("serif",Font.BOLD,25);
        l.setFont(F1);
        l5.add(l);
        f.add(l5);

        b=new JButton("Checking Account");
        b.setBounds(140,70,200,30);
        b.addActionListener(this);
        l5.add(b);

        b2=new JButton("Cancel");
        b2.setBounds(190,200,100,30);
        b2.addActionListener(this);
        l5.add(b2);

        b3=new JButton("Savings Account");
        b3.setBounds(140,120,200,30);
        b3.addActionListener(this);
        l5.add(b3);

        f.setSize(500,270);
        f.setLocation(450,250);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b){
            f.setVisible(false);
            new CheckingPrinter();
        }

        if(ae.getSource()==b2){
            JOptionPane.showMessageDialog(null,"Exit Panel");
            f.setVisible(false);
            new AccountAction();
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
            new SavingsPrinter();
        }
    }

}
