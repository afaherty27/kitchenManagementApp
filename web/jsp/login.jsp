<!-- provided by: http://www.bootply.com/101498 -->
<div id="${roleName}" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h1 class="text-center">Login</h1>
      </div>
      <div class="modal-body">
        <form class="form col-md-12 center-block" method="get">
          <div class="form-group">
            <input class="form-control input-lg" placeholder="Username" type="text">
          </div>
          <div class="form-group">
            <input class="form-control input-lg" placeholder="Password" type="password">
          </div>
          <div class="form-group">
            <a href="${redirectLocation}"><input type="button" value="Sign In" /></a>
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
