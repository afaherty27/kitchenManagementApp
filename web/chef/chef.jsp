<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 10/12/2015
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<c:set var="title" value="Welcome: Chef" scope="request" />
<c:import url="/jsp/head.jsp" />

<body>
<c:import url="/jsp/navbar.jsp" />

<!-- ROW 1 GRID -->
<div class="row">
  <div class="col-sm-4">
    <h2 class="rowHeader">Schedule</h2>
    <p>
      add link to build schedule
    </p>
  </div> <!-- CLOSE col-sm-4 -->
  <div class="col-sm-4">
    <h2 class="rowHeader">Staff Management</h2>
    <a href="addEmployee">New Employee</a><br />
    <a href="manageEmployees">Manage Employees</a>
    <p>link to a list of staff.  allows to add a new employee</p>
  </div> <!-- CLOSE col-sm-4 -->
  <div class="col-sm-4">
    <h2 class="rowHeader">Recipe Development</h2>
    <p>path in session: ${uploadedFilePath}</p>
    <h1 style="align: center;">${requestScope["message"]}</h1>
    <form class="form-horizontal" method="post" enctype="multipart/form-data" action="uploadRecipe">
      <div class="form-group">
        <label for="recipe" class="control-label col-xs-2">File:</label>
        <div class="col-xs-3">
          <input type="file" id="recipe" name="recipe" />
          <br /><br />
          <div class="form-group">
            <button type="submit" class="btn">Add Recipe</button>
          </div>
        </div>
      </div>
    </form>
  </div> <!-- CLOSE col-sm-4 -->
</div> <!-- CLOSE row -->


<c:import url="/jsp/footer.jsp" />

<!--SUPPORT MODAL -->
<div class="modal fade" id="contact" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4>Contact</h4>
        <div class="modal-body">
          <p> For technical difficulties please email afaherty27@gmail.com</p>
        </div> <!-- END modal-body -->
        <div class="model-footer">
          <a class="btn btn-primary" data-dismiss="modal">Close</a>
        </div> <!-- END modal-footer -->
      </div> <!-- END modal-header -->
    </div> <!-- END modal-content-->
  </div> <!-- END modal-dialog -->
</div> <!-- END modal -->


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/js/bootstrap.min.js"></script>


</body>
</html>
