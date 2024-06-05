
package com.Test;

import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginDetails extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginDetails</title>");   
            out.println("<link rel='stylesheet' href='newcss.css'>");
            out.println("</head>");
            out.println("<body>");
            String name = request.getParameter("user_name");
            String password = request.getParameter("user_pass");
            int count=0;
            try{
                String sqlurl = "jdbc:mysql://localhost:3306/ems?zeroDateTimeBehavior=CONVERT_TO_NULL"; 
                String sqlname = "root";
                String sqlpassword="root@123";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(sqlurl, sqlname, sqlpassword);
		String query =" select * from user_data;";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
                ArrayList<String> tname =new ArrayList<>();
                ArrayList<String> uname =new ArrayList<>();
                ArrayList<String> upass =new ArrayList<>();
		while(rs.next()) {
		String user_name = rs.getString(1);
                String nn = rs.getString(3);
                String tpass = rs.getString(2);
                tname.add(""+user_name+"");
                uname.add(""+nn+"");
                upass.add(""+tpass+"");
                }
                for(int i=0;i<tname.size();i++){
                    if(name.equals(tname.get(i)) ){
                        if(password.equals(upass.get(i))){
                        out.println("<header><ul><li><a href='Login'>Logout</a></li><li><a href='index.html'>Home</a></li></ul></header>");
                        out.println("<div class='center'>");
                        out.println("<div class='container'>");
                        out.println("<h1 style='text-align:center; color:white'> Wellcome "+uname.get(i)+"</h1>");
                        out.println("<div class='center'><div class=''container>");
                        out.println("<ul><li><a href='Show_details'>See More Detail</a></li><li><a href='Generate'>Generate Bill</a></li><li><a href='Calculate'>Calculate Bill</a></li></ul>");
                        out.println("</div></div>");
                        out.println("</div></div>");
                        out.println("</body>");
                        out.println("</html>");
                        break;
                        }
                        else{
                            out.println("<div class='center'>");
                            out.println("<div class='container' style='background-color: grey'>");
                            out.println("<h1 style='text-align:center; color:white'>Worng Password</h1>");
                            out.println("</div></div>");
                            out.println("</body>");
                            out.println("</html>");
                        }
                    }
                    else{
                        count++;
                    }
                }
		st.close();
		con.close();
                if(count == tname.size()){
                    out.println("<div class='center'>");
                    out.println("<div class='container' style='background-color: grey'>");
                    out.println("<h1 style='text-align:center; color:white'> user not found </h1>");
                    out.println("</div></div>");
                    out.println("</body>");
                    out.println("</html>");
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
            
            
            Cookie c = new Cookie("user_name", name);
            response.addCookie(c);
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
