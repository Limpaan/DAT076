<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <jsp:useBean id="bean" scope="request" class="mvc.beans.ViewModel"/>
        <p> Delete ${param.id}</p>
        <c:set var="id" value="${param.id}" />
        <p>Date: ${bean.getById(id).dateTime}</p>
        <p>
            Todo: ${bean.getById(id).text}
        </p>
        <p>
            Done: ${bean.getById(id).done}
        </p>

        <form action="/todo/fc" method="post">
            <input type="hidden" name="action" value="delete" />
            <input type="hidden" name="id" value="${id}" />
            <input type="submit" name="submit" value="Delete" />
        </form>
        <a href="/todo/list.jsp"> Cancel</a>
        <jsp:include page="/partials/footer.jsp"/>
    </body>

</html>


