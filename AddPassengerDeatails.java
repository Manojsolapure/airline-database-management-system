package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddPassengerDeatails extends JFrame implements ActionListener
{
    JButton bt1,bt2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
    JFrame f;
    AddPassengerDeatails()
    {
        f=new JFrame("Add Passenger Details");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1=new JLabel();
        l1.setBounds(0,0,900,600);
        l1.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("AMS/icons/2.png"));
        Image i1=img.getImage().getScaledInstance(900,600,Image.SCALE_SMOOTH);
        ImageIcon img2=new ImageIcon(i1);
        l1.setIcon(img2);
        
        l2=new JLabel("USERNAME");
        l2.setBounds(50,150,150,30);
        l2.setFont(new Font("Arial",Font.BOLD,20));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        f.add(l1);

        l3=new JLabel("WELCOME TO AIRLINES INDIA");
        l3.setBounds(250,30,550,50);
        l3.setFont(new Font("Arial",Font.BOLD,30));
        l3.setForeground(Color.BLACK);
        l1.add(l3);
        
        tf1=new JTextField();
        tf1.setBounds(200,150,150,30);
        l1.add(tf1);
        
        l4=new JLabel("NAME");
        l4.setBounds(500,150,200,30);
        l4.setFont(new Font("Arial",Font.BOLD,20));
        l4.setForeground(Color.BLACK);
        l1.add(l4);
        
        tf2=new JTextField();
        tf2.setBounds(650,150,150,30);
        l1.add(tf2);  
        
        l5=new JLabel("AGE");
        l5.setBounds(60,210,100,30);
        l5.setFont(new Font("Arial",Font.BOLD,20));
        l5.setForeground(Color.BLACK);
        l1.add(l5);
        
        tf3=new JTextField();
        tf3.setBounds(200,210,150,30);
        l1.add(tf3);
        
        l6=new JLabel("Date Of Birth");
        l6.setBounds(500,210,200,30);
        l6.setFont(new Font("Arial",Font.BOLD,20));
        l6.setForeground(Color.BLACK);
        l1.add(l6);
        
        tf4=new JTextField();
        tf4.setBounds(650,210,150,30);
        l1.add(tf4);
        
        l7=new JLabel("Address");
        l7.setBounds(50,270,100,30);
        l7.setFont(new Font("Arial",Font.BOLD,20));
        l7.setForeground(Color.BLACK);
        l1.add(l7);
        
        tf5=new JTextField();
        tf5.setBounds(200,270,150,30);
        l1.add(tf5);
        
        l8=new JLabel("Phone");
        l8.setBounds(500,270,100,30);
        l8.setFont(new Font("Arial",Font.BOLD,20));
        l8.setForeground(Color.BLACK);
        l1.add(l8);
        
        tf6=new JTextField();
        tf6.setBounds(650,270,150,30);
        l1.add(tf6);
        
        l9=new JLabel("Email Id");
        l9.setBounds(50,330,100,30);
        l9.setFont(new Font("Arial",Font.BOLD,20));
        l9.setForeground(Color.BLACK);
        l1.add(l9);

        tf7=new JTextField();
        tf7.setBounds(200,330,150,30);
        l1.add(tf7);

        l10=new JLabel("Nationality");
        l10.setBounds(500,330,120,30);
        l10.setFont(new Font("Arial",Font.BOLD,20));
        l10.setForeground(Color.BLACK);
        l1.add(l10);

        tf8=new JTextField();
        tf8.setBounds(650,330,150,30);
        l1.add(tf8);
        
        l11=new JLabel("Gender");
        l11.setBounds(50,390,100,30);
        l11.setFont(new Font("Arial",Font.BOLD,20));
        l11.setForeground(Color.BLACK);
        l1.add(l11);

        tf9=new JTextField();
        tf9.setBounds(200,390,150,30);
        l1.add(tf9);
        
        l12=new JLabel("Passport No");
        l12.setBounds(500,390,120,30);
        l12.setFont(new Font("Arial",Font.BOLD,20));
        l12.setForeground(Color.BLACK);
        l1.add(l12);

        tf10=new JTextField();
        tf10.setBounds(650,390,150,30);
        l1.add(tf10);
        
        bt1=new JButton("Save");
        bt1.setBackground(Color.WHITE);
        bt1.setForeground(Color.BLACK);
        bt1.setBounds(250,470,150,40);
        l1.add(bt1);
        
        bt2=new JButton("Close");
        bt2.setBackground(Color.RED);
        bt2.setForeground(Color.BLACK);
        bt2.setBounds(470,470,150,40);
        l1.add(bt2);

        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(900,600);
        f.setLocation(300,100);

    }
   
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            String username=tf1.getText();
            String name=tf2.getText();
            String age=tf3.getText();
            String dob=tf4.getText();
            String address=tf5.getText();
            String phone=tf6.getText();
            String email=tf7.getText();
            String natinality=tf8.getText();
            String gender=tf9.getText();
            String passport=tf10.getText();

            try
            {
                Connectionclass obj=new Connectionclass();
                String q = "insert into passenger values('"+username+"','"+name+"','"+age+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+natinality+"','"+gender+"','"+passport+"')";
                obj.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                f.setVisible(false);
                //new HomePage();
            }
            catch(HeadlessException | SQLException ex)
            {
            }
        
        }
        if(e.getSource()==bt2)
        {
            JOptionPane.showMessageDialog(null,"Are You Sure to cancle");
            f.setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new AddPassengerDeatails();
    }
}
