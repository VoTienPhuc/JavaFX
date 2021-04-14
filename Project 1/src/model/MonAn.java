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
public class MonAn {
    private String mamon;
    private String tenmon;
    private int dongia;
    private int trangthai;

    public MonAn(String mamon, String tenmon, int dongia,int trangthai) {
        this.mamon = mamon;
        this.tenmon = tenmon;
        this.dongia = dongia;
        this.trangthai=trangthai;
    }

    public MonAn() {
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

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
   
}
