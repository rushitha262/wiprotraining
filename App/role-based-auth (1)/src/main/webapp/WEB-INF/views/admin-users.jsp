<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head><title>Manage Users</title></head><body>
<h2>Users</h2>
<p><a href="${pageContext.request.contextPath}/admin/dashboard">Back</a></p>

<c:if test="${not empty error}"><p style="color:red">${error}</p></c:if>

<table border="1" cellpadding="6">
  <tr><th>ID</th><th>Username</th><th>Role</th><th>Action</th></tr>
  <c:forEach items="${users}" var="u">
    <tr>
      <td>${u.id}</td>
      <td>${u.username}</td>
      <td>${u.role}</td>
      <td>
        <form action="${pageContext.request.contextPath}/admin/users/${u.id}/delete" method="post" style="display:inline">
          <button type="submit" onclick="return confirm('Delete user?')">Delete</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>

<h3>Add User</h3>
<form action="${pageContext.request.contextPath}/admin/users" method="post">
  <label>Username</label><input name="username" value="${newUser.username}" required/> <br/><br/>
  <label>Password</label><input type="password" name="password" required/> <br/><br/>
  <label>Role</label>
  <select name="role">
    <option value="USER">USER</option>
    <option value="ADMIN">ADMIN</option>
  </select><br/><br/>
  <button type="submit">Add</button>
</form>
</body></html>
