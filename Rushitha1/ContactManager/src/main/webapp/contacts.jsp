<%@ page import="java.util.*, com.contactmanager.Contact" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Contacts</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: 60px auto;
            padding: 30px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            text-align: center;
        }

        h2 {
            margin-bottom: 20px;
            color: #333;
        }

        .contact-table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }

        .contact-table th,
        .contact-table td {
            border: 1px solid #ccc;
            padding: 12px 16px;
            text-align: left;
        }

        .contact-table th {
            background-color: #f2f2f2;
            color: #333;
        }

        .contact-table td {
            background-color: #fff;
        }

        .btn {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 20px;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>All Contacts</h2>

        <table class="contact-table">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
                    if (contacts != null && !contacts.isEmpty()) {
                        for (Contact c : contacts) {
                %>
                    <tr>
                        <td><%= c.getName() %></td>
                        <td><%= c.getEmail() %></td>
                        <td><%= c.getPhone() %></td>
                    </tr>
                <%
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="3">No contacts found.</td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        <a href="addContact.jsp"><button class="btn">Add New Contact</button></a>
    </div>
</body>
</html>