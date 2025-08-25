<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head><title>Admin Dashboard</title></head><body>
<h2>Admin Dashboard</h2>
<p>
    <a href="${pageContext.request.contextPath}/logout">Logout</a> |
    <a href="${pageContext.request.contextPath}/admin/users">Manage Users</a> |
    <a href="${pageContext.request.contextPath}/admin/tasks/new">Allocate Task</a>
</p>

<h3>Task Status</h3>
<ul>
  <li>Pending: ${counts.PENDING}</li>
  <li>In Progress: ${counts.IN_PROGRESS}</li>
  <li>Completed: ${counts.COMPLETED}</li>
  <li>Delayed: ${counts.DELAYED}</li>
</ul>

<h3>All Tasks</h3>
<table border="1" cellpadding="6">
  <tr><th>ID</th><th>Title</th><th>Assignee</th><th>Status</th><th>Start</th><th>Due</th><th>Comments</th></tr>
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
      <td><a href="${pageContext.request.contextPath}/admin/tasks/${t.id}/comments">View</a></td>
    </tr>
  </c:forEach>
</table>
</body></html>
