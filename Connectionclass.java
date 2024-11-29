package AMS;

import java.sql.*;

public class Connectionclass 
{
    
    Connection con;
    Statement stm;
    
    Connectionclass()
    {
        try
        {
//            class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline","root","12345678");
            stm = con.createStatement();
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            
        }
            
    }
    public static void main(String[] args)
    {
        new Connectionclass(); 
    }
}
