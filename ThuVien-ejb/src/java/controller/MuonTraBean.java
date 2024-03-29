/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package controller;

import javax.ejb.Stateless;
import entity.LichSu;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Stateless
public class MuonTraBean implements MuonTra {

    public static List<LichSu> lichSu = new ArrayList<>();
    @Override public List<LichSu> getLichSu(){
        return lichSu;
    }

    public int timKiemLichSuTra(int idSach){
        for (int i =0 ; i<lichSu.size();i++){
            if(lichSu.get(i).getIdSach()==idSach && lichSu.get(i).getNgayTra().equals("")){
                return i;
            }
        }
        return -1;
    }
    @Override
    public String muonSach(int idSach, int idDocGia, Date ngayMuon) {
        try{
            int kq = timKiemLichSuTra(idSach);
            if(kq != -1){
                return "Loi: Sach da duoc muon!!!";
            }
            LichSu lichsu = new LichSu();
            lichsu.setIdSach(idSach);
            lichsu.setIdDocGia(idDocGia);
            lichsu.setNgayMuon(ngayMuon);
            lichSu.add(lichsu);
            return "1";
        }
        catch(Exception e){
            System.out.println("Loi: "+e);
            return "Loi: "+ e;
        }
    }

    @Override
    public String traSach(int idSach, int idDocGia, Date ngayTra) {
        int kq=timKiemLichSuTra(idSach);
        if (kq == -1){
            return "Loi: Khong tim thay lich su muon!!!";
        }
        try{
            lichSu.get(kq).setNgayTra(ngayTra);
            return "1";
        }catch(Exception e){
            System.out.println("Loi: "+e);
            return "Loi: "+ e;
        }
    }
    @Override
    public void showLS(){
        for(int i = 0 ;i<lichSu.size();i++){
            System.out.println(lichSu.get(i).toString());
        }
    }
}