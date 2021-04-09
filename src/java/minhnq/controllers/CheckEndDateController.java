/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import minhnq.daos.RentalDAO;

/**
 *
 * @author Ticket 1
 */
@WebServlet(name = "CheckEndDateController", urlPatterns = {"/CheckEndDateController"})
public class CheckEndDateController extends HttpServlet {

    private final String SUCCESS="feedback.jsp";
    private final String INVALID="HistoryDetailController";
    private final String ERROR="error.jsp";
    
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
        PrintWriter out = response.getWriter();
        String url=ERROR;
        try {
            String txtDetailID=request.getParameter("txtDetailID");
            String rentalID=request.getParameter("rentalID");
            
            RentalDAO dao=new RentalDAO();
            String id=dao.checkEndDate(txtDetailID);
            
            //==null tức là chưa tới hạn chót
            //chưa tới hạn chót nên không feedback được
            if(id==null){
                request.setAttribute("INVALID", "Still not the enddate so you cannot take a feedback!");
                url=INVALID;
            }else{
                request.setAttribute("rentalID", rentalID);
                request.setAttribute("txtDetailID", txtDetailID);
                url=SUCCESS;
            }
            
        }catch(Exception e){
            
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
            out.close();
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
