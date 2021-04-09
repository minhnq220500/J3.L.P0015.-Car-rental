/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import minhnq.daos.CarDAO;
import minhnq.dtos.CarDTO;
import minhnq.dtos.CartDTO;
import minhnq.dtos.UserDTO;

/**
 *
 * @author Ticket 1
 */
@WebServlet(name = "AddController", urlPatterns = {"/AddController"})
public class AddController extends HttpServlet {

    private static final String SUCCESS = "HomeController";
    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "login.jsp";
    private static final String INVALID = "SetDetailCarInformationController";

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
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
        String email = user.getEmail();

        String txtID = request.getParameter("txtID");
        String txtStartDate = request.getParameter("txtStartDate");
        String txtEndDate = request.getParameter("txtReturnDate");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        CarDAO dao = new CarDAO();
        try {
            if (email != null) {

                Date startDate = formatter.parse(txtStartDate);
                Date endDate = formatter.parse(txtEndDate);

                long a = endDate.getTime() - startDate.getTime();
                long numberDay = (a / (60 * 24 * 60 * 1000));//số ngày

                //kiểm tra ngày trước
                if (numberDay <= 0) {
                    request.setAttribute("INVALID", "Start date cannot < Return Date");
                    url = INVALID;
                } else {
                    //nếu thỏa thì đi tiếp
//                    int carQuantity = dao.getCarQuantityByCarID(txtID);

                    //số lượng xe ở trong ngày này
                    int rentedQuantity = dao.countNumberRentedByCarID(txtID, txtStartDate, txtEndDate);

                    if (rentedQuantity == 1) {
                        request.setAttribute("OUT_OF_STOCK", "Car is on rented, please change other date!");
                        url = INVALID;
                    } else {
                        session.removeAttribute("DISCOUNT_CODE");

                        if (txtID == null) {
                            url = SUCCESS;
                        }

                        CarDTO car = dao.getCarByID(txtID);

                        car.setStartDate(txtStartDate);
                        car.setReturnDate(txtEndDate);

                        float price = car.getPrice() * numberDay;

                        car.setPrice(price);

//                //lấy số lượng để so min max
                        CartDTO cart = (CartDTO) session.getAttribute("CART");

                        if (cart == null) {//xem coi giỏ hàng có hay chưa
                            cart = new CartDTO(email);//nếu chưa thì tạo mới giỏ hàng

                        }
                        cart.addToCart(car);
                        session.setAttribute("CART", cart);//cập nhật lại giỏ hàng

                        url = SUCCESS;
                    }
                }

            } else {
                url = LOGIN;
            }

        } catch (Exception e) {
            log("ERROR At AddController: " + e.getMessage());
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
