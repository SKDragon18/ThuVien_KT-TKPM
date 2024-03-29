/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package WebClient;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.QuanLySach;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 *
 * @author HP-TGL
 */
@WebServlet(name = "SachServlet", urlPatterns = {"/SachServlet"})
public class SachServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("SachView.jsp").forward(request, response);
    }
    void setTruong(HttpServletRequest request, QuanLySach quanLySach, String id){

        request.setAttribute("idChon", quanLySach.getSach(Integer.parseInt(id)).getId());
        request.setAttribute("tenChon", quanLySach.getSach(Integer.parseInt(id)).getTen());
        request.setAttribute("sttChon", quanLySach.getSach(Integer.parseInt(id)).getSTT());
        request.setAttribute("tacGiaChon", quanLySach.getSach(Integer.parseInt(id)).getTacGia());
        request.setAttribute("giaChon", quanLySach.getSach(Integer.parseInt(id)).getGia());
        request.setAttribute("tinhTrangChon", quanLySach.getSach(Integer.parseInt(id)).getTinhTrang());
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InitialContext context;
        try {
            context = new InitialContext();
            QuanLySach quanLySach = (QuanLySach) context.lookup(QuanLySach.class.getName());
            request.setAttribute("danhSach", quanLySach.getDSSach());
            String id = request.getParameter("id");
            if (id !=null && !id.equals("")){
                setTruong(request,quanLySach,id);
                request.setAttribute("btnStatus", "btnSua");
            }
            else{
                request.setAttribute("btnStatus", "btnThem");
            }
        } catch (NamingException ex) {
            Logger.getLogger(SachServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String tenParam = request.getParameter("ten");
        String giaParam = request.getParameter("gia");
        String tacGiaParam = request.getParameter("tacGia");
        String sttParam = request.getParameter("stt");
        String tinhTrangParam = request.getParameter("tinhTrang");
        String btn= request.getParameter("btn");
        if(btn!=null&& !btn.equals("")){
            System.out.println(btn);
        }
        
        InitialContext context;
        try {
            context = new InitialContext();
            QuanLySach quanLySach = (QuanLySach) context.lookup(QuanLySach.class.getName());
            System.out.println("Chọn nút");
            if(btn.contains("T")){
                System.out.println("Chọn nút thêm");
                String ketQua=quanLySach.themSach(tenParam, Float.parseFloat(giaParam), tacGiaParam, Integer.parseInt(sttParam), tinhTrangParam);
                if (ketQua.equals("1")){
                    request.setAttribute("message", "Thêm thành công");
                }
                else{
                    request.setAttribute("message", ketQua);
                }
            }
            else if(btn.contains("S")){
                System.out.println("Chọn nút sửa");
                String ketQua=quanLySach.suaSach(Integer.parseInt(idParam),tenParam, Float.parseFloat(giaParam), tacGiaParam, Integer.parseInt(sttParam), tinhTrangParam);
                if (ketQua.equals("1")){
                    request.setAttribute("message", "Sửa thành công");
                }
                else{
                    request.setAttribute("message", ketQua);
                }
            }
            else if(btn.contains("X")){
                System.out.println("Chọn nút xóa");
                String ketQua=quanLySach.xoaSach(Integer.parseInt(idParam));
                if (ketQua.equals("1")){
                    request.setAttribute("message", "Xóa thành công");
                }
                else{
                    request.setAttribute("message", ketQua);
                }
            }
            request.setAttribute("danhSach", quanLySach.getDSSach());
        } catch (NamingException ex) {
            Logger.getLogger(SachServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("btnStatus", "btnThem");
        processRequest(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
