/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Suryansh Singh
 */
public class Calculate2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Calculate2</title>");
            out.println("<link rel='stylesheet' href='newcss.css'>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<header><ul><li><a href='Login'>Logout</a></li><li><a href='index.html'>Home</a></li></ul></header>");
            Cookie[] cookies = request.getCookies();
            String name = "";
            if(cookies==null){
                out.println("<div class='center'>");
                out.println("<div class='container' style='background-color: grey'>");
                out.println("<h1>You are a new User Go To Home Page</h1>");
                out.println("<a href='/index.html'>home</a>");
                out.println("</div></div>");
            }
            else{
                for(Cookie c : cookies){
                    String tname= c.getName();
                    if(tname.equals("user_name")){
                        name=c.getValue();
                    }
                }
            }
            String Month = request.getParameter("month");
            String year = request.getParameter("year");
            String unit = request.getParameter("units");
            boolean f=false;
            try{
                String sqlurl = "jdbc:mysql://localhost:3306/ems?zeroDateTimeBehavior=CONVERT_TO_NULL"; 
                String sqlname = "root";
                String sqlpassword="root@123";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(sqlurl, sqlname, sqlpassword);
		String query =" select * from bill_data where user_name ='"+name+"';";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
                ArrayList<String> Year =new ArrayList<>();
                ArrayList<String> month =new ArrayList<>();
		while(rs.next()) {
		String user_month = rs.getString(4);
                String user_year = rs.getString(5);
                Year.add(""+user_year+"");
                month.add(""+user_month+"");
                }
                for(int a=0;a<Year.size();a++){
                    if(year.equals(Year.get(a))){
                        if(Month.equals(month.get(a))){
                            
                            f=true;
                        }
                    }
                }
                con.close();
                st.close();
                
                
            }
            catch(Exception e){
                out.println("<div class='center'>");
                out.println("<div class='container' style='background-color: grey'>");
                out.println("<h1 style='text-align:center; color:white'> Something Went Wrong try again </h1>");
                out.println("<h1 style='text-align:center; color:white; overflow:hidden'> "+e+" </h1>");
                out.println("</div></div>");
                
            }
            
            int i=Integer.parseInt(unit);
//            out.println("<h1>"+i+"</h1>");
            var amount = (int) (i*8.40);
//            out.println("<h1>"+amount+"</h1>");
            String s=String.valueOf(amount);
            if(f){
                out.println("<div class='center'>");
                out.println("<div class='container' style='background-color: grey'>");
                out.println("<h1 style='text-align:center; color:white'> Please Enter Different Year,Month</h1>");
                out.println("</div></div>");
            }
            else{
            try{
                String sqlurl = "jdbc:mysql://localhost:3306/ems?zeroDateTimeBehavior=CONVERT_TO_NULL"; 
                String sqlname = "root";
                String sqlpassword="root@123";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(sqlurl, sqlname, sqlpassword);
                String query ="insert into bill_data values(?,?,?,?,?)";
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1, name);
                st.setString(2, unit);
                st.setString(3, s);
                st.setString(4, Month);
                st.setString(5, year);
                st.executeUpdate();
                out.println("<div class='center'>");
                out.println("<div class='container' style='background-color: grey'>");
                out.println("<h1>Data Saved</h1>");
                out.println("<h3 style='text-align:center'>Your Billing Amount is "+s+"</h3>");
                out.println("</div></div>");
                
                con.close();
                st.close();
            }
            catch(Exception e){
                out.println("<div class='center'>");
                out.println("<div class='container' style='background-color: grey'>");
                out.println("<h1 style='text-align:center; color:white'> Something Went Wrong try again </h1>");
                out.println("<h1 style='text-align:center; color:white; overflow:hidden'> "+e+" </h1>");
                out.println("</div></div>");
                
            }
            }
            
            out.println("<h1>Servlet Calculate2 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        
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
