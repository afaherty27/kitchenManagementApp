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
      <td style="font-weight: bolder; font-size: larger">ID</td>
      <td style="font-weight: bolder; font-size: larger">USER NAME</td>
      <td style="font-weight: bolder; font-size: larger; text-align: center;">ACTION</td>

    </tr>
    <c:forEach var="user" items="${displayUsers}">
      <tr>
        <td>${user.getUserId()}</td>
        <td>${user.getUserName()}</td>
        <td style="text-align: center">
          <a class="btn btn-success" href="#update" data-toggle="modal">UPDATE</a>
          <a class="btn btn-danger" href="#delete" data-toggle="modal">DELETE</a>
        </td>
      </tr>
    </c:forEach>
  </table>

<c:import url="/jsp/footer.jsp" />

<!-- delete modal -->
<div id="delete" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h6>Confirm: Delete This Employee</h6>
        <div class="modal-body">
          <form method="post" action="deleteUser">
            <input class="btn btn-success" type="submit" value="Send!" id="submit">
          </form>
        </div>
      </div>
    </div>
  </div>
  <div class="modal-footer">
    <a href="#" class="btn" data-dismiss="modal">Nah.</a>
  </div>
</div>

<!-- update modal -->
<div id="update" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h6>Update this employee</h6>
        <div class="modal-body">
          <form method="post" action="updateUser">
            <div class="form-group">
              <label for="inputUserName">User Name</label>
              <div>
                <input type="text" class="form-control" id="inputUserName" name="userName" placeholder="User Name" />
              </div>
            </div>
            <div class="form-group">
              <label for="inputPassword">Password</label>
              <div>
                <input type="password" class="form-control" id="inputPassword" name="userPassword" placeholder="Password" />
              </div>
            </div>
            <div class="form-group">
              <label for="userAddress">Address</label>
              <div>
                <input type="text" class="form-control" id="userAddress" name="userAddress" placeholder="Address" />
              </div>
            </div>
            <div class="form-group">
              <label for="userPhone">Phone</label>
              <div>
                <input type="text" class="form-control" id="userPhone" name="userPhone" placeholder="1112224444" />
              </div>
            </div>
            <div class="form-group">
              <label for="userEmail">Email</label>
              <input type="text" class="form-control" id="userEmail" name="userEmail" placeholder="Email" />
            </div>

              <label for="userRole">Role</label>
              <div id="userRole">
                <div class="input-group">
                  <div class="control-group">
                    <div class="controls">
                      <select name="selectRole">
                        <option value="chef">Chef</option>
                        <option value="generalManager">General Manager</option>
                        <option value="lineCook">Line Cook</option>
                        <option value="dishwasher">Dishwasher</option>
                      </select>
                    </div>
                  </div>
                </div>
              </div>

            <div class="form-group" style="margin-top: .5em">
              <button type="submit" class="btn">Update</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  <div class="modal-footer">
    <a href="#" class="btn" data-dismiss="modal">Nah.</a>
  </div>
</div>


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
