/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet(name = "SearchByDateController", urlPatterns = {"/SearchByDateController"})
public class SearchByDateController extends HttpServlet {

    private final String SEARCH_NAME = "home.jsp";
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

            String txtSearch=request.getParameter("txtSearch");
            String txtDateFrom = request.getParameter("txtDateFrom");
            String txtDateTo = request.getParameter("txtDateTo");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

//            String txtYearF = txtDateFrom.substring(0, 4);
//            String txtYearT = txtDateTo.substring(0, 4);
//            int yearF = Integer.parseInt(txtYearF);
//            int yearT = Integer.parseInt(txtYearT);
//
//            String txtMonthF = txtDateFrom.substring(5, 7);
//            String txtMonthT = txtDateTo.substring(5, 7);
//            int monthF = Integer.parseInt(txtMonthF);
//            int monthT = Integer.parseInt(txtMonthT);
//
//            String txtDayF = txtDateFrom.substring(8, 10);
//            String txtDatT = txtDateTo.substring(8, 10);
//            int dayF = Integer.parseInt(txtDayF);
//            int dayT = Integer.parseInt(txtDatT);
            Date startDate = formatter.parse(txtDateFrom);
            Date endDate = formatter.parse(txtDateTo);

            long a = endDate.getTime() - startDate.getTime();
            long numberDay = (a / (60 * 24 * 60 * 1000));//số ngàyF

            if (numberDay<=0) {
                request.setAttribute("INVALID", "Start date cannot < Return Date");
                url = SEARCH_NAME;
            } else {
                List<CarDTO> list = dao.getAllCar();
                List<CategoryDTO> list_cate = dao.getListCategory();

                for (int i = 0; i < list.size(); i++) {
//                    int quantity=list.get(i).getQuantity();
                    int rentedQuantity = dao.countNumberRentedByCarID(list.get(i).getCarID(), txtDateFrom, txtDateTo);
//                    list.get(i).setAvailableQuantity(quantity-rentedQuantity);
//                    if(list.get(i).getAvailableQuantity()==1){
//                        list.remove(i);
//                        i--;
//                    }
                    if (rentedQuantity == 1) {
                        list.remove(i);
                        i--;
                    }

                }

                int index = 0;
                String indexString = (String) request.getAttribute("INDEX");
                if (indexString == null) {
                    index = 1;
                } else {
                    index = Integer.parseInt(indexString);
                }

                int count = list.size();

                int pageSize = 20;// mỗi trang 20 câu
                int endPage = 0;

                endPage = count / pageSize;
                if (count % pageSize != 0) {
                    endPage++;
                }

                List<CarDTO> list_car = new ArrayList<>();
                for (int i = index * pageSize - pageSize; i < list.size(); i++) {
                    list_car.add(list.get(i));
                }

                if (list_car != null) {
                    request.setAttribute("LIST_CAR", list_car);
                    request.setAttribute("LIST_CATE", list_cate);
                    request.setAttribute("endPage", endPage);
                    request.setAttribute("INDEX", index);
                    url = SEARCH_NAME;
                }
            }

        } catch (Exception e) {
            log("ERROR At SearchByNameController: " + e.getMessage());
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
