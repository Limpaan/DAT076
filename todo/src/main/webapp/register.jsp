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
        <p>Register</p>
        <form action="/todo/fc" method="post">
            <input type="hidden" name="action" value="register" />
            <table>
                <tr>
                <tr>
                    <td><input type="text" name="name" placeholder="name" /></td>
                </tr>
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
        <a href="/todo"> Cancel </a>
        <jsp:include page="/partials/footer.jsp"/>
    </body>

</html>