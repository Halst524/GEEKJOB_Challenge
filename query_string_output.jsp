<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Outputter</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            String to = request.getParameter("total");
            String co = request.getParameter("count");
            String ty = request.getParameter("type");
            int total = Integer.parseInt(to);
            int count = Integer.parseInt(co);
        %>
        <p>
            総額<br>
            <%
                out.print(to);
            %>
            円<br>
        </p>
        <p>
            個数<br>
            <%
                out.print(co);
            %>
            個<br>
        </p>
        <p>
            品種<br>
            <%
                if(ty.equals("1")){
                    out.print("雑貨");
                } else if(ty.equals("2")){
                    out.print("生鮮食品");
                } else {
                    out.print("その他");
                }
            %>
            <br>
        </p>
        <p>単価<br>
            <%
                out.print("1個" + total/count + "円");
            %>
            <br>
        </p>
        <p>ポイント<br>
            <%
                if(total >= 5000){
                    out.print(total*0.05);
                } else if(total < 3000){
                    out.print("0");
                } else {
                    out.print(total*0.04);
                }
            %>
            ポイント
        </p>
    </body>
</html>
