/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import entity.Sach;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @tacGia HP-TGL
 */
@Remote
public interface QuanLySach {
    public String themSach(String ten, float gia, String tacGia, int stt, String tinhTrang);
    public String suaSach(int id, String ten, float gia, String tacGia, int stt, String tinhTrang);
    public String xoaSach(int id); 
    public List<Sach> getDSSach();
    public Sach getSach(int id);
}
