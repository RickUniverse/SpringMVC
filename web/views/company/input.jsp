<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/parseStringEmployeeAndSave" method="post">
        <input type="text" name="parseString" id="">
        <input type="submit" value="submit">
    </form>
<br>
----------------------------
<br>
    <form:form action="emp" method="post" modelAttribute="employee"><%--绝对路径${pageContext.request.contextPath}/--%>
        <c:if test="${empty employee.id}">
        name: <form:input path="name"/><form:errors path="name"></form:errors>
        </c:if>
        <c:if test="${!empty employee.id}">
            <form:hidden path="id"/>
            <input type="hidden" name="_method" value="PUT">
        </c:if>
        <br>
        <%
            Map<String,String> genderMap = new HashMap();
            genderMap.put("1","male");
            genderMap.put("2","female");
            request.setAttribute("genderMap",genderMap);
        %>
        gender: <form:radiobuttons path="gender" items="${genderMap}"/>
        <br>
        department: <form:select path="department.id" items="${requestScope.departments}"
        itemLabel="name" itemValue="id"/>
        <br>

        birth:<form:input path="birth"></form:input><form:errors path="birth"></form:errors>
        <br>

        salary:<form:input path="salary"></form:input>
        <br>

        <input type="submit" value="submit">
        <br>
    </form:form>
</body>
</html>
