<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 10/18/2015
  Time: 1:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <c:import url="/jsp/head.jsp" />
</head>
<body>
<form action="j_security_check" method="post">
  <table>
    <tr>
      <td>
        User Name:
      </td>
      <td>
        <input type="text" name="j_username" />
      </td>
    </tr>
    <tr>
      <td>
        Password:
      </td>
      <td>
        <input type="password" name="j_password" />
      </td>
    </tr>
    <tr>
      <td></td>
      <td>
        <input type="submit" value="Log In" />
      </td>
    </tr>
  </table>
</form>
</body>
</html>
