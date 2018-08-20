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
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
        <h1>詳細情報</h1>
        <table border="2">
            <tr><td>名前</td><td><%= udd.getName()%></td></tr>
            <tr><td>生年月日</td><td><%= udd.getBirthday()%></td></tr>
            <tr><td>種別</td><td><%= udd.getType()%></td></tr>
            <tr><td>電話番号</td><td><%= udd.getTell()%></td></tr>
            <tr><td>自己紹介</td><td><%= udd.getComment()%></td></tr>
            <tr><td>登録日時</td><td><%= udd.getNewDate()%></td></tr>
        </table>
        <form action="Update" method="POST">
            <input type="hidden" name="id" value="<%= udd.getUserID()%>">
            <input type="submit" name="update" value="変更" style="width:100px">
        </form>
        <form action="Delete" method="POST">
            <input type="hidden" name="id" value="<%= udd.getUserID()%>">
            <input type="submit" name="delete" value="削除" style="width:100px">
        </form>
        <form action="SearchResult" method="POST">
            <input type="hidden" name="previous" value="ban">
            <input type="submit" value="検索結果に戻る">
        </form>
    <%=jh.home()%>
    </body>
</html>
