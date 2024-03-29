package entity;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @tacGia Administrator
 */

public class Sach {
    
    private int id;
    private String ten;
    private float gia;
    private String tacGia;
    private int stt;
    private String tinhTrang;

    public Sach() {
    }

    public Sach(int id, String ten, float gia, String tacGia, int stt, String tinhTrang) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.tacGia = tacGia;
        this.stt = stt;
        this.tinhTrang = tinhTrang;
    }

    public int getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public float getGia() {
        return gia;
    }

    public String getTacGia() {
        return tacGia;
    }

    public int getSTT() {
        return stt;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public void setSTT(int stt) {
        this.stt = stt;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
