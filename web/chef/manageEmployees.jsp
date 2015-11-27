<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: afaherty
  Date: 11/23/2015
  Time: 2:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<c:set var="title" value="Manage Employees" scope="request" />
<c:import url="/jsp/head.jsp" />

<body>
<c:import url="/jsp/navbar.jsp" />

  <table class="table" style="margin-left: 10%; width: 20%;">
    <tr>
      <td style="font-weight: bolder; font-size: larger">USER NAME</td>
      <td style="font-weight: bolder; font-size: larger; text-align: center;">ACTION</td>

    </tr>
    <c:forEach var="user"  items="${displayUsers}">
      <tr>
        <td>${user.getUserName()}</td>
        <td style="text-align: center">
          <input type="button" value="UPDATE"  />
          <input type="button" value="DELETE" onclick="deleteUser" />
        </td>
      </tr>
    </c:forEach>
  </table>

<c:import url="/jsp/footer.jsp" />

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
