<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <p>Your TODO-list on the web</p>
        <table>
            <tr>
                <td><a href="/todo/register.jsp">Register</a></td>
            </tr>
            <tr>
                <td><a href="/todo/login.jsp">Login</a></td>
            </tr>
        </table>
        <jsp:include page="/partials/footer.jsp"/>
    </body>
</html>
