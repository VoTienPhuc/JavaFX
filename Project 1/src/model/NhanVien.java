/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class NhanVien {
    private String manv;
    private String hoten;
    private Date ngaysinh;
    private String sdt;
    private int trangthai;

    public NhanVien(String manv, String hoten, Date ngaysinh, String sdt, int trangthai) {
        this.manv = manv;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.trangthai = trangthai;
    }   
    
    public NhanVien() {
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
       
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }   
}
