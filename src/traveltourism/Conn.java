/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveltourism;

import java.sql.*;
public class Conn {
    Connection c; //Connection interface
    Statement s; //Statement object
    public Conn()
    {
        try{
            //1.First registering the driver
            Class.forName("com.mysql.jdbc.Driver");
            //2.Creating connection string
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/travel", "root", "rootadmin");
            //3.create Statement
            s = c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println("Error in Connection");
        }
    }
}
