<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)request.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
    <form action="UpdateResult" method="POST">
        <input type="hidden" name="id" value="<%= udd.getUserID() %>">
        名前:
        <input type="text" name="name" value="<%= udd.getName() %>">
        <br><br>
        <% String day = udd.getBirthday().toString();
        String[] days =  day.split("-");
        int[] dayn = new int[days.length];
        for (int i = 0; i < days.length; i++) {
           dayn[i] = Integer.parseInt(days[i]);
        }
        %>
        生年月日:
        <select name="year">
            <%
                for(int i=1950; i<=2010; i++){
                    if(dayn[0] == i){
                        out.println("<option value=\""+i+"\" selected=\"selected\">"+i+"</option>");
                    } else {
                        out.println("<option value=\""+i+"\">"+i+"</option>");
                    }
            } %>
        </select>年
        <select name="month">
            <% for(int i = 1; i<=12; i++){ 
                if(dayn[1] == i){
                    out.println("<option value=\""+i+"\" selected=\"selected\">"+i+"</option>");
                } else {
                    out.println("<option value=\""+i+"\">"+i+"</option>");
                }
            } %>
        </select>月
        <select name="day">
            <% for(int i = 1; i<=31; i++){
                if(dayn[2] == i){
                    out.println("<option value=\""+i+"\" selected=\"selected\">"+i+"</option>");
                } else {
                    out.println("<option value=\""+i+"\">"+i+"</option>");
                }
             } %>
        </select>日
        <br><br>

        種別:
        <br>
            <%
            for(int i = 1; i<=3; i++){
                if(udd.getType() == i){
                    out.println("<input type=\"radio\" name=\"type\" value=\""+i+"\" checked=\"checked\">" + jh.exTypenum(i) + "<br>");
                } else {
                    out.println("<input type=\"radio\" name=\"type\" value=\""+i+"\">" + jh.exTypenum(i) + "<br>");
                }
            } %>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%= udd.getTell() %>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= udd.getComment() %></textarea><br><br>
        
        <input type="submit" name="btnSubmit" value="更新">
    </form>
        <br>
        <a href="ResultDetail?id=<%= udd.getUserID() %>">詳細画面へ戻る</a>
    </body>
</html>
