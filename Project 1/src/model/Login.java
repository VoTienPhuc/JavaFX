/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.ConnectDB;

/**
 *
 * @author May10
 */
public class Login {
    private ConnectDB connect = new ConnectDB();
    private PreparedStatement pre;
    private ResultSet rs;
    
    public Util user=new Util();
    public boolean checklogin(String userID,String password)
    {
        try {
            connect.openConnect();
            String sql="select * from user where userID=? and password=?";
            pre=connect.getCon().prepareCall(sql);
            pre.setString(1, userID);
            pre.setString(2, password);
            rs=pre.executeQuery();
            if(rs.next())
            {
                Util.username=rs.getString("manv");
                Util.role=rs.getInt("Role");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            connect.closeConnect();
        }  
        return false;
    }
}
