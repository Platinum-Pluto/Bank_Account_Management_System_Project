package com.company;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

class Remove implements ActionListener{
    JFrame f;
    JTextField t;
    JLabel l,l5;
    JButton b,b2,b3;
    public String id;
    int counter=0,flag=0;
    ArrayList<String> list=new ArrayList<>();
    Remove(){

        f=new JFrame("Remove");
        f.setBackground(Color.green);
        f.setLayout(null);

        l5=new JLabel();
        l5.setBounds(0,0,500,270);
        l5.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/bg4.jpg"));
        Image i2 = img.getImage().getScaledInstance(500,270,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        l5.setIcon(i3);

        l=new JLabel("Customer ID");
        l.setVisible(true);
        l.setBounds(40,50,250,30);
        l.setForeground(Color.BLACK);
        Font F1=new Font("serif",Font.BOLD,25);
        l.setFont(F1);
        l5.add(l);
        f.add(l5);

        t=new JTextField();
        t.setBounds(240,50,220,30);
        l5.add(t);

        b=new JButton("Checking Account");
        b.setBounds(150,100,200,30);
        b.addActionListener(this);
        l5.add(b);

        b2=new JButton("Cancel");
        b2.setBounds(195,200,100,30);
        b2.addActionListener(this);
        l5.add(b2);

        b3=new JButton("Savings Account");
        b3.setBounds(150,150,200,30);
        b3.addActionListener(this);
        l5.add(b3);

        f.setSize(500,270);
        f.setLocation(450,250);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        id=t.getText();

        if(ae.getSource()==b) {
            File dataRead = new File("E:\\Assignment\\5th_Semester\\CSE110_LAB\\Practice\\IntelliJ_Codes\\CustomerData.txt");
            Scanner input = null;
            try {
                input = new Scanner(dataRead);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while (input.hasNextLine()) {
                list.add(input.nextLine());
                counter++;
            }
            for (int i = 0; i <= list.size(); i++) {
                if (list.get(i).equals(id)) {
                    flag = 1;
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);

                    File dataFile = new File("E:\\Assignment\\5th_Semester\\CSE110_LAB\\Practice\\IntelliJ_Codes\\CustomerData.txt");
                    PrintWriter write = null;
                    try {
                        write = new PrintWriter(dataFile);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    for (int var = 0; var < list.size(); var++) {
                        write.println(list.get(var));
                    }
                    write.flush();
                    write.close();
                    break;
                }

            }
            if (flag == 0) {
                JOptionPane.showMessageDialog(null, "Customer Not found");
                f.setVisible(false);
                new AccountAction();
            }
            if (flag == 1) {
                JOptionPane.showMessageDialog(null, "Account has been removed");
                f.setVisible(false);
                new AccountAction();
            }
        }

        if(ae.getSource()==b2){
            JOptionPane.showMessageDialog(null,"Exit Panel");
            f.setVisible(false);
            new AccountAction();
        }

        if(ae.getSource()==b3){
            File dataRead1 = new File("E:\\Assignment\\5th_Semester\\CSE110_LAB\\Practice\\IntelliJ_Codes\\CustomerData.txt");
            Scanner sc = null;
            try {
                sc = new Scanner(dataRead1);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while (sc.hasNextLine()) {
                list.add(sc.nextLine());
                counter++;
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(id)) {
                    flag = 1;
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);
                    list.remove(i);

                    File dataFile = new File("E:\\Assignment\\5th_Semester\\CSE110_LAB\\Practice\\IntelliJ_Codes\\CustomerData.txt");
                    PrintWriter write = null;
                    try {
                        write = new PrintWriter(dataFile);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    for (int var = 0; var < list.size(); var++) {
                        write.println(list.get(var));
                    }
                    write.flush();
                    write.close();
                    break;
                }

            }
            if (flag == 0) {
                JOptionPane.showMessageDialog(null, "Customer Not found");
                f.setVisible(false);
                new AccountAction();
            }
            if (flag == 1) {
                JOptionPane.showMessageDialog(null, "Account has been removed");
                f.setVisible(false);
                new AccountAction();
            }
        }
    }
}

