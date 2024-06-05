
package com.Test;

import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;  
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Generate2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Generate2</title>");     
            out.println("<link rel='stylesheet' href='newcss.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<header><ul><li><a href='Login'>Logout</a></li><li><a href='index.html'>Home</a></li></ul></header>");
            String Month = request.getParameter("month");
            String year = request.getParameter("year");
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
            try{
                    String sqlurl = "jdbc:mysql://localhost:3306/ems?zeroDateTimeBehavior=CONVERT_TO_NULL";
                    String sqlname = "root";
                    String sqlpassword="root@123";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(sqlurl, sqlname, sqlpassword);
                    String query =" select * from user_data where user_name='"+name+"';";
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    rs.next();
                    out.println("<div class='center'>");
                    out.println("<div class='container' style='transform: translate(0%, 15%);background-color: grey'>");
                    out.println("<h3>Name : "+rs.getString(3)+"</h3>");
                    out.println("<h3>Meter No. : "+rs.getString(7)+"</h3>");
                    out.println("<h3>City : "+rs.getString(6)+"</h3>");
                    out.println("<h3>Phone No : "+rs.getString(4)+"</h3>");
                    out.println("<h3>Email : "+rs.getString(5)+"</h3>");
                    rs.close();
                    st.close();
                    con.close();
                }
            catch(Exception e){
                out.println("<h1>"+e+"</h1>");
            }
            try{
                String sqlurl = "jdbc:mysql://localhost:3306/ems?zeroDateTimeBehavior=CONVERT_TO_NULL"; 
                String sqlname = "root";
                String sqlpassword="root@123";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(sqlurl, sqlname, sqlpassword);
		String query1 =" select * from bill_data where user_name ='"+name+"' and Month_name ='"+Month+"' and year ='"+year+"';";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query1);
		if(rs.next()){
		out.println("<h4>Year : "+rs.getString(5)+"</h4>");
                out.println("<h4>Month : "+rs.getString(4)+"</h4>");
                out.println("<h4>Unit : "+rs.getString(2)+"</h4>");
                out.println("<h4>Amount : "+rs.getString(3)+"</h4>");
                st.close();
                con.close();
                }
            }   
            catch(Exception e){
                out.println("<div class='center'>");
                out.println("<div class='container' style='transform: translate(0%, 0%);background-color: grey'>");
                out.println("<h1 style='text-align:center; color:white'> Something Went Wrong try again "+e+"</h1>");
                out.println("</div></div>");
                out.println("</body>");
                out.println("</html>");
            }

            Cookie c1 = new Cookie("month", Month);
            response.addCookie(c1);
            Cookie c2 = new Cookie("year", year);
            response.addCookie(c2);
            out.println("<ul><li><a href='Print'>Print</a></li></ul>"); 
            out.println("</div></div>");
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
