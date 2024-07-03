/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pl.polsl.mliszczyk.servlet;

import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pl.polsl.mliszczyk.model.MatrixException;
import pl.polsl.mliszczyk.model.MatrixInterface;
import pl.polsl.mliszczyk.model.Model;

/**
 *
 * @author Maja Liszczyk
 */
@WebServlet(name = "FindWay", urlPatterns = {"/FindWay"})
public class FindWayServlet extends HttpServlet {
    
    /**
     * Model.
     */
    @Inject
    private Model model;

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
        MatrixInterface<Integer> mx;
        HttpSession session = request.getSession();
        mx = (MatrixInterface<Integer>)session.getAttribute("graph");        
        int from = Integer.parseInt(request.getParameter("nodesF")) - 1;
        int to = Integer.parseInt(request.getParameter("nodesE")) - 1;
        String cost = "";
        try{
            cost = model.findWay(from, to, mx);
        }
        catch(MatrixException ex){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Error");
            request.setAttribute("error", ex.getMessage());
            requestDispatcher.forward(request, response);
            
        }
        session.setAttribute("cost", cost);
        response.sendRedirect(request.getContextPath() + "/find_way.jsp");
        /*try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FindWay</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Result</h1>");
            out.println("The lowest cost is: " + cost + "</p>");
            
            //Go back to previous form - Calculation
            out.println("<form action= \"Calculation\">");
            out.println("<input type=\"submit\" value=\"Return\"></p>");
            out.println("</form>");
            //
            
            //Return form beggining
            out.println("<form action= \"Return\">");
            out.println("<input type=\"submit\" value=\"Start from the begginig\"></p>");
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
