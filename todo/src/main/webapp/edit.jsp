<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/partials/head.jsp"/>
    </head>
    <body>
        <jsp:include page="/partials/header.jsp"/>
        <jsp:useBean id="bean" scope="request" class="mvc.beans.ViewModel"/>
        <p> Edit ${param.id}</p>
        
        <!-- TODO -->
        
       
        <a href="/todo/list.jsp"> Cancel</a>
        <jsp:include page="/partials/footer.jsp"/>
    </body>

</html>

