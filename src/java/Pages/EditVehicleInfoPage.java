/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

import Main.Current;
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
public class EditVehicleInfoPage extends HttpServlet {

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
        
        Cookie[] cookies = request.getCookies();
        TreeMap<String, String> map = Current.Cookies(request.getCookies());
        
        if (map.size() != 0 && Current.DB.checkAdmin(map.get("Email")) && Current.DB.CheckSession(map.get("UserID"), map.get("SessionCode"))) {

            String ChasisNo = request.getParameter("chasisno");
            
            ArrayList<String> regions = new ArrayList<String>();
            regions.add("Addis Abeba");
            regions.add("Afar");
            regions.add("Amhara");
            regions.add("Benishangul Gumuz");
            regions.add("Dire Dawa");
            regions.add("Gambela");
            regions.add("Harari");
            regions.add("Oromia");
            regions.add("Sidama");
            regions.add("SNNPR");
            regions.add("Somale");
            regions.add("Tigray");
            
            request.setAttribute("regions", regions);
            request.setAttribute("vehicle", Current.DB.FetchVehicleInfo("ChasisNo", ChasisNo).get(0));
            RequestDispatcher rd = request.getRequestDispatcher("EditVehicle.jsp");
            rd.forward(request, response);
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
