<!DOCTYPE html>
<html>
<head>
    <title>Add Task - WorkNest</title>
    <style>
        <style>
    body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f5f6fa;
}

.container {
    width: 400px;
    margin: 8px auto;
    background-color: #ffffff;
    padding: 25px;
    border-radius: 10px;
    
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
    color: #333333;
}

input,
select,
textarea {
    width: 100%;
    padding: 10px;
    margin-bottom: 8px;
    border: 1px solid #cccccc;
    border-radius: 5px;
    box-sizing: border-box;
}

button {
    width: 100%;
    padding: 12px;
    background-color: #3498db;
    color: #ffffff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s ease;
}

button:hover {
    background-color: #2980b9;
}

.link {
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
<div class="container">
    <h2>Add Task</h2>
    <form action="addTask" method="post">
        <label>Task Title</label>
        <input type="text" name="title" required>

        <label>Description</label>
        <textarea name="description" required></textarea>

        <label>Assign To (Username)</label>
        <input type="text" name="assignedTo" required>

        <label>Start Date</label>
        <input type="date" name="startDate" required>

        <label>Due Date</label>
        <input type="date" name="dueDate" required>

        <button type="submit">Create Task</button>
    </form>
</div>
</body>
</html>
