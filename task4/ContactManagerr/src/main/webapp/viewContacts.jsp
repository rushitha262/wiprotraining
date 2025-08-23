<%@ page import="java.util.*, com.contactmanager.ContactList, com.contactmanager.Contact" %>
<html>
<head>
    <title>View Contacts</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }

        h2 {
            color: #333;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .btn {
            padding: 10px 20px;
            margin-top: 20px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>All Contacts</h2>

    <table>
        <tr><th>Name</th><th>Email</th><th>Phone</th></tr>
        <%
            List<Contact> contacts = ContactList.getAllContacts();
            for (Contact c : contacts) {
        %>
        <tr>
            <td><%= c.getName() %></td>
            <td><%= c.getEmail() %></td>
            <td><%= c.getPhone() %></td>
        </tr>
        <% } %>
    </table>

    <!-- Navigation Button -->
    <button class="btn" onclick="window.location.href='addContact.jsp'">Add New Contact</button>
</body>
</html>