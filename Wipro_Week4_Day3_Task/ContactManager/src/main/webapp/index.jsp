<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contact Manager</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 100px auto;
            background-color: #ffffff;
            padding: 40px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            text-align: center;
        }

        h1 {
            color: #333333;
            margin-bottom: 40px;
            font-size: 28px;
        }

        .button-group {
            display: flex;
            justify-content: center;
            gap: 20px;
        }

        .btn {
            background-color: #007bff;
            color: #ffffff;
            border: none;
            padding: 12px 24px;
            font-size: 16px;
            border-radius: 6px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        a {
            text-decoration: none;
        }

        form {
            margin: 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Contact Manager</h1>
        <div class="button-group">
            <a href="addContact.jsp">
                <button class="btn">Add Contact</button>
            </a>
            <form action="ContactServlet" method="get">
                <button type="submit" class="btn">View Contacts</button>
            </form>
        </div>
    </div>
</body>
</html>