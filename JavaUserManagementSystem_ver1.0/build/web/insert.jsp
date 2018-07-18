<%@page import="jums.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb;
    if(hs.getAttribute("DATA") != null){
        udb = (UserDataBeans)hs.getAttribute("DATA");
    } else {
        udb = new UserDataBeans();
        udb.setName(null);
        udb.setYear(null);
        udb.setMonth(null);
        udb.setDay(null);
        udb.setType(null);
        udb.setTell(null);
        udb.setComment(null);
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value="<%if(udb.getName() != null){out.print(udb.getName());}%>">
        <br><br>

        生年月日:
        <select name="year">
            <option value="">----</option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>" <%
                if(udb.getYear() != null){
                if(udb.getYear().equals(String.valueOf(i))){out.print("selected");}
                }%>> <%=i%> </option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>" <%
                if(udb.getMonth() != null){
                if(udb.getMonth().equals(String.valueOf(i))){out.print("selected");}
                }%>><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>" <%
                if(udb.getDay() != null){
                if(udb.getDay().equals(String.valueOf(i))){out.print("selected");}
                }%>><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1" <%if(udb.getType() != null){if(udb.getType().equals("1")){out.print("checked='checked'");}}%>>エンジニア<br>
        <input type="radio" name="type" value="2" <%if(udb.getType() != null){if(udb.getType().equals("2")){out.print("checked='checked'");}}%>>営業<br>
        <input type="radio" name="type" value="3" <%if(udb.getType() != null){if(udb.getType().equals("3")){out.print("checked='checked'");}}%>>その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%if(udb.getTell() != null){out.print(udb.getTell());}%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard" ><%if(udb.getComment() != null){out.print(udb.getComment());}%></textarea><br><br>

        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">

        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
