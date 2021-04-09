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
import minhnq.VerifyRecaptcha.VerifyRecaptcha;
import minhnq.daos.UserDAO;
import minhnq.dtos.UserDTO;

/**
 *
 * @author Ticket 1
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = -6506682026701304964L;
    private final String SUCCESS = "HomeController";
    private final String FAIL = "login.jsp";
    private final String VERIFY_EMAIL="verify.jsp";
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
        try {
            /* TODO output your page here. You may use following sample code. */

            String txtEmail = request.getParameter("txtEmail");
            String txtPassword = request.getParameter("txtPassword");
            // get reCAPTCHA request param
            String gRecaptchaResponse = request
                    .getParameter("g-recaptcha-response");
            System.out.println(gRecaptchaResponse);
            boolean verifyRecaptcha = VerifyRecaptcha.verify(gRecaptchaResponse);
            // get servlet config init params
            // logging example
            System.out.println("User=" + txtEmail + "::password=" + txtPassword + "::Captcha Verify" + verifyRecaptcha);

            UserDAO dao = new UserDAO();
            UserDTO user = dao.checkLogin(txtEmail, txtPassword);

            if (user != null) {
                url = SUCCESS;
                //check recaptcha trước
                if (verifyRecaptcha == false) {
                    request.setAttribute("MISSED", "You missed recaptcha!!");
                    url = FAIL;
                }
                else{
                    //nếu status khác active thì chuyển nó qua trang verify
                    if(!user.getStatus().equals("Active")){
                        url = VERIFY_EMAIL;
                    }
                }
                

                session.setAttribute("LOGIN_USER", user);
            } else {
                request.setAttribute("WRONG", "Wrong email or password");
                url = FAIL;
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
