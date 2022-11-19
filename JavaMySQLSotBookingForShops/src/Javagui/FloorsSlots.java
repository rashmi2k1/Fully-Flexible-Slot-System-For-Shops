//                                               ***** JAVA MINI PROJECT ******
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
import java.sql.*;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
public class FloorsSlots extends JFrame implements ActionListener
{
    JLabel l1,l2;
    JButton b1;
    JComboBox c1;
    int f;
    
    public static void test(Statement myStmt,String m) throws Exception
    {
    	
       
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String da=year+"-"+(month+1)+"-"+day;
        int count=0;
        ResultSet myRs = myStmt.executeQuery("SELECT count(date) FROM slotbookingsystem."+m+" where date='"+da+"'");
        if(myRs.next())
        {
            count=myRs.getInt(1);
        }
		if(count==5)
        {
        	messageFullslots x=new messageFullslots();
            x.setBounds(60,120,250,65);
            x.setVisible(true);
            x.setTitle("Sorry");
            x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        else
        {
        	Namephoneno p=new Namephoneno(m);
            p.setSize(350,350);
            p.setVisible(true);
            p.setTitle("Fully Flexible Slot System For Shops");
            p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    public FloorsSlots(String field[])
    {
        setLayout(null);
        l1=new JLabel("Select Slot");
        c1=new JComboBox(field);
        b1=new JButton("Next");
        
        add(l1);
        add(c1);
        add(b1);
        
         
         l1.setBounds(70,100,100,25);
         c1.setBounds(150,100,140,25);
         
         b1.setBounds(120,170,80,25);
        c1.addActionListener(this);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==c1)
        {
            JComboBox cb=(JComboBox)ae.getSource();;
            String msg=(String)cb.getSelectedItem();
            switch(msg)
            {
                case "slot1_10AM_to_12AM" : f=1;
                    break;
                case "slot2_1PM_to_3PM" : f=2;
                    break;
                case "slot3_4PM_to_6PM" : f=3;
                    break;
                case "slot4_7PM_to_9PM" : f=4;
                    break;
            }
        }
        if(ae.getSource()==b1)
        {
            try
            {
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/slotbookingsystem", "root", "prachi13*data");
                Statement myStmt = myConn.createStatement();
                int count;
                if(f==1)
                {
                	FloorsSlots.test(myStmt,"slot1_10AM_to_12AM");
                }
                else
                if(f==2)
                {
                	FloorsSlots.test(myStmt,"slot2_1PM_to_3PM");
                }
                else
                if(f==3)
                {
                	FloorsSlots.test(myStmt,"slot3_4PM_to_6PM");
                }
                else
                if(f==4)
                {
                	FloorsSlots.test(myStmt,"slot4_7PM_to_9PM");
                }
               
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
