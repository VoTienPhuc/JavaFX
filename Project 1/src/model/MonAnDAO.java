/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.ConnectDB;
import model.MonAn;

/**
 *
 * @author May10
 */
public class MonAnDAO {
    private ConnectDB connect;
    private PreparedStatement pre;
    private ResultSet rs;

    public MonAnDAO() {
        connect=new ConnectDB();
    }
    
    public ObservableList<MonAn> selectAll(){
        ObservableList<MonAn> monanList=FXCollections.observableArrayList();
        try{
            connect.openConnect();
            String sql="select * from monan";
            pre=connect.getCon().prepareCall(sql);
            rs=pre.executeQuery();
            MonAn e;
            while(rs.next())
            {
                e=new MonAn(rs.getString("mamon"),
                            rs.getString("tenmon"),
                            rs.getInt("dongia"),
                            rs.getInt("trangthai"));
                monanList.add(e);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            connect.closeConnect();}
        return monanList;
    }
     public void insert(MonAn e)
    {
         try{
             connect.openConnect();
             String sql="insert into monan values (?,?,?,?)";
             pre=connect.getCon().prepareCall(sql);
             pre.setString(1, e.getMamon());
             pre.setString(2, e.getTenmon());
             pre.setInt(3, e.getDongia());
             pre.setInt(4,e.getTrangthai());
             pre.executeUpdate();
         }catch(SQLException ex){
             System.out.println(ex.getMessage());
         }finally{
             connect.closeConnect();
         }
    }
    public void update(MonAn e)
    {
        try{
            connect.openConnect();
            String sql="update monan set tenmon=?,dongia=?,trangthai=? where mamon=?";
            pre=connect.getCon().prepareCall(sql);
            pre.setString(1, e.getTenmon());
            pre.setInt(2, e.getDongia());
            pre.setInt(3, e.getTrangthai());
            pre.setString(4, e.getMamon());
            pre.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            connect.closeConnect();
        }
    }

    public void delete(MonAn e)
    {
        try{
            connect.openConnect();
            String sql="update monan set trangthai=0 where mamon=?";
            pre=connect.getCon().prepareCall(sql);
            pre.setString(1, e.getMamon());
            pre.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            connect.closeConnect();
        }
    }
    
}
