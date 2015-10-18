<%--
  Created by IntelliJ IDEA.
  User: Adam Faherty
  Date: 10/7/2015
  Time: 01:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<c:set var="title" value="KMA: HOME" scope="request" />>

<c:import url="/jsp/head.jsp" />
<body>
<div class="navbar navbar-inverse navbar-fixed-top"
     role="navigation">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only"> Toggle Navigation</span> <!--rh button-->
        <span class="icon-bar"></span> <!-- 3 lines to make icon bar -->
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button> <!-- END BUTTON-->
      <li><a class="navbar-brand" href="index.jsp">KMA</a></li><!-- Title of page -->
    </div> <!-- END NAVBAR-HEADER-->
    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right"> <!-- align on right properly -->
        <li class="active"><a href="#">HOME</a></li>
        <li><a href="/gm/generalManager.jsp">General Manager</a></li> <!--this works see line41 -->

        <li class="dropdown">
          <a href="#"
             class="dropdown-toggle"
             data-toggle="dropdown">LOGIN<b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li class="dropdown-header">Management</li><!--menu title -->
            <li><a href="/chef" data-toggle="modal">Chef</a></li>
            <li><a href="/generalManager" data-toggle="modal">General Manager</a></li>
            <li class="divider"></li> <!-- divides 2 sections of dropdown --><!-- this does not work-->
            <li class="dropdown-header"></li><!--menu title -->
            <li><a href="/dishwasher" data-toggle="modal">Line Cook</a></li>
            <li><a href="/lineCook" data-toggle="modal">Dishwasher</a></li> <!-- if these do not work, remove modal -->
          </ul>
        </li>
        <li><a href="#contact" data-toggle="modal">SUPPORT</a><li>
      </ul>
    </div> <!-- END NAVBAR COLLAPSE -->
  </div><!--END CONTAINER-->
</div> <!-- END NAVBAR -->

<!--carousel code provided by: http://bootstrapbay.com/blog/bootstrap-3-carousel-tutorial/-->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="http://placehold.it/1200x315" alt="...">
      <div class="carousel-caption">
        <h3>Picture of knife</h3>
      </div>
    </div>
    <div class="item">
      <img src="http://placehold.it/1200x315" alt="...">
      <div class="carousel-caption">
        <h3>Busy line</h3>
      </div>
    </div>
    <div class="item">
      <img src="http://placehold.it/1200x315" alt="...">
      <div class="carousel-caption">
        <h3>messy order guide</h3>
      </div>
    </div>
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
  </a>
</div> <!-- Carousel -->

<!-- ROW 1 GRID -->
<div class="row">
  <div class="col-sm-4">
    <h2 class="rowHeader">Mission Statement</h2>
    <p>
      stuff about this program. blah blah blah
    </p>
    <p>
      more stuff blah bblah blhaldh
    </p>
    <p>
      ssaying more stuff
    </p>
  </div> <!-- CLOSE col-sm-4 -->
  <div class="col-sm-4">
    <h2 class="rowHeader">Management Benefits</h2>
    <p>Coming Soon</p>
  </div> <!-- CLOSE col-sm-4 -->
  <div class="col-sm-4">
    <h2 class="rowHeader">Staff Benefits</h2>
    <p>Coming Soon</p>
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
        </div> <!-- END modal-body -->
        <div class="model-footer">
          <a class="btn btn-primary"data-dismiss="modal">Close</a>
        </div> <!-- END modal-footer -->
      </div> <!-- END modal-header -->
    </div> <!-- END modal-content-->
  </div> <!-- END modal-dialog -->
</div> <!-- END modal -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>


</body>
</html>
