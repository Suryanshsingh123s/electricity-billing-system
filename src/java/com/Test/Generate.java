package com.Test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Generate extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Generate</title>"); 
            out.println("<link rel='stylesheet' href='newcss.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<header><ul><li><a href='Login'>Logout</a></li><li><a href='index.html'>Home</a></li></ul></header>");
            out.println("<div class='center'>");
            out.println("<div class='container' style='background-color: grey'>");
            out.println("<h1>Generate Bill</h1>");
            out.println("<form id='myform' action='Generate2' method='post'>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>Enter Your Month : </td>");
            out.println("<td><select id=\"month\" name=\"month\"><option selected>January</option><option>February</option><option>March</option><option>April</option><option>May</option><option>June</option><option>July</option><option>August</option><option>September</option><option>October</option><option>November</option><option>December</option></select></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Enter Your Year : </td><td><select id=\"year\" name=\"year\"><option selected>2000</option><option>2001</option><option>2002</option><option>2003</option><option>2004</option><option>2005</option><option>2006</option><option>2007</option><option>2008</option><option>2009</option><option>2010</option><option>2011</option><option>2012</option><option>2013</option><option>2014</option><option>2015</option><option>2016</option><option>2017</option><option>2018</option><option>2019</option><option>2020</option><option>2021</option><option>2022</option><option>2023</option></select></td>");
            out.println("</table>");
            out.println("<div class=\"center\"><div class=\"central\"><button type=\"submit\" style='margin:10px'>Generate</button></div></div>");
            out.println("</form>");
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
