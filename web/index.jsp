<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
</html>
<body>
    <a href="helloworld">Hello World</a>
    <br>
    <a href="testRequestMapping/helloworld">TestRequestMapping Hello World</a>
    <br>
    <form action="testRequestMapping/testMethodRequestMapping" method="post">
      <input type="submit" value="submit">
    </form>
    <br>

    <a href="testRequestMapping/testParamsAndHeader?username=123&age=12">testParamsAndHeader</a>
    <br>

    <a href="testRequestMapping/testAntPath/sdfasdf/test">Test AntPath</a>
    <br>

    <a href="testRequestMapping/testPathVariable/123">testPathVariable</a>
    <br>

    <%--GET--%>
    <a href="testRequestMapping/testMethodGet/1">Rest submit get</a>
    <br>
    <%--POST--%>
    <form action="testRequestMapping/testMethodPOST" method="post">
      <input type="submit" value="Rest submit post">
    </form>
    <br>
    <%--DELETE--%>
    <form action="testRequestMapping/testMethodDELETE/1" method="post">
      <input type="hidden" name="_method" value="DELETE">
      <input type="submit" value="Rest submit DELETE">
    </form>
    <br>
    <%--PUT--%>
    <form action="testRequestMapping/testMethodPUT/1" method="post">
      <input type="hidden" name="_method" value="PUT">
      <input type="submit" value="Rest submit PUT">
    </form>
    <br>

    <a href="testRequestMapping/testRequestParam?username=张三">testRequestMapping/</a>
    <br>
    <a href="testRequestMapping/testRequestHeader">testRequestHeader/</a>
    <br>
    <a href="testRequestMapping/testRequestCookieValue">testRequestHeader/</a>
    <br>
    <form action="testRequestMapping/testPojo" method="post">
      <input type="text" name="name" id="">
      <input type="password" name="password" id="">
      <input type="text" name="address.city" id="">
      <input type="text" name="address.province" id="">
      <input type="submit" value="submit">
    </form>
    <br>
    <a href="testRequestMapping/testServletAPI">testServletAPI/</a>
    <br>
    <a href="testRequestMapping/testModelAndView">testModelAndView/</a>
    <br>
    <a href="testRequestMapping/testMap">testMap/</a>
    <br>
    <a href="testRequestMapping/testSessionAttribute">testSessionAttribute and i18n/</a>
    <br>

    updateModelAttribute:
    <form action="testRequestMapping/testModelAttributeUpdate" method="post">
      id:<input type="text" name="id" id="">
      name:<input type="text" name="name" id="">
      <input type="submit" value="submit update">
    </form>

    <br>
    <a href="testRequestMapping/testView">testView</a>
    <br>


    <a href="emps">Go to the Employee list.jsp</a>
    <br>

    <a href="views/json/json.jsp">Test JSON</a>
    <br>
    
    <form action="${pageContext.request.contextPath}/testRequestMapping/testMessageConverst" method="post">
        file:<input type="file" name="file" id="">
        desc:<input type="text" name="desc">

        <input type="submit" value="submit">
    </form>
    <br>
    
    <a href="testRequestMapping/testResponseEntity">Test testResponseEntity</a>
    <br>

    <a href="testRequestMapping/i18n">Go i18n</a>
    <br>


    <form action="${pageContext.request.contextPath}/testRequestMapping/upload" method="post" enctype="multipart/form-data">
        <input type="text" name="desc" id="">
        <input type="file" name="multipartFile" id="">
        <input type="submit" value="submit">
    </form>
    <br>

    <a href="testRequestMapping/testException?num=1">Test Exception</a>
    <br>
    <a href="testRequestMapping/testResponseStatus?num=1">Test testResponseStatus</a>
    <br>
    <a href="testRequestMapping/testSimpleMappingExceptionResolver?num=1">Test SimpleMappingExceptionResolver</a>
    <br>
    <a href="testSSDemo">Test testSSDemo</a>
    <br>


</body>

