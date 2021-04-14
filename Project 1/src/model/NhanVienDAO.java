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
import model.NhanVien;
/**
 *
 * @author Admin
 */
public class NhanVienDAO {
    private ConnectDB connect;
    private PreparedStatement pre;
    private ResultSet rs;
    public NhanVienDAO()
    {
        connect=new ConnectDB();
    }
    
    public ObservableList<NhanVien> selectAll(){
        ObservableList<NhanVien> NhanVienList=FXCollections.observableArrayList();
        try{
            connect.openConnect();
            String sql="select * from nhanvien";
            pre=connect.getCon().prepareCall(sql);
            rs=pre.executeQuery();
            NhanVien e;
            while(rs.next())
            {
                e=new NhanVien( rs.getString("manv"),
                                rs.getString("hoten"),
                                rs.getDate("ngaysinh"),
                                rs.getString("sdt"),
                                rs.getInt("trangthai"));
                NhanVienList.add(e);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            connect.closeConnect();}
        return NhanVienList;
    }
    
    public void insert(NhanVien e)
    {
         try{
             connect.openConnect();
             String sql="insert into nhanvien values (?,?,?,?,?)";
             pre=connect.getCon().prepareCall(sql);
             pre.setString(1, e.getManv());
             pre.setString(2, e.getHoten());
             pre.setDate(3, e.getNgaysinh());
             pre.setString(4,e.getSdt());
             pre.setInt(5, e.getTrangthai());
             pre.executeUpdate();
         }catch(SQLException ex){
             System.out.println(ex.getMessage());
         }finally{
             connect.closeConnect();
         }
    }
    public void update(NhanVien e)
    {
        try{
            connect.openConnect();
            String sql="update nhanvien set hoten=?,ngaysinh=?,sdt=?,trangthai=? where manv=?";
            pre=connect.getCon().prepareCall(sql);
            pre.setString(1, e.getHoten());
            pre.setDate(2,e.getNgaysinh());
            pre.setString(3,e.getSdt());
            pre.setInt(4, e.getTrangthai());
            pre.setString(5, e.getManv());
            pre.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            connect.closeConnect();
        }
    }

    public void delete(NhanVien e)
    {
        try{
            connect.openConnect();
            String sql="update nhanvien set trangthai=0 where manv=?";
            pre=connect.getCon().prepareCall(sql);
            pre.setString(1, e.getManv());
            pre.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            connect.closeConnect();
        }
    }
    
    
}
