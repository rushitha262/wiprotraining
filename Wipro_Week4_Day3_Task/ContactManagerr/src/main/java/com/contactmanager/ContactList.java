package com.contactmanager;

import java.util.ArrayList;
import java.util.List;

public class ContactList {
    private static List<Contact> contacts = new ArrayList<>();

    public static void addContact(Contact contact) {
        contacts.add(contact);
    }

    public static List<Contact> getAllContacts() {
        return contacts;
    }
    public static Contact getContactByEmail(String email) {
		return null;
        // your logic here
    }
}