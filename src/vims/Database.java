/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vims;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author subin stancil
 */
public class Database 
{
        public Connection conn = null;
        public String dbName = "vims";
        public String userName = "root"; 
        public String password = "";
        public PreparedStatement p;
        public Statement stmt;
        public ResultSet rs;
    
    
    void jdbcConnect()
    {
        try 
        {

            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
                
            System.out.println("success 1");

            System.out.println("Connected to the database");
           Statement stmt=(Statement) conn.createStatement();

        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }    


//    int insert(String sql)
//    {
//        
//        p=conn.prepareStatement(sql)
//        
//        return 0;
//    }


}