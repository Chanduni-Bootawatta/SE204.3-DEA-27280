/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PCSM
 */
@WebServlet(urlPatterns = {"/allheaders"})
public class allheaders extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet allheaders</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet allheaders at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      Enumeration<String> headers = request.getHeaderNames();
       
      PrintWriter out = response.getWriter();
      response.setContentType("text/html");
      
      out.println("<ul>");
      while(headers.hasMoreElements()){
          String headerName = headers.nextElement();
          String headerValues = request.getHeader(headerName);
          out.println("<li>"+ headerName +" : " + headerValues +"</li>");
      }
      out.println("</ul>");
    }
}
  