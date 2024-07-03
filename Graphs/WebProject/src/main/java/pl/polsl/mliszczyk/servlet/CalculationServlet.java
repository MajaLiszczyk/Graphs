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
import pl.polsl.mliszczyk.model.Matrix;
import pl.polsl.mliszczyk.model.MatrixException;
import pl.polsl.mliszczyk.model.Model;

/**
 *
 * @author Maja Liszczyk
 */
@WebServlet(name = "Calculation", urlPatterns = {"/Calculation"})
public class CalculationServlet extends HttpServlet {
    
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
        
        Matrix matrix;
        HttpSession session = request.getSession();
        String mid = request.getParameter("matrixToChoose");
        if(mid != null){
            Long matrixID = Long.valueOf(mid);
            matrix =  model.getEntityManager().find(Matrix.class, matrixID);
            session = request.getSession();
            session.setAttribute("graph", matrix);
        }
        else{
            matrix = (Matrix)session.getAttribute("graph");
        }

        int size = 0;
        try{
            size = matrix.getSize();
        }
        catch(MatrixException ex){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Error");
            request.setAttribute("error", ex.getMessage());
            requestDispatcher.forward(request, response);
            
        }
        
        response.sendRedirect(request.getContextPath() + "/calculation.jsp");
       
        
        /*try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalculationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Find the way</h1>");
            
            //FindWay form begginig
            out.println("<form action= \"FindWay\">");
            
            //Start nodes
            out.println("<label for=\"nodesF\">Choose start node: </label>");
            out.println("<select name=\"nodesF\" id=\"nodesF\">");
            for(int i = 1; i <= size; i++){
                out.println("<option value=\"" + i + "\">" + i+ "</option>");
            }
            out.println("</select>");
            
            //End nodes
            out.println("<label for=\"nodesE\">Choose end node: </label>");
            out.println("<select name=\"nodesE\" id=\"nodesE\">");
            for(int i = 1; i <= size; i++){
                out.println("<option value=\"" + i + "\">" + i+ "</option>");
            }
             out.println("</select>");
             
             out.println("<input type=\"submit\" value=\"Calculate\"></p>");
             out.println("</form>");
             //FindWay form end
                         
            //Return form beggining
            out.println("<form action= \"Return\">");
            out.println("<input type=\"submit\" value=\"Start from the begginig\"></p>");
            out.println("</form>");
            //Return form end
            
            out.println("</body>");
            out.println("</html>");
        } */       
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
