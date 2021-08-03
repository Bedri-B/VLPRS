/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Object.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TreeMap;
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
public class Index extends HttpServlet {

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

        Cookie[] cookies = request.getCookies();
        TreeMap<String, String> map = Current.Cookies(cookies);

        if (map.size() != 0) {
            if (Current.DB.checkUser(map.get("Email")) && Current.DB.CheckSession(map.get("UserID"), map.get("SessionCode"))) {

                User user = Current.Setup(map.get("Email"));
                request.setAttribute("user", user);

                RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
                rd.forward(request, response);
                return;
            } else if (map.size() != 0 && Current.DB.checkAdmin(map.get("Email")) && Current.DB.CheckSession(map.get("UserID"), map.get("SessionCode"))) {

                request.setAttribute("users", Current.Users());
                request.setAttribute("vehicles", Current.DB.FetchVehicleInfo());
                RequestDispatcher rd = request.getRequestDispatcher("Dashboard.jsp");
                rd.forward(request, response);
                return;
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("Indexc.html");
        rd.forward(request, response);

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
