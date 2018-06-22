package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Session2", urlPatterns = {"/Session2"})
public class Session2 extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nam = request.getParameter("Name");
        String gen = request.getParameter("gender");
        String hob = request.getParameter("hobby");
        HttpSession hs = request.getSession();
        hs.setAttribute("name", nam);
        hs.setAttribute("gender", gen);
        hs.setAttribute("hobby", hob);
        if(gen == null){
            gen = "";
        }
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Session2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("氏名<br>");
            out.print("<form action='./Session2' method='post'>");
            out.print("<input type='text' name='Name' value='" + hs.getAttribute("name") + "'><br><br>");
            out.print("性別<br>");
            if(gen.isEmpty()){
                out.print("<input type='radio' name='gender' value='male'>男性 <input type='radio' name='gender' value='female'>女性<br><br>");
            } else if(gen.equals("female")){
                out.print("<input type='radio' name='gender' value='male'>男性 <input type='radio' name='gender' value='female'checked='checked'>女性<br><br>");
            } else if(gen.equals("male")){
                out.print("<input type='radio' name='gender' value='male' checked='checked'>男性 <input type='radio' name='gender' value='female'>女性<br><br>");
            }
            out.print("趣味<br>");
            out.print("<textarea name='hobby'>" + hs.getAttribute("hobby") + "</textarea>");
            out.print("<input type='submit' value='送信'>");
            out.print("</form>");
            out.println("</body>");
            out.println("</html>");
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
