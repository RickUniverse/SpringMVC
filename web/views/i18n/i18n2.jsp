<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    password: <fmt:message key="i18n.password"/>
    <a href="${pageContext.request.contextPath}/i18n">Go I18n</a>
</body>
</html>
