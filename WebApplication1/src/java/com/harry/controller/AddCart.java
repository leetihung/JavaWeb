/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harry.controller;

import static com.harry.controller.ProductServlet.JDBC_DRIVER;
import com.harry.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author leeti
 */
@WebServlet(name = "AddCart", urlPatterns = {"/AddCart"})
public class AddCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/my_test_project?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "root";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            Product p = null;
            int id = 0;
            int bynum = 0;
            if (null == request.getParameter("id")){ id = 0 ;}else{
                id = Integer.parseInt(request.getParameter("id"));
                bynum = Integer.parseInt(request.getParameter("buynum"));
            }
            
            System.out.println(id);
            
            
            
            
            
            try{
                Class.forName(JDBC_DRIVER); 
                Connection con= DriverManager.getConnection(DB_URL , USER , PASS);
                
                String sql= "SELECT * FROM product WHERE idproduct = ?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setInt(1, id);
                
                ResultSet rs = st.executeQuery();
                rs.first();
                                  
                String pname = rs.getString(2);
                String description = rs.getString(3);
                int price = rs.getInt(4);
                System.out.println("Test1");
                p = new Product(id,pname,description,price,bynum);
                System.out.println(p.getBuynum());
                rs.close();
                st.close();
                con.close();
                
                }catch(Exception e){System.out.println("資料庫連節發生問題："+e.toString() );}
            HttpSession session = request.getSession();
            
            List<Product> l = (List<Product>) session.getAttribute("cartList");
            System.out.println(l==null);
            if (l == null && id==0) {
                RequestDispatcher rd = request.getRequestDispatcher("empty.jsp");
                rd.forward(request, response);
                
            }else if(l == null){
                l = new ArrayList<>();
            }
            
            if( id != 0){
                l.add(p);
            }
            
            System.out.println(id != 0);
            int totalprice = 0;
            for (Product i : l) {
                totalprice += i.getPrice()*i.getBuynum(); 		
            }
            System.out.println(totalprice);
            System.out.println();
            session.setAttribute("cartList", l);
            session.setAttribute("price", totalprice);
            RequestDispatcher rd = request.getRequestDispatcher("cartList.jsp");
            rd.forward(request, response);
        }
        System.out.println("test2");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
