/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package controller;

import entity.Sach;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class QuanLySachBean implements QuanLySach{
    public static List<Sach> dsSach = new ArrayList<>();
    public static int index= 0;
    
    static{
        Sach sach = new Sach(index, "truyen cua toi", 20000, "Ph. Hoa", 1, "tot");
        index+=1;
        dsSach.add(sach);
        sach = new Sach(index, "truyen cua toi", 20000, "Ph. Hoa", 2, "tot");
        index+=1;
        dsSach.add(sach);
        sach = new Sach(index, "truyen cua toi", 20000, "Ph. Hoa", 3, "tot");
        index+=1;
        dsSach.add(sach);
    }
    @Override
    public String themSach(String ten, float gia, String tacGia, int stt, String tinhTrang) {
        try{
            
            Sach sach= new Sach(index,ten, gia, tacGia, stt, tinhTrang);
            dsSach.add(sach);
            index+=1;
            return "1";
        }catch(Exception e){
            return "Loi: "+ e.toString();
        }
    }
    @Override
    public String suaSach(int id, String ten, float gia, String tacGia, int stt, String tinhTrang) {
        try{
            Sach sach = dsSach.get(id);
            sach.setTen(ten);
            sach.setGia(gia);
            sach.setTacGia(tacGia);
            sach.setSTT(stt);
            sach.setTinhTrang(tinhTrang);
            return "1";
        }catch(Exception e){
            return "Loi: "+ e.toString();
        }
    }
    @Override
    public String xoaSach(int id) {
        try{
           dsSach.remove(id);
           return "1";
        }catch(Exception e){
            return "Loi: "+ e.toString();
        }
    }

    @Override
    public List<Sach> getDSSach() {
        return dsSach;
    }

    @Override
    public Sach getSach(int id) {
        return dsSach.get(id);
    }
}
