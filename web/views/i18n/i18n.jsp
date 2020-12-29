<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    username: <fmt:message key="i18n.username"/>
    <a href="${pageContext.request.contextPath}/i18n2">Go I18n2</a>
    <a href="${pageContext.request.contextPath}/i18n?locale=zh_CH">中文</a>
    <a href="${pageContext.request.contextPath}/i18n?locale=en_US">English</a>
</body>
</html>
