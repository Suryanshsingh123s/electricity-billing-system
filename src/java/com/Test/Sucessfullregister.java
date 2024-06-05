
package com.Test;

//import javax.swing.*;  
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sucessfullregister extends HttpServlet {
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Sucessfullregister</title>"); 
            out.println("<link rel='stylesheet' href='newcss.css'>");
            out.println("</head>");
            out.println("<body>");
            
            String name = request.getParameter("uname");
            String uname = request.getParameter("user_name");
            String password = request.getParameter("user_pass");
            String phone = request.getParameter("user_No");
            String email = request.getParameter("user_email");
            String city = request.getParameter("city");
            String meter_no = request.getParameter("meter_no");
            if (!(password.contains("@") || password.contains("#")
              || password.contains("!") || password.contains("~")
              || password.contains("$") || password.contains("%")
              || password.contains("^") || password.contains("&")
              || password.contains("*") || password.contains("(")
              || password.contains(")") || password.contains("-")
              || password.contains("+") || password.contains("/")
              || password.contains(":") || password.contains(".")
              || password.contains(", ") || password.contains("<")
              || password.contains(">") || password.contains("?")
              || password.contains("|"))) {
                out.println("<h1 style='text-align:center; color:white'> Enter Atleast One Special characters </h1>");
                RequestDispatcher rq = request.getRequestDispatcher("Register");
                rq.include(request, response);
            }
            else{
            try{
                String sqlurl = "jdbc:mysql://localhost:3306/ems?zeroDateTimeBehavior=CONVERT_TO_NULL"; 
                String sqlname = "root";
                String sqlpassword="root@123";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(sqlurl, sqlname, sqlpassword);
                String query ="insert into user_data values(?,?,?,?,?,?,?)";
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1, uname);
                st.setString(2, password);
                st.setString(3, name);
                st.setString(4, phone);
                st.setString(5, email);
                st.setString(7, meter_no);
                st.executeUpdate();
                out.println("<header><ul><li><a href='Login'>Login</a></li><li><a href='index.html'>Home</a></li></ul></header>");
                out.println("<div class='center'>");
                out.println("<div class='container' style='background-color: grey'>");
                out.println("<h1>update done</h1>");
                out.println("<h3><a href='Login'>Go To Login Page</a></h3>");
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
