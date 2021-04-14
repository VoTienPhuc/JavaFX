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
import model.ChiTietHoaDon;
/**
 *
 * @author May10
 */
public class ChiTietHoaDonDAO {
     private ConnectDB connect;
    private PreparedStatement pre;
    private ResultSet rs;

    public ChiTietHoaDonDAO() {
        connect=new ConnectDB();
    }
    
    public ObservableList<ChiTietHoaDon> selectAll(){
        ObservableList<ChiTietHoaDon> chitiethoadonList=FXCollections.observableArrayList();
        try{
            connect.openConnect();
            String sql="select * from chitiethoadon";
            pre=connect.getCon().prepareCall(sql);
            rs=pre.executeQuery();
            ChiTietHoaDon e;
            while(rs.next())
            {
                e=new ChiTietHoaDon(rs.getString("mahd"),
                            rs.getString("mamon"),
                            rs.getString("tenmon"),
                            rs.getInt("dongia"),
                            rs.getInt("soluong"),
                            rs.getInt("thanhtien"),
                            rs.getString("ghichu"));
                chitiethoadonList.add(e);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            connect.closeConnect();}
        return chitiethoadonList;
    }
     public void insert(ChiTietHoaDon e)
    {
        try{
            connect.openConnect();
            String sql="insert into chitiethoadon values (?,?,?,?,?,?,?)";
            pre=connect.getCon().prepareCall(sql);
            pre.setString(1, e.getMahd());
            pre.setString(2, e.getMamon());
            pre.setString(3, e.getTenmon());
            pre.setInt(4,e.getDongia());
            pre.setInt(5,e.getSoluong());
            pre.setInt(6,e.getThanhtien());
            pre.setString(7,e.getGhichu());
            pre.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            connect.closeConnect();
        }
    }
    public void update(ChiTietHoaDon e)
    {
        try{
            connect.openConnect();
            String sql="update chitiethoadon set mamon=?,tenmon=?,dongia=?,soluong=?,thanhtien=?,ghichu=? where mahd=?";
            pre=connect.getCon().prepareCall(sql);
            pre.setString(1, e.getMamon());
            pre.setString(2, e.getTenmon());
            pre.setInt(3, e.getDongia());
            pre.setInt(4, e.getSoluong());
            pre.setInt(5, e.getThanhtien());
            pre.setString(6, e.getGhichu());
            pre.setString(7, e.getMahd());
            pre.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            connect.closeConnect();
        }
    }

    public void delete(ChiTietHoaDon e)
    {
        try{
            connect.openConnect();
            String sql="update chitiethoadon set dongia=0 where mahd=?";
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
