<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head><title>Register</title></head><body>
<h2>Register</h2>
<c:if test="${not empty error}"><p style="color:red">${error}</p></c:if>
<form action="${pageContext.request.contextPath}/register" method="post">
  <label>Username</label><input name="username" required/><br/><br/>
  <label>Password</label><input type="password" name="password" required/><br/><br/>
  <label>Role</label>
  <select name="role">
    <option value="USER">USER</option>
    <option value="ADMIN">ADMIN</option>
  </select><br/><br/>
  <button type="submit">Register</button>
</form>
<p><a href="${pageContext.request.contextPath}/login">Back to Login</a></p>
</body></html>
