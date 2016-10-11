<!-- обратите внимание на spring тэги -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
  <title>Index Page</title>
</head>

<body>
<spring:form method="post"  modelAttribute="userJSP" action="check-user">

  Name: <spring:input path="name"/>   <br/>
  Password: <spring:input path="password"/>   <br/>
  <spring:button>Login</spring:button>

</spring:form>
<p>add text to compile11111111111111111111</p>
<p>update action wok</p>
<p>dededed</p>
</body>

</html>
