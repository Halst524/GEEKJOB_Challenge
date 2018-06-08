/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
@WebServlet(name = "BackHiki3", urlPatterns = {"/BackHiki3"})
public class BackHiki3 extends HttpServlet {
    int limit = 2;
    int count = 0;
    ArrayList<String> az = new ArrayList<>();
    ArrayList<String> at = new ArrayList<>();
    ArrayList<String> amt = new ArrayList<>();
    void azAdd(){
        az.add("A0001");
        az.add("東 空");
        az.add("2012/05/22");
        az.add("東京都墨田区押上１丁目１−２");
    }
    void atAdd(){
        at.add("A0002");
        at.add("東 透");
        at.add("1958/12/23");
        at.add("東京都港区芝公園４丁目２−８");
    }
    void amtAdd(){
        amt.add("A0003");
        amt.add("天木 通");
        amt.add("1955/07/06");
        amt.add("大阪府大阪市浪速区恵美須東１丁目１８−６");
        amt.remove(3);
    }
    void create(){
        azAdd();
        atAdd();
        amtAdd();
            
    }
    void printer(ArrayList<String> al,PrintWriter pw){
        if(limit <= count){
        } else {
            for(int i = 1; i < 4;i++){
                if(al.get(i) == null){
                    continue;
                }
                    pw.print(al.get(i));
                    pw.print("<br>");
            }
            pw.print("<br>");
        }
        count += 1;
    }

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BackHiki3</title>");            
            out.println("</head>");
            out.println("<body>");
            create();
            printer(az,out);
            printer(at,out);
            printer(amt,out);
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
