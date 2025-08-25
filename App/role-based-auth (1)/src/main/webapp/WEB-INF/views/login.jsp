<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head><title>Login</title></head><body>
<h2>Login</h2>
<c:if test="${not empty error}"><p style="color:red">${error}</p></c:if>
<c:if test="${not empty success}"><p style="color:green">${success}</p></c:if>
<form action="${pageContext.request.contextPath}/login" method="post">
  <label>Username</label><input name="username" required/><br/><br/>
  <label>Password</label><input type="password" name="password" required/><br/><br/>
  <button type="submit">Login</button>
</form>
<p><a href="${pageContext.request.contextPath}/register">New user? Register</a></p>
</body></html>
