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
import controller.QuanLyDocGia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 *
 * @author HP-TGL
 */
@WebServlet(name = "DocGiaServlet", urlPatterns = {"/DocGiaServlet"})
public class DocGiaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet DocGiaServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet DocGiaServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        
        request.getRequestDispatcher("DocGiaView.jsp").forward(request, response);
    }
    void setTruong(HttpServletRequest request, QuanLyDocGia quanLyDocGia, String id){
//        try{
//            SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
//            String ngaySinh = quanLyDocGia.getDocGia(Integer.parseInt(id)).getNgaySinh();
//            Date parsedDate = format.parse(ngaySinh);
//            request.setAttribute("ngaySinhChon", quanLyDocGia.getDocGia(Integer.parseInt(id)).getNgaySinhDate());
//        }catch(Exception e){
//            System.out.println(e.toString());
//        }
        
        request.setAttribute("idChon", quanLyDocGia.getDocGia(Integer.parseInt(id)).getId());
        request.setAttribute("tenChon", quanLyDocGia.getDocGia(Integer.parseInt(id)).getTen());
        request.setAttribute("gioiTinhChon", quanLyDocGia.getDocGia(Integer.parseInt(id)).getGioiTinh());
        request.setAttribute("sdtChon", quanLyDocGia.getDocGia(Integer.parseInt(id)).getSdt());
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InitialContext context;
        try {
            context = new InitialContext();
            QuanLyDocGia quanLyDocGia = (QuanLyDocGia) context.lookup(QuanLyDocGia.class.getName());
            request.setAttribute("danhSachDocGia", quanLyDocGia.getDSDocGia());
            String id = request.getParameter("id");
            if (id !=null && !id.equals("")){
                setTruong(request,quanLyDocGia,id);
                request.setAttribute("btnStatus", "btnSua");
            }
            else{
                request.setAttribute("btnStatus", "btnThem");
            }
        } catch (NamingException ex) {
            Logger.getLogger(DocGiaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String tenParam = request.getParameter("ten");
        String gioiTinhParam = request.getParameter("gioiTinh");
        String ngaySinhParam = request.getParameter("ngaySinh");
        String soDienThoaiParam = request.getParameter("sdt");
        String btn= request.getParameter("btn");
        if(btn!=null&& !btn.equals("")){
            System.out.println(btn);
        }
        
        InitialContext context;
        try {
            context = new InitialContext();
            QuanLyDocGia quanLyDocGia = (QuanLyDocGia) context.lookup(QuanLyDocGia.class.getName());
            Date ngaySinhConvert= null;
            try {
                if(ngaySinhParam != null && !ngaySinhParam.equals("")){
                    ngaySinhConvert = new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinhParam);
                }
                    System.out.println("Chọn nút");
                    if(btn.contains("T")){
                        System.out.println("Chọn nút thêm");
                        String ketQua=quanLyDocGia.themDocGia(tenParam, ngaySinhConvert, gioiTinhParam, soDienThoaiParam);
                        if (ketQua.equals("1")){
                            request.setAttribute("message", "Thêm thành công");
                        }
                        else{
                            request.setAttribute("message", ketQua);
                        }
                    }
                    else if(btn.contains("S")){
                        System.out.println("Chọn nút sửa");
                        String ketQua=quanLyDocGia.suaDocGia(Integer.parseInt(idParam),tenParam, ngaySinhConvert, gioiTinhParam, soDienThoaiParam);
                        if (ketQua.equals("1")){
                            request.setAttribute("message", "Sửa thành công");
                        }
                        else{
                            request.setAttribute("message", ketQua);
                        }
                    }
                    else if(btn.contains("X")){
                        System.out.println("Chọn nút xóa");
                        String ketQua=quanLyDocGia.xoaDocGia(Integer.parseInt(idParam));
                        if (ketQua.equals("1")){
                            request.setAttribute("message", "Xóa thành công");
                        }
                        else{
                            request.setAttribute("message", ketQua);
                        }
                    }
                
            } catch (ParseException ex) {
                Logger.getLogger(DocGiaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            request.setAttribute("danhSachDocGia", quanLyDocGia.getDSDocGia());
        } catch (NamingException ex) {
            Logger.getLogger(DocGiaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
