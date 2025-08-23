package com.contactmanager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<Contact> contactList = new ArrayList<>();

    // Add contact and redirect to view page
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        Contact contact = new Contact(name, email, phone);
        contactList.add(contact);

        // Redirect to view contacts
        request.setAttribute("contacts", contactList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contacts.jsp");
        dispatcher.forward(request, response);
    }

    // View contacts directly
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("contacts", contactList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contacts.jsp");
        dispatcher.forward(request, response);
    }
}