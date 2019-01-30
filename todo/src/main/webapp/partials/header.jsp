<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1 class="header">WEB TODO</h1>
<p>
<c:choose>
    <c:when test="${sessionScope.user == null}">
        Sorry not logged in!
    </c:when>
    <c:otherwise>
        <!-- TODO -->
    </c:otherwise>      
</c:choose>
</p>
