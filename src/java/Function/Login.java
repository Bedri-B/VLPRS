package Function;

import Main.Current;
import Object.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Current.Initialize();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String Email = request.getParameter("email");
        String Password = request.getParameter("password");

        System.out.println("======>>>> " + Email);
        System.out.println("======>>>> " + Password);
        if (Current.DB.checkUser(Email)) {
            if (Current.DB.Validate(Email, Current.DB.EncryptPassword(Password))) {
                User user = Current.Setup(Email);
                request.setAttribute("user", user);

                Cookie email = new Cookie("Email", Email);
                Cookie userID = new Cookie("UserID", user.getUserid());

                String Session = Current.GenerateSessionCode(user.getUserid());
                String SessionCode = Current.EncryptSessionCode(Session);

                Cookie sessionCode = new Cookie("SessionCode", SessionCode);

                email.setMaxAge(60*60*24*30);
                userID.setMaxAge(60*60*24*30);
                sessionCode.setMaxAge(60*60*24*30);
                
                response.addCookie(email);
                response.addCookie(userID);
                response.addCookie(sessionCode);

                Current.DB.CreateSession(userID.getValue(), SessionCode);
                RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
                rd.forward(request, response);

            } else {
                //Incorrect password 

                request.setAttribute("msg", "<span class=\"c-red\">Incorrect Password</span>");
                RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
                rd.forward(request, response);
                return;
            }
        } else {
            //Email not registered
            request.setAttribute("msg", "<span class=\"c-red\">Email Not Registered</span>");
            RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
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
