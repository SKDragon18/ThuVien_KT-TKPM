/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package WebClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.MuonTra;
/**
 *
 * @author Administrator
 */
@WebServlet(name = "MuonTraServlet", urlPatterns = {"/MuonTraServlet"})
public class MuonTraServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("MuonTraView.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InitialContext context;
        try {
            context = new InitialContext();
            MuonTra muonTra = (MuonTra) context.lookup(MuonTra.class.getName());
            request.setAttribute("dsLichSu", muonTra.getLichSu());
        }
        catch(Exception e){
            System.out.println("Loi: "+e.toString());
        }
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String docGiaIdParam = request.getParameter("docGiaId");
        String bookIdParam = request.getParameter("bookId");
        String action = request.getParameter("action");

        if (docGiaIdParam != null && bookIdParam != null && action != null) {
            int docGiaId = Integer.parseInt(docGiaIdParam);
            int bookId = Integer.parseInt(bookIdParam);

            try {
                InitialContext context = new InitialContext();
                MuonTra muonTra = (MuonTra) context.lookup(MuonTra.class.getName());
                String kq = null;
                Date date = new Date();
                if (action.equals("borrow")) {
                    kq=muonTra.muonSach(bookId, docGiaId, date);
                } else {
                    kq=muonTra.traSach(bookId, docGiaId, date);
                }
                if (kq.equals("1")){
                    request.setAttribute("message", "Thành công");
                }
                else{
                    request.setAttribute("message", kq);
                }
                muonTra.showLS();
                request.setAttribute("dsLichSu", muonTra.getLichSu());
            } catch (NamingException | NumberFormatException ex) {
                System.out.println("Loi: "+ex.toString());
                Logger.getLogger(MuonTraServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet for borrowing and returning books";
    }
}
