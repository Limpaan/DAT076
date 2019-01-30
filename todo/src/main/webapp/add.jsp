<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
    ***  NOTHING TO DO HERE ***
-->
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/partials/head.jsp"/>
    </head>
    <body>
        <jsp:include page="/partials/header.jsp"/>
        <p> Add</p>
        <form action="/todo/fc" method="post">
            <input type="hidden" name="action" value="add" />
            <table>
                <tr>
                    <td><input type="text" name="text" /></td>
                </tr>
                <tr>
                    <td><input type="submit" name="add" value="Add" /></td>
                </tr>
            </table>
        </form>
        <a href="/todo/list.jsp"> Cancel</a>
        <jsp:include page="/partials/footer.jsp"/>
    </body>
</html>
