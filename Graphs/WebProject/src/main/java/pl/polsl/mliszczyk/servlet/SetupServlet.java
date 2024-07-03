/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pl.polsl.mliszczyk.servlet;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Enumeration;
import pl.polsl.mliszczyk.model.GraphBuilder;
import pl.polsl.mliszczyk.model.Matrix;
import pl.polsl.mliszczyk.model.MatrixException;
import pl.polsl.mliszczyk.model.Model;

/**
 *
 * @author Maja Liszczyk
 */
@WebServlet(name = "SetupServlet", urlPatterns = {"/Setup"})
public class SetupServlet extends HttpServlet {
    
    /**
     * Graph builder.
     */
    @Inject
    private GraphBuilder graphBuilder;
    
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
        HttpSession session = request.getSession();
        int size = (Integer)session.getAttribute("size");
        String nameMatrix = (String)session.getAttribute("nameMatrix");
        Enumeration<String> e = request.getParameterNames();
        StringBuffer sb = new StringBuffer();
        
        int y = 0;
        EntityManager em = model.getEntityManager();
        
        try{
            while(e.hasMoreElements()){
                for(int x = 0; x < size ; x++){
                    String pn = e.nextElement();
                    String value = request.getParameter(pn);
                    graphBuilder.addElement(x, y, value);
                }
                y++;
            }
            graphBuilder.setSize(size);
            graphBuilder.setMatrixName(nameMatrix);
            Matrix graph = graphBuilder.build();
            
            model.mainAlgorithm(graph);
            em.getTransaction().begin();
            em.persist(graph);
            em.getTransaction().commit();       
            

            session.setAttribute("graph", graph);
        }
        catch(MatrixException ex){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Error");
            request.setAttribute("error", ex.getMessage());
            requestDispatcher.forward(request, response);
        }
        catch (Exception ex) {
            em.getTransaction().rollback();
        } 
        response.sendRedirect(request.getContextPath() + "/setup.jsp");


       /* try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SetupServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Calculate the cost </h1>");

            out.println("<form action= \"Return\">");
            out.println("<p>Matrix added to base </p>");
            out.println("<p><input type=\"submit\" value=\"OK\"></p>");
            out.println("</form>");
            
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
