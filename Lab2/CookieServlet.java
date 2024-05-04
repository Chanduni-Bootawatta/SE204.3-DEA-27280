/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PCSM
 */
@WebServlet(urlPatterns = {"/CookieServlet"})
public class CookieServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CookieServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CookieServlet at " + request.getContextPath() + "</h1>");
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
      
         //Get the Value of the specific cookie
    
        String cookieName = "myCookie";
        String cookieValue= null;
        Cookie[] cookies=request.getCookies();
        if(cookies != null) {
          
          for(Cookie cookie:cookies){
           if(cookie.getName().equals(cookieName)){   
          cookieValue= cookie.getValue();
          break;
      }  
   }
       
 }             
//If the cookie doesn't exist, generate a new one
if (cookieValue == null){
   cookieValue ="V123455" ;
   Cookie newCookie= new Cookie(cookieName,cookieValue);
  
   response.addCookie(newCookie);
}

//Display the value of the cookie
response.setContentType("text/html");
PrintWriter out =response.getWriter();
out.println("<html><body>");
out.println("<h1>Value of the Specific Cookie: " + cookieValue + "</h1>");
out.println("</body></html>");
        }
    }


