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
import javax.servlet.http.HttpSession;
import minhnq.daos.CarDAO;
import minhnq.dtos.CartDTO;

/**
 *
 * @author Ticket 1
 */
@WebServlet(name = "UseDiscountController", urlPatterns = {"/UseDiscountController"})
public class UseDiscountController extends HttpServlet {

    private final String SUCCESS = "cart.jsp";
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
        HttpSession session = request.getSession();
        String url = ERROR;
        CartDTO cart = (CartDTO) session.getAttribute("CART");
        try {
            /* TODO output your page here. You may use following sample code. */
            if (cart != null) {
                String codeDaSuDung = (String) session.getAttribute("DISCOUNT_CODE");
                if (codeDaSuDung == null) {
                    codeDaSuDung = "";
                }

                CarDAO dao = new CarDAO();
                String txtDiscountCode = request.getParameter("txtDiscountCode");
                int percent = dao.getDiscountPercentByDiscountID(txtDiscountCode);
                String id = dao.getDiscountIDByDiscountCode(txtDiscountCode);

                String checkExpireDate = dao.checkExpireDate(id);// check xem cái code này còn xử dụng được không
                if (checkExpireDate != null) {
                    if (codeDaSuDung.equals(txtDiscountCode)) {
                        url = SUCCESS;
                    } else {

                        float totalPrice = (float) session.getAttribute("TOTAL_PRICE");

                        float discountPrice = totalPrice - totalPrice * percent / 100;
                        session.setAttribute("TOTAL_PRICE_DISCOUNT", discountPrice);

                        session.setAttribute("DISCOUNT_ID", id);//lấy id để tí đưa vào bảng tblRental
                        session.setAttribute("DISCOUNT_CODE", txtDiscountCode);// bỏ vào session để khi nhấn đi nhấn lại nhiều lần thì không bị giảm hoài

                        url = SUCCESS;
                    }
                }else{
                    url=SUCCESS;
                    request.setAttribute("CHECK_EXPIRED", "Can not use this discount code any more!");
                }

            } else {
                url = SUCCESS;
            }

        } catch (Exception e) {

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
