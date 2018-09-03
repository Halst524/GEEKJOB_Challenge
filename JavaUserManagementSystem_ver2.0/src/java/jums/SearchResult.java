package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class SearchResult extends HttpServlet {

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
        try{
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
            HttpSession hs = request.getSession();
            String str = request.getParameter("previous");
            String chk = "ban";
            String del = request.getParameter("delete");
            if(Objects.equals(chk,str) ||Objects.equals(chk,del)){//str、delが"ban"という条件式(nullの可能性があるstr、delは後ろに配置したほうがよい)
                UserDataBeans udb = (UserDataBeans)hs.getAttribute("condition");
                
                //DTOオブジェクトにマッピング。DB専用のパラメータに変換
                UserDataDTO searchData = new UserDataDTO();
                udb.UD2DTOMapping(searchData);
                hs.setAttribute("condition", udb);
                
                ArrayList resultList = UserDataDAO .getInstance().search(searchData);
                hs.setAttribute("resultList", resultList);
            } else {
                //strが"ban"ではないという条件式(nullの可能性があるstrは後ろに配置したほうがよい)
                //フォームからの入力を取得して、JavaBeansに格納
                int sType = 0;
                if(request.getParameter("type") != null){
                    sType = Integer.parseInt(request.getParameter("type"));
                }
                UserDataBeans udb = new UserDataBeans();
                
                if(del != null){
                    udb.setName("");
                    udb.setYear("");
                } else {
                    udb.setName(request.getParameter("name"));
                    udb.setYear(request.getParameter("year"));
                }
                udb.setType(sType);
                //DTOオブジェクトにマッピング。DB専用のパラメータに変換
                UserDataDTO searchData = new UserDataDTO();
                udb.UD2DTOMapping(searchData);
                hs.setAttribute("condition", udb);

                ArrayList resultList = UserDataDAO .getInstance().search(searchData);
                hs.setAttribute("resultList", resultList);

            }
            
            request.getRequestDispatcher("/searchresult.jsp").forward(request, response);  
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
