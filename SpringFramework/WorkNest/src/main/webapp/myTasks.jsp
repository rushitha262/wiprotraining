<!DOCTYPE html>
<html>
<head>
    <title>My Tasks - WorkNest</title>
    <style>
       <style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background: #f5f6fa;
    }
    .container {
        width: 400px;
        margin: 80px auto;
        background: #fff;
        padding: 25px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    h2 {
        text-align: center;
        color: #2c3e50;
        margin-bottom: 20px;
    }
    label {
        display: block;
        margin: 10px 0 5px;
        font-weight: bold;
        color: #333;
    }
    input, select, textarea {
        width: 30%;
        padding: 10px;
        margin-bottom: 15px;
        border-radius: 5px;
        border: 1px solid #ccc;
    }
    button {
        width: 100%;
        padding: 12px;
        background: #3498db;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }
    button:hover {
        background: #2980b9;
    }
    .link {
        display: block;
        text-align: center;
        margin-top: 15px;
    }
    .link a {
        color: #3498db;
        text-decoration: none;
        font-size: 14px;
    }
    .link a:hover {
        text-decoration: underline;
    }
</style>

</head>
<body>
<div class="container" style="width:600px;">
    <h2>My Tasks</h2>

    <!-- Example Task -->
    <div class="task-box">
        <b>Task:</b> Complete Report <br>
        <b>Status:</b> Pending <br>

        <form action="updateTask" method="post">
            <input type="hidden" name="taskId" value="1">
            <select name="status">
                <option>Pending</option>
                <option>In Progress</option>
                <option>Completed</option>
            </select>
            <button type="submit">Update</button>
        </form>
        <a href="comment.jsp?taskId=1"><button>Add Comment</button></a>
    </div>
</div>
</body>
</html>
