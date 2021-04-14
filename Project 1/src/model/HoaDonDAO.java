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
import model.HoaDon;
/**
 *
 * @author May10
 */
public class HoaDonDAO {
    private ConnectDB connect;
    private PreparedStatement pre;
    private ResultSet rs;

    public HoaDonDAO() {
        connect=new ConnectDB();
    }
    
    public ObservableList<HoaDon> selectAll(){
        ObservableList<HoaDon> hoadonList=FXCollections.observableArrayList();
        try{
            connect.openConnect();
            String sql="select * from hoadon";
            pre=connect.getCon().prepareCall(sql);
            rs=pre.executeQuery();
            HoaDon e;
            while(rs.next())
            {
                e=new HoaDon(rs.getString("mahd"),
                            rs.getString("manv"),
                            rs.getInt("tongtien"),
                            rs.getDate("ngay"),
                            rs.getString("gio"));
                hoadonList.add(e);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            connect.closeConnect();}
        return hoadonList;
    }
     public void insert(HoaDon e)
    {
        try{
            connect.openConnect();
            String sql="insert into hoadon values (?,?,?,?,?)";
            pre=connect.getCon().prepareCall(sql);
            pre.setString(1, e.getMahd());
            pre.setString(2, e.getManv());
            pre.setInt(3, e.getTongtien());
            java.util.Date utilStartDate = e.getNgay();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
            pre.setDate(4,sqlStartDate);
            pre.setString(5,e.getGio());
            pre.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            connect.closeConnect();
        }
    }
    public void update(HoaDon e)
    {
        try{
            connect.openConnect();
            String sql="update hoadon set manv=?,tongtien=?,ngay=? where mahd=?";
            pre=connect.getCon().prepareCall(sql);
            pre.setString(1, e.getManv());
            pre.setInt(2, e.getTongtien());
            pre.setString(3, e.getNgay().toString());
            pre.setString(3, e.getGio());
            pre.setString(4, e.getMahd());
            pre.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            connect.closeConnect();
        }
    }

    public void delete(HoaDon e)
    {
        try{
            connect.openConnect();
            String sql="update hoadon set ngay=0 where mahd=?";
            pre=connect.getCon().prepareCall(sql);
            pre.setString(1, e.getMahd());
            pre.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            connect.closeConnect();
        }
    }
}
