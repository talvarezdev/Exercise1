<%@include file="taglib.jsp"%>
<c:set var="title" value="User Search Home Page"  />
<%@include file="head.jsp"%>
<html>
<body>
<h2>User Display Exercise - Week 1</h2>
<!--<a href = "searchUser">Go to the User Search</a> -->
    <form action="/searchUser" class="form-inLine">
          <div class="form-group">
              <label for="searchTerm">Search</label>
              <input type="text" class="form-control" name="searchTerm" id="searchTerm" aria-describedby="searchTerm">
          </div>
          <button type="submit" name="submit" value="search" class="btn btn-primary">Search</button>
          <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View all users</button>
    </form>
</body>
</html>