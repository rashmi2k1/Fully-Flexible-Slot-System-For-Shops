package Javagui;
import java.sql.*;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
public class abc extends JFrame implements ActionListener
{
    JLabel l1,l2;
    JButton b1;
    JComboBox c1;
    ImageIcon i1;
    int f;
    public static void test(Statement myStmt,String m) throws Exception
    {
    	int count=0;
        /*Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String da=day+"-"+(month+1)+"-"+year;
        int count=0;
       ResultSet myRs = myStmt.executeQuery("SELECT count(date) FROM appointmentbookingsystem."+m+" where date='"+da+"'");
        if(myRs.next())
        {
            count=myRs.getInt(1);
        }*/
        if(count==5)
        {
            xyz x=new xyz();
            x.setBounds(60,120,250,65);
            x.setVisible(true);
            x.setTitle("Sorry");
            x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        else
        {
            pqr p=new pqr(m);
            p.setSize(350,350);
            p.setVisible(true);
            p.setTitle("Hospital Management System");
            p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    public abc(String field[],String o)
    {
        setLayout(null);
        l1=new JLabel("Select Doctor");
        c1=new JComboBox(field);
        b1=new JButton("Next");
        i1=new ImageIcon(getClass().getResource(o));
        l2=new JLabel(i1);
        add(l1);
        add(c1);
        add(b1);
        add(l2);
         l2.setBounds(0,0,350,350);
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
                case "Dr. Harsh Domadia" : f=1;
                    break;
                case "Dr. Jay Gala" : f=2;
                    break;
                case "Dr. Tushar Kadam" : f=3;
                    break;
                case "Dr. Sangram Desai" : f=4;
                    break;
                case "Dr. Jasdeep Singh" : f=5;
                    break;
                case "Dr. Atharva Gole" : f=6;
                    break;
            }
        }
        if(ae.getSource()==b1)
        {
            try
            {
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointmentbookingsystem", "root", "prachi13*data");
                Statement myStmt = myConn.createStatement();
                int count=0;
                if(f==1)
                {
                    abc.test(myStmt,"harsh_domadia");
                }
                else
                if(f==2)
                {
                    abc.test(myStmt,"jay_gala");
                }
                else
                if(f==3)
                {
                    abc.test(myStmt,"tushar_kadaam");
                }
                else
                if(f==4)
                {
                    abc.test(myStmt,"sangram_desai");
                }
                else
                if(f==5)
                {
                    abc.test(myStmt,"jasdeep_grover");
                }
                else
                if(f==6)
                {
                    abc.test(myStmt,"atharva_gole");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}