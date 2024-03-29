
package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class DocGia {
    private int id;
    private String ten;
    private Date ngaySinh;
    private String gioiTinh;
    private Date ngayDK;
    private String sdt;

    public DocGia(int id, String ten, Date ngaySinh, String gioiTinh, Date ngayDK, String sdt) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.ngayDK = ngayDK;
        this.sdt = sdt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        if (ngaySinh == null){
            return "";
        }
        String formatSTR = format.format(ngaySinh);
        return formatSTR;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgayDK() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        if (ngayDK == null){
            return "";
        }
        String formatSTR = format.format(ngayDK);
        return formatSTR;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
}
