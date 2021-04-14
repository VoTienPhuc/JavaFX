/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author May10
 */
public class ChiTietHoaDon {
    private String mahd;
    private String mamon;
    private String tenmon;
    private int dongia;
    private int soluong;
    private int thanhtien;
    private String ghichu;

    public ChiTietHoaDon(String mahd, String mamon, String tenmon, int dongia, int soluong, int thanhtien, String ghichu) {
        this.mahd = mahd;
        this.mamon = mamon;
        this.tenmon = tenmon;
        this.dongia = dongia;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
        this.ghichu = ghichu;
    }

    public ChiTietHoaDon() {
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
    
    
}
