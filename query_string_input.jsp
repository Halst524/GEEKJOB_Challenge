<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inputter</title>
    </head>
    <body>
            <form action="./query_string_output.jsp" method="get">
                <p>
                    総額<br>
                    <input type="number" name="total" value="0">
                </p>
                <p>
                    個数<br>
                    <input type="number" name="count" value="0">
                </p>
                <p>
                    <input type="radio" id="a1" name="type" value="1">
                    <label id="a1">雑貨</label>
                    <input type="radio" id="a2" name="type" value="2">
                    <label id="a2">生鮮食品</label>
                    <input type="radio" id="a3" name="type" value="3">
                    <label id="a3">その他</label>
                </p>
                <p>
                    <input type="submit" value="送信">
                </p>
            </form>

    </body>
</html>
