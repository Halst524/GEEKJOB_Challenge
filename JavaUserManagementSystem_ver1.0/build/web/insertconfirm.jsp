<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = new UserDataBeans();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <% if((!hs.getAttribute("name").equals(""))&&(!hs.getAttribute("year").equals(""))&&(!hs.getAttribute("month").equals(""))&&(!hs.getAttribute("day").equals(""))&&(!hs.getAttribute("type").equals(""))&&(!hs.getAttribute("tell").equals(""))&&(!hs.getAttribute("comment").equals(""))){ %>
        <h1>登録確認</h1>
        名前:<%= hs.getAttribute("name")%><br>
        生年月日:<%= hs.getAttribute("year")+"年"+hs.getAttribute("month")+"月"+hs.getAttribute("day")+"日"%><br>
        種別:<%= hs.getAttribute("type")%><br>
        電話番号:<%= hs.getAttribute("tell")%><br>
        自己紹介:<%= hs.getAttribute("comment")%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="submit" name="yes" value="はい">
        </form>
        <%
        udb.setName(String.valueOf(hs.getAttribute("name")));
        udb.setYear(String.valueOf(hs.getAttribute("year")));
        udb.setMonth(String.valueOf(hs.getAttribute("month")));
        udb.setDay(String.valueOf(hs.getAttribute("day")));
        udb.setType(String.valueOf(hs.getAttribute("type")));
        udb.setTell(String.valueOf(hs.getAttribute("tell")));
        udb.setComment(String.valueOf(hs.getAttribute("comment")));
        hs.setAttribute("DATA",udb);
        %>

    <% }else{ %>
        <h1>入力が不完全です</h1>
        <%
            if(hs.getAttribute("name").equals("")){out.print("名前が入力されていません<br>");}
            if(hs.getAttribute("year").equals("")){out.print("年が入力されていません<br>");}
            if(hs.getAttribute("month").equals("")){out.print("月が入力されていません<br>");}
            if(hs.getAttribute("day").equals("")){out.print("日が入力されていません<br>");}
            if(hs.getAttribute("type").equals("")){out.print("種別が入力されていません<br>");}
            if(hs.getAttribute("tell").equals("")){out.print("電話番号が入力されていません<br>");}
            if(hs.getAttribute("comment").equals("")){out.print("自己紹介が入力されていません<br>");}
        %>
    <% } %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
