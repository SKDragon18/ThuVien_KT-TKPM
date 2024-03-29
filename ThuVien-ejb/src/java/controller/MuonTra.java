/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import entity.LichSu;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Administrator
 */

@Remote
public interface MuonTra {
    public List<LichSu> getLichSu();
    public String muonSach(int idSach, int idDocGia, Date ngayMuon);
    public String traSach(int idSach, int idDocGia, Date ngayTra);
    public void showLS();
}
