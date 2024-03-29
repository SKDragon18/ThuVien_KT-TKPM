
package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class LichSu {
    
    private int idSach;
    private int idDocGia;
    private Date ngayMuon;
    private Date ngayTra;

    public LichSu() {
    }

    @Override
    public String toString() {
        return "LichSu{" + "idSach=" + idSach + ", idDocGia=" + idDocGia + ", ngaymuon=" + ngayMuon + ", ngaytra=" + ngayTra + '}';
    }

    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    public int getIdDocGia() {
        return idDocGia;
    }

    public void setIdDocGia(int idDocGia) {
        this.idDocGia = idDocGia;
    }

    public String getNgayMuon() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        if (ngayMuon == null){
            return "";
        }
        String formatSTR = format.format(ngayMuon);
        return formatSTR;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        if (ngayTra == null){
            return "";
        }
        String formatSTR = format.format(ngayTra);
        return formatSTR;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }
    
    
}
