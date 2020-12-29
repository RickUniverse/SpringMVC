<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>hello</h1>
    time：${requestScope.time}
    <br>
    names: ${requestScope.names}
    <br>
    userSession: ${sessionScope.userSession}
    <br>
    使用Spring标签获取
<%--    <spring:message code="i18n.username"/>--%>
    <br>
<%--    <spring:message code="i18n.password"/>--%>
    <br>
    最好使用fmt标签获取，因为如果是redirect请求使用Spring标签获取会报错
    使用fmt标签获取
    <fmt:message key="i18n.username"></fmt:message>
    <fmt:message key="i18n.password"></fmt:message>
    <br>
</body>
</html>
