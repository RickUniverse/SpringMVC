<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function () {

        })
        function testJson() {
            $.post("${pageContext.request.contextPath}/testRequestMapping/testJSON",{}, function (data) {
                for (var i = 0; i < data.length; i++) {
                    alert(data[i].id + ": " + data[i].name);
                }
            })
        }
    </script>
</head>
<body>
    <a onclick="testJson()" href="javascript:">Test JSON</a>
</body>
</html>
