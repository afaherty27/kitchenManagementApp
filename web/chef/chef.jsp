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

<div class="row">
  <div class="col-sm-4">
    <h2 class="rowHeader">Recipe Development</h2>
    <p>File Location: ${uploadedFilePath}</p>

    <form class="form-horizontal" method="post" enctype="multipart/form-data" action="uploadRecipe">

      <div class="form-group"> <!-- font awesome for modal about how to save as a pdf   .fa-info-circle-->
        <label for="recipeFile" class="control-label col-xs-2">File:</label>
        <div class="col-xs-3">
          <input type="file" id="recipeFile" name="recipeFile" />
        </div>
      </div>

      <div class="form-group">
        <label for="recipeTitle" class="control-label col-xs-2">Name:</label>
        <div class="col-xs-3">
          <input type="text" class="form-control" id="recipeTitle" name="recipeName" />
        </div>
      </div>

      <div class="row">
        <label for="category" class="control-label col-xs-2">Category:</label>
        <div class="col-xs-3" id="category">
          <div class="input-group">
            <div class="control-group">
              <div class="controls">
                <select name="selectCategory">
                  <option value="dressing">Dressing</option>
                  <option value="protein">Protein</option>
                  <option value="sauce">Sauce</option>
                  <option value="produce">Produce</option>
                  <option value="marinade">Marinade</option>
                </select>
              </div>
            </div>
          </div>
        </div>
      </div>

      <br /><br />

      <div class="form-group">
        <button type="submit" class="btn  btn-primary">Add Recipe</button>
        <a class="btn btn-primary" href="#recipes" data-toggle="modal">View Recipes</a>
      </div>
    </form>

  </div> <!-- CLOSE col-sm-4 -->
</div> <!-- CLOSE row -->


<c:import url="/jsp/footer.jsp" />

  <!--RECIPE MODAL -->
  <div class="modal fade" id="recipes" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4>Recipes</h4>
          <div class="modal-body">

            <c:forEach  var="recipe" items="${displayRecipes}">
              <div><a href="<%=request.getContextPath()%>${recipe.getFilePath()}">${recipe.getRecipeName()}</a></div>
            </c:forEach>

          </div> <!-- END modal-body -->
          <div class="model-footer">
            <a class="btn btn-primary" data-dismiss="modal">Close</a>
          </div> <!-- END modal-footer -->
        </div> <!-- END modal-header -->
      </div> <!-- END modal-content-->
    </div> <!-- END modal-dialog -->
  </div> <!-- END modal -->

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
