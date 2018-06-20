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
@WebServlet(name = "BackHiki1", urlPatterns = {"/BackHiki1"})
public class BackHiki1 extends HttpServlet {
    ArrayList<String> prof = new ArrayList<>();
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
    }
    void create(){
        azAdd();
        atAdd();
        amtAdd();
            
    }
    ArrayList<String> search(String id){
        if(id.equals(az.get(0))){
            for(int i = 0;i < az.size();i++){
                prof.add(az.get(i));
            }
        } else if (id.equals(at.get(0))){
            for(int i = 0;i < at.size();i++){
                prof.add(at.get(i));
            }
        } else if(id.equals(amt.get(0))){
            for(int i = 0;i < at.size();i++){
                prof.add(at.get(i));
            }
        }
        prof.add("null");
        prof.add("null");
        return prof;
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
            create();
            search("A001");
            for(int i = 1; i < prof.size();i++){
                out.print(prof.get(i));
                out.print("<br>");
            }
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
