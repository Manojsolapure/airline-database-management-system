package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FlightJourney extends JFrame implements ActionListener
{
    JFrame f;
    JLabel l1,l2,l3;
    JButton b1,b2;
    Choice ch1,ch2;
    
    FlightJourney()
    {
        f=new JFrame("Select Source & Destination");
        f.setBackground(Color.green);
        f.setLayout(null);
        
        l1=new JLabel();
        l1.setBounds(0,0,600,400);
        l1.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("AMS/icons/5.png"));
        Image img1=img.getImage().getScaledInstance(600,400,Image.SCALE_SMOOTH);
        ImageIcon icl=new ImageIcon(img1);
        l1.setIcon(icl);
        
        l2=new JLabel("Source");
        l2.setVisible(true);
        l2.setBounds(100,70,180,40);
        l2.setForeground(Color.white);
        Font F1 = new Font("Arial",Font.BOLD,30);
        l2.setFont(F1);
        l1.add(l2);
        f.add(l1);
        
        l3=new JLabel("Destination");
        l3.setVisible(true);
        l3.setBounds(100,150,180,40);
        l3.setForeground(Color.white);
        l3.setFont(F1);
        l1.add(l3);
        
        ch1=new Choice();
        ch1.setBounds(300,75,190,25);
        
        try
        {
            Connectionclass obj=new Connectionclass();
            String q="Select distinct source from bookedflight";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                ch1.add(rest.getString("source"));
            }
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        ch2=new Choice();
        ch2.setBounds(300,155 ,190,25);
        try
        {
            Connectionclass obj=new Connectionclass();
            String q="select distinct destination from bookedflight";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                ch2.add(rest.getString("destination"));
            }
            rest.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        l1.add(ch1);
        l1.add(ch2);
        ch1.setFont(F1);
        ch2.setFont(F1);

        b1=new JButton("Search");
        b1.setBounds(130,250 ,150,40);
        b1.addActionListener(this);
        l1.add(b1);

        b2=new JButton("Close");
        b2.setBounds(330,250,150,40);
        b2.addActionListener(this);
        b2.setBackground(Color.red);
        b2.setForeground(Color.BLACK);
        l1.add(b2);

        f.setSize(600,400);
        f.setLocation(450,250);
        f.setVisible(true);
    }
    public static void main(String[] args)
    {
        new FlightJourney().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==b2)
        {
            f.setVisible(false);
            new Homepage().setVisible(true); 
            
        }
        if(ae.getSource()==b1)
        {
            f.setVisible(false);
            new FlightJourneyDetails(ch1.getSelectedItem(),ch2.getSelectedItem()).setVisible(true);
        } 
    }

    
}