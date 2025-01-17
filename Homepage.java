package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Homepage extends JFrame implements ActionListener
{
    Font f,f1,f2;
    JLabel l1,l2;
    
    Homepage()
    {
        super("Airline India Homepage");
        setLocation(0,0);
        setSize(1550,800);
        
        f=new Font("Lucida Fax",Font.BOLD,20);
        f1=new Font("Gadugi",Font.BOLD,20);
        f2=new Font("MS UI Gothin",Font.BOLD,18);
        
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("AMS/icons/1.png"));
        Image img=ic.getImage().getScaledInstance(1500,800,Image.SCALE_SMOOTH);
        ImageIcon icl=new ImageIcon(img);
        l1=new JLabel(icl);
        
        JMenuBar m1=new JMenuBar();
        JMenu men1=new JMenu("Passenger Profile");
        JMenuItem ment1=new JMenuItem("Add Passenger Profile");
        JMenuItem ment2=new JMenuItem("View Passenger Profile");
        men1.add(ment1);
        men1.add(ment2);
        m1.add(men1);
        
        JMenu men2=new JMenu("Manage Passenger");
        JMenuItem ment3=new JMenuItem("Update Passenger Details");
        men2.add(ment3);
        m1.add(men2);
        
        JMenu men3=new JMenu("Your Flight");
        JMenuItem ment5=new JMenuItem("Book Flight");
        JMenuItem ment6=new JMenuItem("View Booked Flight");
        men3.add(ment5);
        men3.add(ment6);
        m1.add(men3);
        
        JMenu men4=new JMenu("Flight Details");
        JMenuItem ment7=new JMenuItem("Journey Details");
        JMenuItem ment8=new JMenuItem("Flight Zone");
        men4.add(ment7);
        men4.add(ment8);
        m1.add(men4);
        
        JMenu men5=new JMenu("Cancellation");
        JMenuItem ment9=new JMenuItem("Cancle Ticket");
        JMenuItem ment10=new JMenuItem("View Cancle Ticket");
        men5.add(ment9);
        men5.add(ment10);
        m1.add(men5);
        
        JMenu men6=new JMenu("Bill");
        JMenuItem ment11=new JMenuItem("Check Payment");
        men6.add(ment11);
        m1.add(men6);
        
        JMenu men8=new JMenu("Logout");
        JMenuItem ment14=new JMenuItem("Exit");
        men8.add(ment14);
        m1.add(men8);
        
        men1.setFont(f);
        men2.setFont(f);
        men3.setFont(f);
        men4.setFont(f);
        men5.setFont(f);
        men6.setFont(f);
        men8.setFont(f);
        men8.setForeground(Color.RED);
        
        ment1.setFont(f1);
        ment2.setFont(f1);
        ment3.setFont(f1);
        ment5.setFont(f1);
        ment6.setFont(f1);
        ment7.setFont(f1);
        ment8.setFont(f1);
        ment9.setFont(f1);
        ment10.setFont(f1);
        ment11.setFont(f1);
        ment14.setFont(f1);
        
        ment14.setForeground(Color.RED);
        m1.setBackground(new java.awt.Color(4,1,51));
        
        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment3.addActionListener(this);
        ment5.addActionListener(this);
        ment6.addActionListener(this);
        ment7.addActionListener(this);
        ment8.addActionListener(this);
        ment9.addActionListener(this);
        ment10.addActionListener(this);
        ment11.addActionListener(this);
        ment14.addActionListener(this);
        
        setJMenuBar(m1);
        add(l1);
    }
    public void actionPerformed(ActionEvent e)
    {
        String cmd=e.getActionCommand();
        if(cmd.equals("Add Passenger Profile"))
        {
            new AddPassengerDeatails();
        }
        else if(cmd.equals("View Passenger Profile"))
        {
            new Viewpassenger().setVisible(true);
        }
        else if(cmd.equals("Update Passenger Details"))
        {
            new Updatepassenger().setVisible(true);
        }
        else if(cmd.equals("Book Flight"))
        {
            new Bookflight().setVisible(true);
        }
        else if(cmd.equals("View Booked Flight"))
        {
            new ViewBookedFlight().setVisible(true);
        }
        else if(cmd.equals("Journey Details"))
        {
            new FlightJourney().setVisible(true);
        }
        else if(cmd.equals("Flight Zone"))
        {
            new Flightzone().setVisible(true);
        }
        else if(cmd.equals("Cancle Ticket"))
        {
            new CancleFlight().setVisible(true);
        }
        else if(cmd.equals("View Cancle Ticket"))
        {
            new ViewCancleTicket().setVisible(true);
        }
        else if(cmd.equals("Check Payment"))
        {
            new CheckPaymentDetails().setVisible(true);
        }
        else if(cmd.equals("Exit"))
        {
            System.exit(0);
        }
    }
    public static void main(String args[])
    {
        new Homepage().setVisible(true);
    }
}
