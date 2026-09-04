/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author VY KHANG
 */
public class NhanVien {
   private int maNV ;
    private String hotenNv ;
    private String queQuanNV ; 
    private double luongNV;
    private String namSinhNV;

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getHotenNv() {
        return hotenNv;
    }

    public void setHotenNv(String hotenNv) {
        this.hotenNv = hotenNv;
    }

    public String getQueQuanNV() {
        return queQuanNV;
    }

    public void setQueQuanNV(String queQuanNV) {
        this.queQuanNV = queQuanNV;
    }

    public double getLuongNV() {
        return luongNV;
    }

    public void setLuongNV(double luongNV) {
        this.luongNV = luongNV;
    }

    public String getNamSinhNV() {
        return namSinhNV;
    }

    public void setNamSinhNV(String namSinhNV) {
        this.namSinhNV = namSinhNV;
    }

    public NhanVien(int maNV, String hotenNv, String queQuanNV, double luongNV, String namSinhNV) {
        this.maNV = maNV;
        this.hotenNv = hotenNv;
        this.queQuanNV = queQuanNV;
        this.luongNV = luongNV;
        this.namSinhNV = namSinhNV;
    }

    public NhanVien(String hotenNv, String queQuanNV, double luongNV, String namSinhNV) {
        this.hotenNv = hotenNv;
        this.queQuanNV = queQuanNV;
        this.luongNV = luongNV;
        this.namSinhNV = namSinhNV;
    }
    
}
