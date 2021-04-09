/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import minhnq.daos.RentalDAO;
import minhnq.dtos.CarDTO;
import minhnq.dtos.CartDTO;
import minhnq.dtos.UserDTO;

/**
 *
 * @author Ticket 1
 */
@WebServlet(name = "RentalController", urlPatterns = {"/RentalController"})
public class RentalController extends HttpServlet {

    private final String ERROR = "cart.jsp";
    private final String SUCCESS = "HomeController";
    private final String LOGIN = "login.jsp";

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
        try {

            if (email != null) {
                float totalPrice = (float) session.getAttribute("TOTAL_PRICE");
                String DISCOUNT_ID = (String) session.getAttribute("DISCOUNT_ID");
                String status = "True";
                String feedbackContent = null;
                int rateStar = 0;

                CartDTO cart = (CartDTO) session.getAttribute("CART");

                RentalDAO order_dao = new RentalDAO();

                if (cart != null) {
                    String lastID = order_dao.getLastRentalIDByUser(email);
                    String rentalID = null;

                    if (lastID == null) {
                        rentalID = "Rent-" + cart.getEmail() + "-1";
                    } else {
                        String orderIDString[] = lastID.split("-");
                        //tmp[0], tmp[1], tmp[2]
                        String number = orderIDString[2];
                        int numberr = Integer.parseInt(number) + 1;

                        rentalID = "Rent-" + cart.getEmail() + "-" + numberr;
                    }

                    int createOrder = order_dao.createRental(rentalID, totalPrice, new Date(), status, email, DISCOUNT_ID);

                    if (createOrder == 1) {
                        int count = 1;
                        for (CarDTO car : cart.getCart().values()) {

                            String detailID = rentalID + "-" + count;

                            int orderDeatil = order_dao.createRentalDetail(detailID, rentalID, car.getCarID(), car.getPrice(), car.getStartDate(), car.getReturnDate(), feedbackContent, rateStar);

                            if (orderDeatil == 1) {
                                url = SUCCESS;
                            }

                            //
                            count++;
                        }
                    }
                    url = SUCCESS;
                } else {
//                    request.setAttribute("MESSAGE", "List order is empty!!");
                    url = "cart.jsp";
                }
                session.setAttribute("CART", null);
                session.setAttribute("TOTAL_PRICE", null);
            } else {
                url = LOGIN;
            }
        } catch (Exception e) {
            log("Errror at  OrderController: " + e.getMessage());
        } finally {
            response.sendRedirect(url);
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
