<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 10/30/2015
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<c:set var="title" value="Add New Employee" scope="request" />
<c:import url="/jsp/head.jsp" />

<body>
<c:import url="/jsp/navbar.jsp" />
<h1> add a new employee on this page</h1>
<form class="form-horizontal">
    <div class="form-group">
        <label for="inputUserName" class="control-label col-xs-2">User Name</label>
        <div class="col-xs-3">
            <input type="text" class="form-control" id="inputUserName" placeholder="User Name" />
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword" class="control-label col-xs-2">Password</label>
        <div class="col-xs-3">
            <input type="password" class="form-control" id="inputPassword" placeholder="Password" />
        </div>
    </div>
    <div class="form-group">
        <label for="userAddress" class="control-label col-xs-2">Address</label>
        <div class="col-xs-3">
            <input type="text" class="form-control" id="userAddress" placeholder="Address" />
        </div>
    </div>
    <div class="form-group">
        <label for="userPhone" class="control-label col-xs-2">Phone</label>
        <div class="col-xs-3">
            <input type="text" class="form-control" id="userPhone" placeholder="1112224444" />
        </div>
    </div>
    <div class="form-group">
        <label for="userEmail" class="control-label col-xs-2">Email</label>
        <div class="col-xs-3">
            <input type="text" class="form-control" id="userEmail" placeholder="Email" />
        </div>
    </div>
    <div class="form-group">
        <label for="userSocial" class="control-label col-xs-2">SSN</label>
        <div class="col-xs-3">
            <input type="text" class="form-control" id="userSocial" placeholder="SSN" />
        </div>
    </div>
    <div class="row">
        <label for="userRole" class="control-label col-xs-2">Role</label>
        <div class="col-xs-3" id="userRole">
            <div class="input-group">
                <div class="input-group-btn">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Select Role
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li>Chef</li>
                        <li>General Manager</li>
                        <li>Line Cook</li>
                        <li>Dishwasher</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="form-group">
            <button type="submit" class="btn">Add Employee</button>
    </div>

</form>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/js/bootstrap.min.js"></script>

</body>
</html>
