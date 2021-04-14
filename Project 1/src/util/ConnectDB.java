/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author May 15
 */
public class ConnectDB {
    private Connection con;

    public ConnectDB(Connection con) {
        this.con = con;
    }

    public ConnectDB() {
        con=null;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public boolean openConnect()
    {
        if(con==null){
            try{
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Food","root","");
                return true;
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
    
     public void closeConnect()
    {
        try{
            if(con!=null){
                con.close();
                con=null;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
