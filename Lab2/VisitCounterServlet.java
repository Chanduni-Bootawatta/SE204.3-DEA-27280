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
import javax.servlet.http.HttpSession;

/**
 *
 * @author PCSM
 */
@WebServlet(urlPatterns = {"/VisitCounterServlet"})
public class VisitCounterServlet extends HttpServlet {

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
            out.println("<title>Servlet VisitCounterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VisitCounterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // Get the session
        HttpSession session = request.getSession();
        
        // Get the current visit count from the session
        Integer visitCount = (Integer) session.getAttribute("visitCount");
        
        // If this is the first visit, initialize the visit count to 1
        if (visitCount == null) {
            visitCount = 1;
        } else {
            // Otherwise, increment the visit count
            visitCount++;
        }
        
        // Store the updated visit count in the session
        session.setAttribute("visitCount", visitCount);
        
        // Create a cookie with the visit count and add it to the response
        Cookie visitCountCookie = new Cookie("visitCount", String.valueOf(visitCount));
        response.addCookie(visitCountCookie);
        
        // Set content type and write the response
        response.setContentType("text/html");
        response.getWriter().println("<html><head><title>Visit Counter</title></head><body>");
        response.getWriter().println("<h1>Visit Counter</h1>");
        response.getWriter().println("<p>You have visited this page " + visitCount + " times.</p>");
        response.getWriter().println("</body></html>");  
    }
}
        
       
    




