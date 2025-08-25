<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head><title>Task Details</title></head><body>
<h2>Task Details</h2>
<p><a href="${pageContext.request.contextPath}/user/tasks">Back to My Tasks</a></p>

<h3>Comments</h3>
<table border="1" cellpadding="6">
  <tr><th>Author</th><th>Content</th><th>Created At</th></tr>
  <c:forEach items="${comments}" var="c">
    <tr>
      <td>
          <c:choose>
              <c:when test="${not empty c.author}">
                  <c:out value="${c.author.username}"/>
              </c:when>
              <c:otherwise>
                  Unknown
              </c:otherwise>
          </c:choose>
      </td>
      <td><c:out value="${c.content}"/></td>
      <td>${c.createdAt}</td>
    </tr>
  </c:forEach>
</table>

<h3>Add Comment</h3>
<form action="${pageContext.request.contextPath}/user/tasks/${taskId}/comments" method="post">
  <textarea name="content" rows="4" cols="50" required></textarea><br/>
  <input type="submit" value="Add Comment"/>
</form>
</body></html>
