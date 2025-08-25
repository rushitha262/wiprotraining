<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head><title>Create Task</title></head><body>
<h2>Allocate Task</h2>
<p><a href="${pageContext.request.contextPath}/admin/dashboard">Back</a></p>

<form action="${pageContext.request.contextPath}/admin/tasks" method="post">
  <label>Title</label><input name="title" required/><br/><br/>
  <label>Description</label><br/>
  <textarea name="description" rows="4" cols="50"></textarea><br/><br/>
  <label>Start Date</label><input type="date" name="startDate" required/><br/><br/>
  <label>Due Date</label><input type="date" name="dueDate" required/><br/><br/>
  <label>Assign To</label>
  <select name="assigneeId" required>
    <c:forEach items="${users}" var="u">
      <option value="${u.id}">${u.username} (${u.role})</option>
    </c:forEach>
  </select><br/><br/>
  <button type="submit">Create</button>
</form>
</body></html>
