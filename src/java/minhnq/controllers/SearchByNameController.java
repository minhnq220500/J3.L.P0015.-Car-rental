/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import minhnq.daos.CarDAO;
import minhnq.dtos.CarDTO;
import minhnq.dtos.CategoryDTO;

/**
 *
 * @author Ticket 1
 */
@WebServlet(name = "SearchByNameController", urlPatterns = {"/SearchByNameController"})
public class SearchByNameController extends HttpServlet {

    private final String SEARCH_NAME="home.jsp";
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
            
            CarDAO dao=new CarDAO();
            
            String name = request.getParameter("txtSearch");
            int index=1;
            int count=dao.countName(name);
            
            int pageSize = 20;// mỗi trang 20 câu
            int endPage = 0;

            endPage = count / pageSize;
            if(count%pageSize!=0){
                endPage++;
            }
            
            List<CarDTO> list=dao.getListCarByName(name, index, pageSize);
            List<CategoryDTO> list_cate=dao.getListCategory();
            
            if(list!=null){
                request.setAttribute("LIST_CAR", list);
                request.setAttribute("LIST_CATE", list_cate);
                request.setAttribute("endPage", endPage);
                request.setAttribute("INDEX", index);
                url=SEARCH_NAME;
            }
            
        }catch(Exception e){
            log("ERROR At SearchByNameController: " + e.getMessage());
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
