/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package controller;

import entity.DocGia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class QuanLyDocGiaBean implements QuanLyDocGia{
    public static List<DocGia> dsDocGia = new ArrayList<>();
    public static int index= 0;
    static{
        Date date = new Date();
        DocGia docGia = new DocGia(index,"GKD",date, "nam", date,"0321312");
        index+=1;
        dsDocGia.add(docGia);
        date = new Date();
        docGia = new DocGia(index,"GKD",date, "nam", date,"0321312");
        index+=1;
        dsDocGia.add(docGia);
        date = new Date();
        docGia = new DocGia(index,"GKD",date, "nam", date,"0321312");
        index+=1;
        dsDocGia.add(docGia);
    }
    @Override
    public DocGia getDocGia(int id){
        return dsDocGia.get(id);
    }
    @Override
    public String themDocGia(String ten, Date ngaySinh, String gioiTinh, String sdt) {
        try{
            Date ngayDK = new Date();
            DocGia docGia= new DocGia(index,ten, ngaySinh, gioiTinh, ngayDK,sdt);
            dsDocGia.add(docGia);
            index+=1;
            return "1";
        }catch(Exception e){
            return "Loi: "+ e.toString();
        }
    }
    @Override
    public String suaDocGia(int id, String ten, Date ngaySinh, String gioiTinh, String sdt) {
        try{
            DocGia docGia = dsDocGia.get(id);
            docGia.setGioiTinh(gioiTinh);
            if(ngaySinh != null){
                docGia.setNgaySinh(ngaySinh);
            }
            docGia.setSdt(sdt);
            docGia.setTen(ten);
            return "1";
        }catch(Exception e){
            return "Loi: "+ e.toString();
        }
    }
    @Override
    public String xoaDocGia(int id) {
        try{
           dsDocGia.remove(id);
           return "1";
        }catch(Exception e){
            return "Loi: "+ e.toString();
        }
    }
    @Override
    public List<DocGia> getDSDocGia() {
        return dsDocGia;
    }
}
