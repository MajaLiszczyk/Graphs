/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pl.polsl.mliszczyk.servlet;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Maja Liszczyk
 */
@WebServlet(name = "SizeServlet", urlPatterns = {"/Size"})
public class SizeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * Create HTML forms to send back to - Setup or Return - if user wants to start from the beggining with new matrix.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String size = request.getParameter("size");
        String nameMatrix = request.getParameter("nameMatrix");
        try{
            HttpSession session = request.getSession();
            session.setAttribute("size", Integer.valueOf(size));
            session.setAttribute("nameMatrix", String.valueOf(nameMatrix));
            if((nameMatrix==null) || (nameMatrix.length() == 0)){
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Error");
                request.setAttribute("error", "Wrong number format in size or wrong matrix name. ");
                requestDispatcher.forward(request, response); 
            }
        }
        catch(NumberFormatException  ex){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Error");
            request.setAttribute("error", "Wrong number format in size or wrong matrix name. ");
            requestDispatcher.forward(request, response);
        }
        response.sendRedirect(request.getContextPath() + "/size.jsp");

       /* try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SizeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Create your matrix</h1>");
                        
            //Setup form begginig
            out.println("<form action= \"Setup\">");
            out.println("<p>Fill in the fields. Write x if it is infinity: </p>");
            for(int i = 0; i < Integer.parseInt(size) ; i++){
                out.println("<tr>");
                for(int j = 0; j < Integer.parseInt(size) ; j++){
                    out.println("<td><input type=\"text\" size=2 name=\"weight" +i+"" +j + "\"></td>"); //czy musi byc name?
               }
            out.println("<br/>");
            out.println("</tr>");
            }
            out.println("<p><input type=\"submit\" value=\"OK\"></p>");
            out.println("</form>");
            //Setup form end
            
            //Return form beggining
            out.println("<form action= \"Return\">");
            out.println("<input type=\"submit\" value=\"Start from the begginig\">");
            out.println("</form>");
            //Return form end
            
            out.println("</body>");
            out.println("</html>");
        }*/ 
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
