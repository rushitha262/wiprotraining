<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Add Contact</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        .btn {
            padding: 10px 20px;
            margin: 10px 5px;
            font-size: 16px;
            background-color: #4CAF50; /* Green */
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #45a049;
        }

        input[type="text"],
        input[type="email"] {
            padding: 8px;
            margin: 8px 0;
            width: 390px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        form {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h2>Add New Contact</h2>

    <!-- Feedback Messages -->
    <c:if test="${not empty message}">
        <p style="color:green">${message}</p>
    </c:if>
    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>

    <!-- Contact Form -->
    <form action="ContactServlet" method="post">
        <input type="text" name="name" placeholder="Name" required><br>
        <input type="email" name="email" placeholder="Email" required><br>
        <input type="text" name="phone" placeholder="Phone" required><br>

        <!-- Styled Action Buttons -->
        <input type="submit" value="Add Contact" class="btn">
        <input type="reset" value="Clear" class="btn">
        <button type="button" class="btn" onclick="window.location.href='viewContacts.jsp'">View Contacts</button>
    </form>
</body>
</html>