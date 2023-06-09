package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Main  implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    int flag=0;
    ArrayList<String>list=new ArrayList<>();
    Main(){

        f=new JFrame("Login");

        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        f.add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        f.add(l2);

        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        f.add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        f.add(t2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/avatar.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
        f.add(l3);


        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        f.add(b2);
        b2.addActionListener(this);

        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(600,300);
        f.setLocation(400,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){

        try{
            String u = t1.getText();
            String w= String.valueOf(t2.getPassword());

            File dataRead=new File("E:\\Assignment\\5th_Semester\\CSE110_LAB\\Practice\\IntelliJ_Codes\\LoginData.txt");
            Scanner input= null;
            try {
                input = new Scanner(dataRead);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while(input.hasNextLine()){
                list.add(input.nextLine());
            }

            for(int i=0;i< list.size();i++){
                if(u.equals(list.get(i)) && w.equals(list.get(i+1))){
                    new AccountAction().f.setVisible(true);
                    f.setVisible(false);
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                JOptionPane.showMessageDialog(null, "Invalid login");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] arg){
        new Main();
    }
}
