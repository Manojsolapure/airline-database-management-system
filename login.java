package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JButton bt1,bt2;
    JPasswordField pf;
    JTextField tf;
    JFrame f;
    
    login()
    {
        f = new JFrame("Login Account");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        l1=new JLabel();
        l1.setBounds(0,0,580,350);
        l1.setLayout(null);
        
        ImageIcon img1;
        img1 = new ImageIcon(ClassLoader.getSystemResource("AMS/icons/1.jpg"));
        Image i1=img1.getImage().getScaledInstance(580, 350, Image.SCALE_SMOOTH); 
        ImageIcon img2=new ImageIcon(i1);
        l1.setIcon(img2);
        
        l2=new JLabel("Username:");
        l2.setBounds(120, 120, 150, 30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Arial",Font.BOLD,20));
        l1.add(l2);
        f.add(l1);
         
        
        l3=new JLabel("Login Account");
        l3.setBounds(190, 30, 500, 50);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Arial",Font.BOLD,30));
        l1.add(l3);
        
        l4=new JLabel("Password:");
        l4.setBounds(120, 170, 150, 30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Arial",Font.BOLD,20));
        l1.add(l4);
        
        tf=new JTextField();
        tf.setBounds(250,120,150,30);
        l1.add(tf);
        
        pf=new JPasswordField();
        pf.setBounds(250,170,150,30);
        l1.add(pf);
        
        bt1=new JButton("Login");
        bt1.setBackground(Color.WHITE);
        bt1.setForeground(Color.BLACK);
        bt1.setBounds(100, 230, 140, 35);
        l1.add(bt1);
        
        bt2=new JButton("SighUp");
        bt2.setBackground(Color.WHITE);
        bt2.setForeground(Color.BLACK);
        bt2.setBounds(300, 230, 140, 35);
        l1.add(bt2);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(580,350);
        f.setLocation(300,100);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            String username=tf.getText();
            String password=pf.getText();
            
            try
            {
                Connectionclass obj=new Connectionclass();
                String q = "Select * from Singup where Username= "+username+"and Password= "+password;
                ResultSet rs=obj.stm.executeQuery(q);
                if(rs.next())
                {
                    //new HomePage().setVisible(true);
                    f.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"you have entered wrong username or password!");
                    f.setVisible(false);
                    f.setVisible(true);
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(e.getSource()==bt2)
        {
            this.setVisible(false);
            //new SignupMessage();
        }
        
    }
    public static void main(String[] args)
    {
        new login();
        
    }
    
    
}
