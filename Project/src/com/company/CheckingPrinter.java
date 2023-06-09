package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class CheckingPrinter implements ActionListener {
    JFrame f;
    JLabel id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id12,id15,id20,lab,lab1;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t11,t16;
    JButton b,b1;
    int counter=0,flag=0;
    ArrayList<String> list=new ArrayList<>();
    CheckingPrinter(){
        f = new JFrame("Customer Details");
        f.setBackground(Color.white);
        f.setLayout(null);

        id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/Layout.png"));
        Image i2 = img.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        id15.setIcon(i3);

        id8 = new JLabel("Customer Details");
        id8.setBounds(320,30,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);


        id1 = new JLabel("Name");
        id1.setBounds(50,200,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,200,150,30);
        id15.add(t1);

        id2 = new JLabel("Father's Name");
        id2.setBounds(400,150,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        id15.add(t2);

        id3= new JLabel("Age");
        id3.setBounds(50,400,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,400,150,30);
        id15.add(t3);

        id4= new JLabel("Date Of Birth");
        id4.setBounds(400,200,200,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        id15.add(t4);

        id5= new JLabel("Address");
        id5.setBounds(50,250,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(200,250,150,30);
        id15.add(t5);

        id6= new JLabel("Phone Number");
        id6.setBounds(400,250,150,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id6);

        t6=new JTextField();
        t6.setBounds(600,250,150,30);
        id15.add(t6);

        id7= new JLabel("Email");
        id7.setBounds(50,300,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id7);

        t7=new JTextField();
        t7.setBounds(200,300,150,30);
        id15.add(t7);

        id9= new JLabel("Current Balance");
        id9.setBounds(400,300,150,30);
        id9.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id9);

        t8=new JTextField();
        t8.setBounds(600,300,150,30);
        id15.add(t8);

        id10= new JLabel("Annual Interest");
        id10.setBounds(50,350,150,30);
        id10.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id10);

        t9=new JTextField();
        t9.setBounds(200,350,150,30);
        id15.add(t9);

        id12= new JLabel("Account ID");
        id12.setBounds(50,150,150,30);
        id12.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id12);

        t11=new JTextField();
        t11.setBounds(200,150,150,30);
        id15.add(t11);


        id20=new JLabel("OverDraft Limit");
        id20.setBounds(50,450,150,30);
        id20.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id20);
        t16=new JTextField();
        t16.setBounds(200,450,150,30);
        id15.add(t16);



        lab=new JLabel();
        lab.setBounds(200,450,250,200);
        id15.add(lab);

        lab1=new JLabel("");
        lab1.setBounds(600,450,250,200);
        id15.add(lab1);

        b = new JButton("Search");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250,550,150,40);

        id15.add(b);

        b1=new JButton("Cancel");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,550,150,40);

        id15.add(b1);

        b.addActionListener(this);
        b1.addActionListener(this);

        f.setVisible(true);
        f.setSize(900,700);
        f.setLocation(400,150);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        String a=t11.getText();
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
            if(ae.getSource()==b){
                    for(int i=0;i<list.size();i++){
                        if(list.get(i).equals(a)){
                                flag=1;
                                t1.setText(list.get(i+1));
                                t3.setText(list.get(i+2));
                                t4.setText(list.get(i+3));
                                t2.setText(list.get(i+4));
                                t5.setText(list.get(i+5));
                                t6.setText(list.get(i+6));
                                t7.setText(list.get(i+7));
                                t8.setText(list.get(i+8));
                                t9.setText(list.get(i+9));
                                t16.setText(list.get(i+10));
                                break;
                            }
                        }
                    if(flag==0){
                        JOptionPane.showMessageDialog(null,"Customer Not found");
                        f.setVisible(false);
                        new AccountAction();
                    }
                    }
            if(ae.getSource()==b1){
                JOptionPane.showMessageDialog(null,"Exit");
                f.setVisible(false);
                new AccountAction();
            }
    }
}

