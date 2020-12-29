<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="resources/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        function deleteClick(id) {
            $('form').attr("action","emp/"+id+"").submit();
        }
        $(function () {
            // $('.deleteClick').click()
        })
    </script>
</head>
<body>
    <form action="emp/1" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
    <c:if test="${empty requestScope.employees}">
        没有任何员工
    </c:if>
    <c:if test="${!empty requestScope.employees}">
        <table cellspacing="0" cellpadding="10" border="1">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>gender</th>
                <th>department</th>
                <th>delete</th>
                <th>edit</th>
            </tr>
            <c:forEach items="#{requestScope.employees}" var="emp">
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.name}</td>
                    <td>${emp.gender == 1 ? "male" : "female"}</td>
                    <td>${emp.department.name}</td>
                    <td><a href="emp/${emp.id}">edit</a></td>
                    <td><a onclick="deleteClick(${emp.id})" href="javascript:">delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>


    <br>
    <a href="emp">Add Employee</a>
</body>
</html>
