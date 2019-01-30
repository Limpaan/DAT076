<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
    ***  NOTHING TO DO HERE ***
-->
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <!-- Normally avoid this -->
        <jsp:scriptlet>
            request.getSession().invalidate();
            response.sendRedirect("/todo");
        </jsp:scriptlet>
    </body>
</html>
