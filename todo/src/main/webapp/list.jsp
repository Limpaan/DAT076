<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/partials/head.jsp"/>
    </head>
    <body>
        <jsp:include page="/partials/header.jsp"/>
        <!-- Possible scopes for beans: page, request, session, application -->
        <jsp:useBean id="bean" scope="request" class="mvc.beans.ViewModel"/>
        <div class="pageContent">
            <!--  This is the master page with a list of entities -->
            <table>
                <thead>
                    <tr>
                        <td>Id</td>
                        <td>To Do</td>
                        <td>Date</td>
                        <td>Done</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${bean.todoList}">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.text}</td>
                            <td>${item.dateTime}</td>
                            <td>${item.done}</td>
                            <td><a href="edit.jsp?id=${item.id}">edit</a></td>
                            <td><a href="delete.jsp?id=${item.id}">delete</a></td>
                        </tr>
                    </c:forEach>
                  
                </tbody>
            </table>
        </div>
        <a href="add.jsp"> New Note </a>
        <jsp:include page="/partials/footer.jsp"/>
    </body>
</html>


