
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
    <h1>削除確認</h1>
    削除しました。<br>
        <form action="SearchResult" method="POST">
            <input type="hidden" name="delete" value="ban">
            <input type="submit" value="検索結果に戻る">
        </form>
    </body>
</html>
