<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head><title>My Tasks</title></head><body>
<h2>My Tasks</h2>
<p><a href="${pageContext.request.contextPath}/logout">Logout</a></p>

<table border="1" cellpadding="6">
  <tr><th>ID</th><th>Title</th><th>Assignee</th><th>Status</th><th>Start</th><th>Due</th><th>Details</th></tr>
  <c:forEach items="${tasks}" var="t">
    <tr>
      <td>${t.id}</td>
      <td>${t.title}</td>
      <td>
          <c:choose>
              <c:when test="${not empty t.assignee}">
                  <c:out value="${t.assignee.username}"/>
              </c:when>
              <c:otherwise>
                  Unassigned
              </c:otherwise>
          </c:choose>
      </td>
      <td>${t.status}</td>
      <td>${t.startDate}</td>
      <td>${t.dueDate}</td>
      <td><a href="${pageContext.request.contextPath}/user/tasks/${t.id}">View</a></td>
    </tr>
  </c:forEach>
</table>
</body></html>
