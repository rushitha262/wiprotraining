<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Contact Manager</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        .btn {
            padding: 10px 20px;
            margin: 10px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Welcome to Contact Manager</h1>

    <!-- Navigation Buttons -->
    <button class="btn" onclick="window.location.href='addContact.jsp'">Add Contact</button>
    <button class="btn" onclick="window.location.href='viewContacts.jsp'">View Contacts</button>
</body>
</html>