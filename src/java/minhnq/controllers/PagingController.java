/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "PagingController", urlPatterns = {"/PagingController"})
public class PagingController extends HttpServlet {

    private final String SUCCESS = "home.jsp";
    private final String ERROR = "error.jsp";

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
        String url = ERROR;
        try {
            CarDAO dao = new CarDAO();
            String txtSearch = request.getParameter("txtSearch");
            String categoryID = request.getParameter("categoryID");
            String txtDateFrom=request.getParameter("txtDateFrom");
            String txtDateTo=request.getParameter("txtDateTo");

            String indexString = request.getParameter("index");
            int index = Integer.parseInt(indexString);

            if (txtSearch.equals("") && categoryID.equals("") && txtDateFrom.equals("") && txtDateTo.equals(""))  {

                int count = dao.countName(txtSearch);

                int pageSize = 20;// mỗi trang 20 câu
                int endPage = 0;

                endPage = count / pageSize;
                if (count % pageSize != 0) {
                    endPage++;
                }

                List<CarDTO> list = dao.getListCarByName(txtSearch, index, pageSize);
                List<CategoryDTO> list_cate = dao.getListCategory();

                request.setAttribute("endPage", endPage);
                request.setAttribute("SEARCH", txtSearch);
                request.setAttribute("LIST_CAR", list);
                request.setAttribute("LIST_CATE", list_cate);
                request.setAttribute("INDEX", index);
                url = SUCCESS;
            } else if(!txtSearch.equals("")){
                int count = dao.countName(txtSearch);

                int pageSize = 20;// mỗi trang 20 câu
                int endPage = 0;

                endPage = count / pageSize;
                if (count % pageSize != 0) {
                    endPage++;
                }

                List<CarDTO> list = dao.getListCarByName(txtSearch, index, pageSize);
                List<CategoryDTO> list_cate = dao.getListCategory();

                request.setAttribute("endPage", endPage);
                request.setAttribute("SEARCH", txtSearch);
                request.setAttribute("LIST_CAR", list);
                request.setAttribute("LIST_CATE", list_cate);
                request.setAttribute("INDEX", index);
                url = SUCCESS;
            } else if (!categoryID.equals("")) {

                int count = dao.countCategory(categoryID);

                int pageSize = 20;// mỗi trang 20 câu
                int endPage = 0;

                endPage = count / pageSize;
                if (count % pageSize != 0) {
                    endPage++;
                }

                List<CarDTO> list = dao.getListCarByCategory(categoryID, index, pageSize);
                List<CategoryDTO> list_cate = dao.getListCategory();

                request.setAttribute("LIST_CAR", list);
                request.setAttribute("LIST_CATE", list_cate);
                request.setAttribute("endPage", endPage);
                request.setAttribute("INDEX", index);
                url = SUCCESS;
            } else if (!txtDateFrom.equals("") && !txtDateTo.equals("")) {

//                int count = dao.countDate(txtDateFrom, txtDateTo);
//
//                int pageSize = 20;// mỗi trang 20 câu
//                int endPage = 0;
//
//                endPage = count / pageSize;
//                if (count % pageSize != 0) {
//                    endPage++;
//                }
//
//                List<CarDTO> list = dao.getListCarByDate(txtDateFrom, txtDateTo, index, pageSize);
//                List<CategoryDTO> list_cate = dao.getListCategory();
//
//                request.setAttribute("LIST_CAR", list);
//                request.setAttribute("LIST_CATE", list_cate);
//                request.setAttribute("endPage", endPage);
//                request.setAttribute("INDEX", index);
//                url = SUCCESS;

                List<CarDTO> list = dao.getAllCar();
                List<CategoryDTO> list_cate = dao.getListCategory();
                
                for(int i=0;i<list.size();i++){
//                    int quantity=list.get(i).getQuantity();
                    int rentedQuantity=dao.countNumberRentedByCarID(list.get(i).getCarID(), txtDateFrom, txtDateTo);
//                    list.get(i).setAvailableQuantity(quantity-rentedQuantity);
//                    if(list.get(i).getAvailableQuantity()<=0){
//                        list.remove(i);
//                        i--;
//                    }
                    if(rentedQuantity==1){
                        list.remove(i);
                        i--;
                    }
                    
                }
                
                int count = list.size();

                int pageSize = 20;// mỗi trang 20 câu
                int endPage = 0;

                endPage = count / pageSize;
                if (count % pageSize != 0) {
                    endPage++;
                }
                
                List<CarDTO> list_car=new ArrayList<>();
                for(int i=index*pageSize-pageSize;i<list.size();i++){
                    list_car.add(list.get(i));
                }

                if (list_car != null) {
                    request.setAttribute("LIST_CAR", list_car);
                    request.setAttribute("LIST_CATE", list_cate);
                    request.setAttribute("endPage", endPage);
                    request.setAttribute("INDEX", index);
                    url = SUCCESS;
                }

            } 

        } catch (Exception e) {
            log("ERROR At PagingController " + e.getMessage());
        } finally {
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
