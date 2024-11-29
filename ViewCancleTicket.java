package AMS;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCancleTicket extends JFrame
{
    JTable t;
    String x[]={"Ticket ID","Source","Destination","Class","Price","Flight code","Flight Name","Journey date","Journey Time","User Name","Name","Reason"}; 
    String y[][]=new String [30][12];
    int i=0,j=0;
    Font f;
    ViewCancleTicket()
    {
        super("All Cancle Flight Details");
        setSize(1300,400);
        setLocation(0,10);
        f=new Font("Arial",Font.BOLD,16);
        
        try
        {
            Connectionclass obj=new Connectionclass();
            String q="select * from cancelFlight";
            ResultSet rest=obj.stm.executeQuery(q);
            while (rest.next())
            {
                y[i][j++]=rest.getString("tid");
                y[i][j++]=rest.getString("source");
                y[i][j++]=rest.getString("destination");
                y[i][j++]=rest.getString("class_name");
                y[i][j++]=rest.getString("price");
                y[i][j++]=rest.getString("fcode");
                y[i][j++]=rest.getString("fname");
                y[i][j++]=rest.getString("journey_date");
                y[i][j++]=rest.getString("journey_time");
                y[i][j++]=rest.getString("useranme");
                y[i][j++]=rest.getString("name");
                y[i][j++]=rest.getString("reason");
                i++;
                j=0;
                
            }
            t=new JTable(y,x);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        t.setFont(f);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);
        JScrollPane js=new JScrollPane(t);
        add(js);
    }
    public static void main(String[] args)
    {
        new ViewCancleTicket().setVisible(true);
    }
}

