<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans udb = (UserDataBeans)request.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <h1>変更結果</h1><br>
        <table border="2">
            <tr><td>名前</td><td><%=udb.getName()%></td></tr>
            <tr><td>生年月日</td><td><%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%></td></tr>
            <tr><td>種別</td><td><%=jh.exTypenum(udb.getType())%></td></tr>
            <tr><td>電話番号</td><td><%=udb.getTell()%></td></tr>
            <tr><td>自己紹介</td><td><%=udb.getComment()%></td></tr>
        </table>
        以上の内容で登録しました。<br>
        <a href="ResultDetail?id=<%= udb.getUserID() %>">詳細画面へ戻る</a>
    </body>
</html>
