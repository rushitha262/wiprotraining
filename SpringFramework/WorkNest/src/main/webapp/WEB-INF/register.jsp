<!DOCTYPE html>
<html>
<head>
    <title>Register - WorkNest</title>
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
    margin-bottom: 10px;
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

    </style>
</head>
<body>
<div class="container">
    <h2>Register</h2>
    <form action="register" method="post">
        <label>Full Name</label>
        <input type="text" name="name" required>

        <label>Email</label>
        <input type="email" name="email" required>

        

        <label>Password</label>
        <input type="password" name="password" required>

        <label>Role</label>
        <select name="role">
            <option value="USER">User</option>
            <option value="ADMIN">Admin</option>
        </select>

        <button type="submit">Register</button>
    </form>
    <div class="link">
        <a href="login.jsp">Already have an account? Login</a>
    </div>
</div>
</body>
</html>
