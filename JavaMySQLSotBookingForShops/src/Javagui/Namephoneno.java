//												***** JAVA MINI PROJECT ******
// FULLY FLEXIBLE SLOT SYSTEM FOR SHOP
// GROUP 17
//19BAI10111 PRACHI BHATT
// 19BAI10115 TOSHINI AGARWAL
// 19BAI10022 AYUSHREE GHOSHAL
// 19BAI10077 RASHMI RAWAT


/* PROBLEM STATEMENT: Problem statement -In regard with the current pandemic situation we aim to  design a slot system that would 
enable people to book their slots (each slot limited to a specific number of customers) and generate token nos to refrain from social gathering .
We have considered a supermarket and assumed that there are different floors each dedicated to one specific item. 
Eg: the first floor for grocery , second for clothes , third for accessories,  fourth for daily essentials . We can restrict the no of people to 20(suppose) for each slot*/


package Javagui;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class Namephoneno extends JFrame implements ActionListener
{
    JLabel l1,l3;
    JButton b1;
    
    JTextField t1,t3;
    String n;
    public Namephoneno(String m)
    {
        n=m;
        setLayout(new FlowLayout());
        l1=new JLabel("Name"); 
        l3=new JLabel("Phone No.");
        t1=new JTextField(22);
        t3=new JTextField(22);
        b1=new JButton("Submit");
        add(l1);
        add(t1);
        add(l3);
        add(t3);
        add(b1);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
        	Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            String da=year+"-"+(month+1)+"-"+day;
            String s1=t1.getText();
            double pno=Double.parseDouble(t3.getText());
            try
            {
                int max=0;
                
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/slotbookingsystem", "root", "prachi13*data");
                System.out.println("Database connection Successful");
                Statement myStmt = myConn.createStatement();
                ResultSet myRs = myStmt.executeQuery("select max(TokenNo) from slotbookingsystem."+n);
                if(myRs.next())
                {
                    max=myRs.getInt(1);
                }
                ++max;
                String sq1 = "insert into "+n+" (TokenNo, Name, PhoneNo, date) values ('"+max+"', '"+s1+"', '"+pno+"', '"+da+"')";
                myStmt.executeUpdate(sq1);
                System.out.println("Insert Successful");
                messagesuccessfullybooked l=new messagesuccessfullybooked();
                l.setBounds(60,120,250,65);
                l.setVisible(true);
                l.setTitle("Thankyou!!");
                
                      
                l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            catch(Exception ae)
            {
                ae.printStackTrace();
            }
        }
    }
}
