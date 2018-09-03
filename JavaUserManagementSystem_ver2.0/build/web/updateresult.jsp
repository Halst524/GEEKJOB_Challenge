<%@page import="java.util.ArrayList"%>
<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans udb = (UserDataBeans)request.getAttribute("udb");
    ArrayList chkList = udb.chkproperties();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <% if(chkList.size() == 0){ 
            out.print("<h1>変更結果</h1><br>");
            out.print("<table border=\"2\">");
            out.print("<tr><td>名前</td><td>" + udb.getName() + "</td></tr>");
            out.print("<tr><td>生年月日</td><td>" + udb.getYear() + "年" + udb.getMonth() + "月" + udb.getDay() + "日</td></tr>");
            out.print("<tr><td>種別</td><td>" + jh.exTypenum(udb.getType()) + "</td></tr>");
            out.print("<tr><td>電話番号</td><td>" + udb.getTell() + "</td></tr>");
            out.print("<tr><td>自己紹介</td><td>" + udb.getComment() + "</td></tr>");
            out.print("</table>");
            out.print("以上の内容で登録しました。<br>");
        } else { %>
        <h1>入力が不完全です</h1>
        <%=jh.chkinput(chkList) %>
        <% } %>

        <a href="ResultDetail?id=<%= udb.getUserID() %>">詳細画面へ戻る</a>
    </body>
</html>
