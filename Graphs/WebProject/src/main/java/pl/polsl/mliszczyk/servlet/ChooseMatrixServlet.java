/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pl.polsl.mliszczyk.servlet;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import pl.polsl.mliszczyk.model.Matrix;
import pl.polsl.mliszczyk.model.Model;

/**
 *
 * @author Maja
 */
@WebServlet(name = "ChooseMatrixServlet", urlPatterns = {"/ChooseMatrix"})
public class ChooseMatrixServlet extends HttpServlet {
    
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
        
        EntityManager em = model.getEntityManager();
        Query query = em.createQuery("SELECT nameMatrix FROM Matrix nameMatrix"); //JPQL- wrazliwy na wielkosc liter
        List<Matrix> matrixList = query.getResultList();
        request.getSession().setAttribute("matrix", matrixList);
        
        if(matrixList.isEmpty()){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Error");
            request.setAttribute("error", "There is not any matrix in base. First, add new matrix. ");
            requestDispatcher.forward(request, response);
        }
        for (Matrix matrix : matrixList) {
            System.out.println("Found object: " + matrix.getMatrixName());
        }
        response.sendRedirect(request.getContextPath() + "/choose_matrix.jsp");
       /* try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChooseMatrixServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Choose Matrix</h1>");
            
            out.println("<form action= \"Calculation\">");

            //comobox with matrix
            out.println("<select name=\"matrixToChoose\" id=\"matrixToChoose\">");
            for (Matrix matrix : matrixList) {
                out.println("<option value=\"" + matrix.getID() + "\">" + matrix.getMatrixName()+ "</option>");
            }
            out.println("</select>");

            out.println("<p><input type=\"submit\" value=\"I want to start calulation\"></p>");
            out.println("</form>");
            
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
