/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class Show_details extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Show_details</title>");    
            out.println("<link rel='stylesheet' href='newcss.css'>");
            out.println("</head>");
            Cookie[] cookies = request.getCookies();
            boolean f=false;
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
                        f=true;
                        name=c.getValue();
                    }
                }
            }
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
                ArrayList<String> unit =new ArrayList<>();
                ArrayList<String> amount =new ArrayList<>();
		while(rs.next()) {
		String user_month = rs.getString(4);
                String user_year = rs.getString(5);
                String user_unit = rs.getString(2);
                String user_amount = rs.getString(3);
                Year.add(""+user_year+"");
                month.add(""+user_month+"");
                unit.add(""+user_unit+"");
                amount.add(""+user_amount+"");
                }
            out.println("<body>");
            out.println("<header><ul><li><a href='Login'>Login</a></li><li><a href='index.html'>Home</a></li></ul></header>");
            
            out.println("<div class='container' style='transform: translate(0%, 40%);background-color: grey'>");
            out.println("<table>");
            out.println("<tr><td style='margin:20px'>Year</td><td>Month</td><td>Unit</td><td>Amount</td></tr>");
                for (int i=0;i<unit.size();i++) {
                    out.println("<tr><td>"+Year.get(i)+"</td><td>"+month.get(i)+"</td><td>"+unit.get(i)+"</td><td>"+amount.get(i)+"</td></tr>");
                }
            out.println("</table>");
            out.println("</div></div>");
            out.println("</body>");
            out.println("</html>");
            }   
            catch(Exception e){
                out.println("<div class='center'>");
                out.println("<div class='container' style='transform: translate(0%, 0%);background-color: grey'>");
                out.println("<h1 style='text-align:center; color:white'> Something Went Wrong try again "+e+"</h1>");
                out.println("</div></div>");
                out.println("</body>");
                out.println("</html>");
            }
    
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
