/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author May10
 */
public class HoaDon {
    private String mahd;
    private String manv;
    private int tongtien;
    private Date ngay;
    private String gio;

    public HoaDon(String mahd, String manv, int tongtien, Date date, String time) {
        this.mahd = mahd;
        this.manv = manv;
        this.tongtien = tongtien;
        this.ngay = date;
        this.gio = time;
    }

    public HoaDon() {
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date date) {
        this.ngay = date;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String time) {
        this.gio = time;
    }
    
    
}
