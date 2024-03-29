/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import entity.DocGia;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author HP-TGL
 */
@Remote
public interface QuanLyDocGia {
    public String themDocGia(String ten, Date ngaySinh, String gioiTinh, String sdt);
    public String suaDocGia(int id, String ten, Date ngaySinh, String gioiTinh, String sdt);
    public String xoaDocGia(int id);
    public List<DocGia> getDSDocGia();
    public DocGia getDocGia(int id);
}
