package com.contactmanager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Map this servlet to /ContactServlet
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handles POST requests from the contact form
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // Create a new Contact object
        Contact contact = new Contact(name, email, phone);

        // Add contact to the shared list
        ContactList.addContact(contact);

        // Redirect to the contact list page
        response.sendRedirect("viewContacts.jsp");
    }

    // Optional: Handle GET requests for testing
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().println("ContactServlet is running!");
    }
}