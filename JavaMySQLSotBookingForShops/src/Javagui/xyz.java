package Javagui;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
public class xyz extends JFrame
{
    JLabel l1;  
    public xyz()
    {
        setLayout(new FlowLayout());
        l1=new JLabel("Appointments are full");
        add(l1);
    }
}