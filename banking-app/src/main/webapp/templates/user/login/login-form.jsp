<%@ include file="../user-header.jsp" %>
<html>
  <body>
  <div class="bg bg-image">
    <div class="container d-flex justify-content-center align-items-center py-1">
    <div class="card p-4 shadow-lg" style="width: 40%;height: 70%;">
        <h4 class="text-center mb-4">Login</h4>
        <form action="authenticate.do" method="post">
            <div class="mb-3">
                <label for="userid" class="form-label">User Id</label>
                <% String userid=request.getParameter("uid"); %>
                <input type="text" class="form-control" value="<%=userid!=null?userid:""%>" name="userid" placeholder="Enter your userid" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" value=""  class="form-control" name="password" placeholder="Enter your password" required>
            </div>
            <div class="my-4">
                <button class="btn btn-primary w-100">Login</button>
            </div>
        </form>
        <div class="text-center mb-3">
            <a href="registration">Register User?</a>
            <br>
            <% String msg=request.getParameter("msg"); %>
            <label class="text-danger fs-5"><%=msg!=null?msg:""%></label>
        </div>
     </div>
    </div>W
   </div>
   <%@ include file="../../reusable-code/footer.jsp" %>
  </body>
</html>