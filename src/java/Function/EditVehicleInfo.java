/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import Main.Current;
import Object.VehicleInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author E6440
 */
public class EditVehicleInfo extends HttpServlet {

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

        String PrevChasisNo = request.getParameter("prevchasisno");
        String ownerID = request.getParameter("prevownerid");
        String ChasisNo = request.getParameter("chasisno");
        String MotorNo = request.getParameter("motorno");
        String Brand = request.getParameter("brand");
        String Model = request.getParameter("model");
        String date = request.getParameter("prodyear");
        Date ProdYear = new Date(Current.parseDate(date));
        String SeatsNo = request.getParameter("seatsno");
        String FuelType = request.getParameter("fueltype");
        String MotorSize = request.getParameter("motorsize");
        String HorsePower = request.getParameter("horsepower");
        date = request.getParameter("inspectionyear");
        Date InspectionYear = new Date(Current.parseDate(date));
        String Region = request.getParameter("region");
        String City = request.getParameter("city");
        String Code = request.getParameter("code");

        Current.DB.UpdateVehicle(PrevChasisNo, ChasisNo, MotorNo, ownerID, Brand, Model, ProdYear, Int(SeatsNo), FuelType, Int(MotorSize), Int(HorsePower), InspectionYear, Region, City, Int(Code));

        request.setAttribute("users", Current.Users());
        request.setAttribute("vehicles", Current.DB.FetchVehicleInfo());
        request.setAttribute("msgX", "<div class=\"padding radius black-card w-f mrit bb \">Vehicle Info Updated Successfuly!</div>");
        RequestDispatcher rd = request.getRequestDispatcher("Dashboard.jsp");
        rd.forward(request, response);

    }

    private int Int(String val) {
        return Integer.parseInt(val);
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
