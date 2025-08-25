<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head><title>Task Comments</title></head><body>
<h2>Task Comments</h2>
<p><a href="${pageContext.request.contextPath}/admin/dashboard">Back</a></p>
<table border="1" cellpadding="6">
  <tr><th>#</th><th>Author</th><th>Comment</th><th>At</th></tr>
  <c:forEach items="${comments}" var="cmt" varStatus="vs">
    <tr>
      <td>${vs.index + 1}</td>
      <td>${cmt.author.username}</td>
      <td>${cmt.content}</td>
      <td>${cmt.createdAt}</td>
    </tr>
  </c:forEach>
</table>
</body></html>
