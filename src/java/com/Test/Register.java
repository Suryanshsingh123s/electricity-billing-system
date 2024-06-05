
package com.Test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Register</title>");
            out.println("<link rel='stylesheet' href='newcss.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<header>");
            out.println("<ul>");
            out.println("<li><a href='Login'>Login</a></li>");
            out.println("<li><a href='index.html'>Home</a></li>");
            out.println("</ul>");
            out.println("</header>");
            out.println("<div class='center'>");
            out.println("<div class='container' style='background-color: grey; transform: translate(0%, 15%);'>");
            out.println("<h1>Register</h1>");
            out.println("<form id='myform' action='Sucessfullregister' method='post'>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>Enter Your Name : </td>");
            out.println("<td><input type='text' name='uname' placeholder='enter here' required/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Enter Your Username : </td>");
            out.println("<td><input type='text' name='user_name' placeholder='enter here' required/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Enter Your Password : </td><td><input type=\"password\" name=\"user_pass\" placeholder=\"enter here\" pattern=\"(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}\" title=\"Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters\" required/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Enter Meter No : </td><td><input type=\"text\" name=\"meter_no\" placeholder=\"enter here\" required/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Enter Your City : </td><td><input type=\"text\" name=\"city\" placeholder=\"enter here\" required/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Enter Your Phone No : </td>");
            out.println("<td><input type='text' name='user_No' placeholder='enter here' required/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Enter Your Email : </td>");
            out.println("<td><input type='email' name='user_email' placeholder='enter here' required/></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<div class=\"center\"><div class=\"central\"><button type=\"submit\" style='margin:10px'>Register</button><button type=\"reset\">Cancel</button></div></div>");
            out.println("</form>");
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
