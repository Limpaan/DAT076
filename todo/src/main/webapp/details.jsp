<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <c:set var="id" value="${param.id}" />
        <h1>Details for ${id}</h1>
        <!-- This is the detail page called from master page -->
        <jsp:useBean id="bean" scope="application" class="mvc.beans.ViewModel"/>
        <p>Date: ${bean.getById(id).dateTime}</p>
        <p>
            Todo: ${bean.getById(id).text}
        </p>
        <p>
            Done: ${bean.getById(id).done}
        </p>
        <p>
            <!-- Note leading slash -->
            <a href="/todo/list.jsp" > Back</a>
        </p>
        <jsp:include page="/partials/footer.jsp"/>
    </body>
</html>
