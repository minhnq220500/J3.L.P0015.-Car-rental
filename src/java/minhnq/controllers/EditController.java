/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "EditController", urlPatterns = {"/EditController"})
public class EditController extends HttpServlet {

    private final String ERROR = "error.jsp";
    private final String SUCCESS = "addMoreCar.jsp";
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
        session.removeAttribute("DISCOUNT_CODE");
        session.removeAttribute("DISCOUNT_ID");
        session.removeAttribute("TOTAL_PRICE_DISCOUNT");
        UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
        String email = user.getEmail();
        CarDAO dao = new CarDAO();
        try {
            if (email != null) {

//                String txtStartDate = request.getParameter("txtStartDate");
//                String txtReturnDate = request.getParameter("txtReturnDate");
//
//                String id = request.getParameter("txtID");
//                float txtPrice = Float.parseFloat(request.getParameter("txtPrice"));
                
                String txtName=request.getParameter("txtName");
                
                List<CarDTO> list=dao.getListCarByName(txtName);//có 3 chiếc giống nhau

                
//                for (CarDTO car : cart.getCart().values()) {
//                    if (car.getCarID().equals(id)) {
//
//                        newCar = dao.getCarByID(id);
//                        newCar.setQuantity(quantity);
//                        newCar.setPrice(txtPrice);
//                        newCar.setStartDate(txtStartDate);
//                        newCar.setReturnDate(txtReturnDate);
//
//                        break;
//                    }

//                }

                Date date=new Date();
                java.sql.Date currentDate = new java.sql.Date(date.getTime());
                        
                request.setAttribute("CURRENT_DATE", currentDate);
                request.setAttribute("LIST_CAR", list);

                url = SUCCESS;
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
