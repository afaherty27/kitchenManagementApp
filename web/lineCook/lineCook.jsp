<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 10/12/2015
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<c:set var="title" value="Welcome: Line Cook" scope="request" />
<c:import url="/jsp/head.jsp" />

<body>
<c:import url="/jsp/navbar.jsp" />

<!-- ROW 1 GRID -->
<div class="container">
<div class="row">
  <div class="col-sm-4">
    <h2 class="rowHeader">Recipe Book</h2>
    <c:forEach  var="recipe" items="${displayRecipes}">
      <div><a href="<%=request.getContextPath()%>${recipe.getFilePath()}">${recipe.getRecipeName()}</a></div>
    </c:forEach>
  </div> <!-- CLOSE col-sm-4 -->
  <div class="col-sm-4">
    <h2 class="rowHeader">View Schedule</h2>
    <p>link to schedule</p>
  </div> <!-- CLOSE col-sm-4 -->
  <div class="col-sm-4">
    <h2 class="rowHeader">Kitchen Contact List</h2>
    <p>link to contact list db with search results</p>
  </div> <!-- CLOSE col-sm-4 -->
</div> <!-- CLOSE row -->
</div> <!-- CLOSE container -->

<!-- FOOTER -->
<div class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
  <div class="container">
    <div class="navbar-text pull-left">
      <p>WebApp by Adam Faherty</p>
    </div> <!-- close navbar-text -->
  </div> <!-- close container -->
</div> <!-- close navbar -->

<!--SUPPORT MODAL -->
<div class="modal fade" id="contact" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4>Contact</h4>
        <div class="modal-body">
          <p> For technical difficulties please email afaherty27@gmail.com</p>
        </div> <!-- END modal-body r->
        <div class="model-footer">
          <a class="btn btn-primaryrdata-dismiss="modal">Close</a>
        </div> <!-- END modal-foote -->
      </div> <!-- END modal-header -->
    </div> <!-- END modal-content-->
  </div> <!-- END modal-dialog -->
</div> <!-- END modal -->

<!-- provided by: http://www.bootply.crom/101498 -->
<!--login modal-->
<div id="login" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h1 class="text-center">Login</h1>
      </div>
      <div class="modal-body">
        <form class="form col-md-12 center-block">
          <div class="form-group">
            <input class="form-control input-lg" placeholder="Username" type="text">
          </div>
          <div class="form-group">
            <input class="form-control input-lg" placeholder="Password" type="password">
          </div>
          <div class="form-group">
            <button class="btn btn-primary btn-lg btn-block">Sign In</button>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <div class="col-md-12">
          <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
        </div>
      </div>
    </div>
  </div>
</div>

<c:import url="/jsp/footer.jsp" />

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/js/bootstrap.min.js"></script>


</body>
</html>