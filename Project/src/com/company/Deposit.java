package com.company;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

class Deposit implements ActionListener{
    JFrame f;
    JTextField t,t1;
    JLabel l,l1,l5;
    JButton b,b2;
    JRadioButton rb1,rb2;
    ArrayList<String> list=new ArrayList<>();
    int counter=0,flag=0;
    Deposit(){
        f=new JFrame("Deposit");
        f.setBackground(Color.green);
        f.setLayout(null);

        l5=new JLabel();
        l5.setBounds(0,0,500,270);
        l5.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/bg7.jpg"));
        Image i2 = img.getImage().getScaledInstance(500,270,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        l5.setIcon(i3);

        rb1=new JRadioButton("Checking Account");
        rb1.setBounds(40,150,150,30);
        f.add(rb1);

        rb2=new JRadioButton("Savings Account");
        rb2.setBounds(40,180,150,30);
        f.add(rb2);

        l=new JLabel("Account Id");
        l.setVisible(true);
        l.setBounds(40,50,250,30);
        l.setForeground(Color.WHITE);
        Font F1=new Font("serif",Font.BOLD,25);
        l.setFont(F1);
        l5.add(l);
        f.add(l5);

        t=new JTextField();
        t.setBounds(240,50,220,30);
        l5.add(t);

        l1=new JLabel("Deposit");
        l1.setVisible(true);
        l1.setBounds(40,100,250,30);
        l1.setForeground(Color.WHITE);
        Font F2=new Font("serif",Font.BOLD,25);
        l1.setFont(F2);
        l5.add(l1);
        f.add(l5);

        t1=new JTextField();
        t1.setBounds(240,100,220,30);
        l5.add(t1);

        b=new JButton("Confirm");
        b.setBounds(240,150,100,30);
        b.addActionListener(this);
        l5.add(b);

        b2=new JButton("Cancel");
        b2.setBounds(360,150,100,30);
        b2.addActionListener(this);
        l5.add(b2);

        f.setSize(500,270);
        f.setLocation(450,250);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b){
            String a=t1.getText();
            int j=Integer.parseInt(a);
            String in=t.getText();
            File dataRead=new File("E:\\Assignment\\5th_Semester\\CSE110_LAB\\Practice\\IntelliJ_Codes\\CustomerData.txt");
            Scanner input= null;
            try {
                input = new Scanner(dataRead);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while(input.hasNextLine()){
                list.add(input.nextLine());
                counter++;
            }
            for(int i=0;i<list.size();i++){
                if(list.get(i).equals(in)){
                    flag=1;
                    if(rb1.isSelected()){
                        String store= list.get(i+8);
                        int de=Integer.valueOf(store);
                        int total=de+j;
                        String add=String.valueOf(total);
                        list.set(i+8,add);
                        break;
                    }
                    else{
                        String store= list.get(i+8);
                        int de=Integer.valueOf(store);
                        int total=de+j;
                        int cdTotal=total*3;
                        String cdTotal1=String.valueOf(cdTotal);
                        String add=String.valueOf(total);
                        list.set(i+8,add);
                        list.set(i+11,cdTotal1);
                        break;
                    }

                }
            }
            if(flag==0){
                JOptionPane.showMessageDialog(null,"Customer Not found");
                f.setVisible(false);
                new AccountAction();
            }
            else{
                File dataFile=new File("E:\\Assignment\\5th_Semester\\CSE110_LAB\\Practice\\IntelliJ_Codes\\CustomerData.txt");
                PrintWriter write= null;
                try {
                    write = new PrintWriter(dataFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                for(int m=0;m< list.size();m++){
                    write.println(list.get(m));
                }
                write.flush();
                write.close();
                JOptionPane.showMessageDialog(null,"Deposit Successful!");
                f.setVisible(false);
                new AccountAction();
            }

        }

        if(ae.getSource()==b2){
            JOptionPane.showMessageDialog(null,"Exit Panel");
            f.setVisible(false);
            new AccountAction();
        }
    }


}
