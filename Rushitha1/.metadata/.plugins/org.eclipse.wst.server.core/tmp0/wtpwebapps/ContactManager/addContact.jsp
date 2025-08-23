<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Contact</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 500px;
            margin: 40px auto;
            background-color: #ffffff;
            padding: 40px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            text-align: center;
        }

        h2 {
            color: #333333;
            margin-bottom: 30px;
            font-size: 24px;
        }

        .form-box input {
            width: 100%;
            padding: 12px 12px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 16px;
        }

        .btn {
            background-color: #0056b3;
            color: #ffffff;
            border: none;
            padding: 12px 24px;
            font-size: 16px;
            border-radius: 6px;
            cursor: pointer;
            margin-top: 20px;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #218838;
        }

        input:focus {
            outline: none;
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Add New Contact</h2>
        <form action="ContactServlet" method="post" class="form-box">
            <input type="text" name="name" placeholder="Enter full name" required><br>
            <input type="email" name="email" placeholder="Enter email address" required><br>
            <input type="tel" name="phone" placeholder="Enter phone number" required><br>
            <button type="submit" class="btn">Save Contact</button>
        </form>
    </div>
</body>
</html>