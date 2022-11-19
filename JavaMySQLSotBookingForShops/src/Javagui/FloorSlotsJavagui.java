//													***** JAVA MINI PROJECT ******
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
//import java.awt.*;
import java.awt.event.*;
public class FloorSlotsJavagui extends JFrame implements ActionListener
{    
   
	private static final long serialVersionUID = 1L;
	int f;
    JLabel l1,l2;
    JComboBox c1;
    JButton b1;
    public static void wake(String m1,String m2,String m3,String m4)
    {
        String field[]={m1,m2,m3,m4};
        FloorsSlots a=new FloorsSlots(field);
        a.setSize(350,350);
        a.setVisible(true);
        a.setTitle("Fully Flexible Slot System For Shops");
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public FloorSlotsJavagui()
    {
       
        setLayout(null);
        String field[]={"Floor1-Groccery","Floor2-Electronics","Floor3-Fruits and Vegetables","Floor4-Clothing Store"};
        l1=new JLabel("Select Floor");
        c1=new JComboBox(field);
        b1=new JButton("Next");
        add(l1);
        add(c1);
        add(b1);
       // add(l2);
       // l2.setBounds(0,0,350,350);
        l1.setBounds(80,100,100,25);
        c1.setBounds(150,100,200,25);
        b1.setBounds(120,170,80,25);
        c1.addActionListener(this);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==c1)
        {
            JComboBox cb=(JComboBox)e.getSource();;
            String msg=(String)cb.getSelectedItem();
            switch(msg)
            {
                case "Floor1-Groccery" : f=1;
                    break;
                case "Floor2-Electronics" : f=2;
                    break;
                case "Floor3-Fruits and Vegetables" : f=3;
                    break;
                case "Floor4-Clothing Store" : f=4;
                break;
                    
            }
        }
        if(e.getSource()==b1)
        {
            if(f==1)
            {
            	FloorSlotsJavagui.wake("slot1_10AM_to_12AM","slot2_1PM_to_3PM","slot3_4PM_to_6PM","slot4_7PM_to_9PM");
            }
            else
            if(f==2)
            {
            	FloorSlotsJavagui.wake("slot1_10AM_to_12AM","slot2_1PM_to_3PM","slot3_4PM_to_6PM","slot4_7PM_to_9PM");
            }
            else
            if(f==3)
            {
            	FloorSlotsJavagui.wake("slot1_10AM_to_12AM","slot2_1PM_to_3PM","slot3_4PM_to_6PM","slot4_7PM_to_9PM");
            }
            else
                if(f==4)
                {
                	FloorSlotsJavagui.wake("slot1_10AM_to_12AM","slot2_1PM_to_3PM","slot3_4PM_to_6PM","slot4_7PM_to_9PM");
                }
        }
    }
    public static void main(String[] args)
    {
    	FloorSlotsJavagui gui = new FloorSlotsJavagui();
        gui.setSize(350,350);
        
        gui.setVisible(true);
        gui.setTitle("Fully Flexible Slot System For Shops");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
