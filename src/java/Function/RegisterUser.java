/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import Main.Current;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author E6440
 */
public class RegisterUser extends HttpServlet {

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

        Current.Initialize();
        String Email = request.getParameter("email");
        String PassWord = request.getParameter("password");
        String FirstName = request.getParameter("firstname");
        String LastName = request.getParameter("lastname");
        String Sex = request.getParameter("gender");
        String Dob = request.getParameter("dob");
        String RegArea = request.getParameter("city");
        String Phone = request.getParameter("phone");
        
        

        if (!Current.DB.checkUser(Email) && !Current.DB.checkAdmin(Email)) {
            if (!Current.DB.checkPhoneNo(Phone)) {
                
                Date DoB = new Date(Current.parseDate(Dob));
                Current.DB.RegisterUser(Email, PassWord, FirstName, LastName, Sex, RegArea, Phone, DoB);
                request.setAttribute("msgX", "<div class=\"black-card  padding radius w-80\"> Account Created Successfuly!</div>");
                RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
                rd.forward(request, response);
                return;
            } else {
                //Phone Number Already registered      
                request.setAttribute("msg", "<span class=\"c-red\">Phone Number Already Registered</span>");
                RequestDispatcher rd = request.getRequestDispatcher("RegisterUser.jsp");
                rd.forward(request, response);
                return;
            }
        } else {
            //Email Already registered
            request.setAttribute("msg", "<span class=\\\"c-red\\\">Email Already Registered</span>");
            RequestDispatcher rd = request.getRequestDispatcher("RegisterUser.jsp");
            rd.forward(request, response);
            return;
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
