package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class UpdateInfo implements ActionListener {
    JFrame f;
    JLabel id1,id5,id6,id7,id8,id12,id15,lab,lab1;
    JTextField t1,t5,t6,t7,t11;
    JButton b,b1;
    int counter=0,flag=0;
    ArrayList<String> list=new ArrayList<>();
    UpdateInfo(){
        f = new JFrame("Update Customer Details");
        f.setBackground(Color.white);
        f.setLayout(null);

        id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/bg3.jpg"));
        Image i2 = img.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        id15.setIcon(i3);

        id8 = new JLabel("Update Customer Details");
        id8.setBounds(320,30,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,25));
        id8.setForeground(Color.BLACK);
        id15.add(id8);
        f.add(id15);


        id1 = new JLabel("Name");
        id1.setBounds(50,200,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id1.setForeground(Color.BLACK);
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,200,150,30);
        id15.add(t1);

        id5= new JLabel("Address");
        id5.setBounds(50,250,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id5.setForeground(Color.BLACK);
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(200,250,150,30);
        id15.add(t5);

        id6= new JLabel("Phone Number");
        id6.setBounds(50,350,150,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        id6.setForeground(Color.BLACK);
        id15.add(id6);

        t6=new JTextField();
        t6.setBounds(200,350,150,30);
        id15.add(t6);

        id7= new JLabel("Email");
        id7.setBounds(50,300,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id7.setForeground(Color.BLACK);
        id15.add(id7);

        t7=new JTextField();
        t7.setBounds(200,300,150,30);
        id15.add(t7);

        id12= new JLabel("Account ID");
        id12.setBounds(50,150,150,30);
        id12.setFont(new Font("serif",Font.BOLD,20));
        id12.setForeground(Color.BLACK);
        id15.add(id12);

        t11=new JTextField();
        t11.setBounds(200,150,150,30);
        id15.add(t11);

        lab=new JLabel();
        lab.setBounds(200,450,250,200);
        id15.add(lab);

        lab1=new JLabel("");
        lab1.setBounds(600,450,250,200);
        id15.add(lab1);

        b = new JButton("Update");
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

        if(ae.getSource()==b){
            String name = t1.getText();
            String address = t5.getText();
            String email = t7.getText();
            String num = t6.getText();
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

            for(int i=0;i<list.size();i++){
                if(list.get(i).equals(a)){
                    flag=1;
                    list.set(i+1,name);
                    list.set(i+5,address);
                    list.set(i+6,num);
                    list.set(i+7,email);

                    File dataFile = new File("E:\\Assignment\\5th_Semester\\CSE110_LAB\\Practice\\IntelliJ_Codes\\CustomerData.txt");
                    PrintWriter write = null;
                    try {
                        write = new PrintWriter(dataFile);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    for (int var = 0;  var< list.size(); var++) {
                        write.println(list.get(var));
                    }
                    write.flush();
                    write.close();
                    break;
                }

            }
            if(flag==0){
                JOptionPane.showMessageDialog(null,"Customer Not found");
                f.setVisible(false);
                new AccountAction();
            }
            if(flag==1){
                JOptionPane.showMessageDialog(null, "Details have been updated!");
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

