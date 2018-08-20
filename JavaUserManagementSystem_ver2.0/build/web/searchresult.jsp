<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    ArrayList list = (ArrayList)hs.getAttribute("resultList");
%>
    <%--
    <%　はスクリプトレットといい、スクリプトレット内で宣言した変数やインスタンスは同じJSPファイル内の以降のスクリプトレットで使用できる
    <%= はスクリプト式といい、変数やメソッドの戻り値、演算結果などを出力する。また、;は不要
    <%--　はJSPファイルとしてのコメント機能 --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <% for(int i = 0;i < list.size() ; i++){
                UserDataDTO udd = (UserDataDTO)list.get(i);
%>
            <tr>
                <td><a href="ResultDetail?id=<%= udd.getUserID()%>"><%= udd.getName()%></a></td>
                <td><%= udd.getBirthday()%></td>
                <td><%= jh.exTypenum(udd.getType())%></td>
                <td><%= udd.getNewDate()%></td>
            </tr>
            <% } %>
        </table>
    <%=jh.home()%>
    </body>
</html>
