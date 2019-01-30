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
        <p> Login </p>
        <p> Default: email: anon@anon, passwd: anon </p>
        <form action="/todo/fc" method="post">
            <input type="hidden" name="action" value="login" />
            <table>
                <tr>
                    <td><input type="text" name="email" placeholder="email" /></td>
                </tr>
                <tr>
                    <td><input type="text" name="password" placeholder="password" /></td>
                </tr>
                <tr>
                    <td><input type="submit" name="Submit" /></td>
                </tr>
            </table>

        </form>
        <a href="#" onclick="history.back();return false;"> Cancel </a>
        <jsp:include page="/partials/footer.jsp"/>

    </body>

</html>
