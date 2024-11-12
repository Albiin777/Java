import java.io.*;
import java.util.*;

// Base class representing a person

class Person {
    private String name;
    private String address;

    // Constructor to initialize name and address

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter for name

    public String getName() {
        return name;
    }

    // Setter for name

    public void setName(String name) {
        this.name = name;
    }

    // Getter for address

    public String getAddress() {
        return address;
    }

    // Setter for address

    public void setAddress(String address) {
        this.address = address;
    }

    // Method to be overridden in the derived class

    public String getContactInfo() {
        return "Name: " + name + ", Address: " + address;
    }

    // Overriding the toString() method to return contact info

    @Override
    public String toString() {
        return getContactInfo();
    }
}

// Derived class representing a contact, extends Person

class Contact extends Person {
    private String phoneNumber;

    // Constructor to initialize name, address, and phone number

    public Contact(String name, String address, String phoneNumber) {
        super(name, address);  // Calling the base class constructor
        this.phoneNumber = phoneNumber;
    }

    // Getter for phone number

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter for phone number

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Overriding the getContactInfo() method to include phone number
    @Override

    public String getContactInfo() {
        return super.getContactInfo() + ", Phone Number: " + phoneNumber;
    }

    // Overriding the toString() method to return the updated contact info
    @Override

    public String toString() {
        return getContactInfo();
    }
}




// AddressBook class to manage an array of contacts

class AddressBook {
    private Contact[] contacts;   // Array to hold Contact objects
    private int count; 		 // Number of contacts currently in the address book

    // Constructor to initialize the address book with a specified capacity

    public AddressBook(int capacity) 
{
        contacts = new Contact[capacity];  // Initialize the array with the given capacity
        count = 0;  // Start with zero contacts
    }

    // Method to add a contact to the address book

    public void addContact(Contact contact) throws Exception {
        // Check if the address book is full
        if (count >= contacts.length) {
            throw new Exception("Address book is full.");
        }
        // Check if a contact with the same name already exists
        for (int i = 0; i < count; i++) {
            if (contacts[i].getName().equals(contact.getName())) {
                throw new Exception("Contact with this name already exists.");
            }
        }
        // Add the contact to the array and increment the count
        contacts[count++] = contact;
    }

    // Method to remove a contact by name

    public void removeContact(String name) throws Exception {
        int indexToRemove = -1;

        // Find the index of the contact to be removed

        for (int i = 0; i < count; i++) {
            if (contacts[i].getName().equals(name)) {
                indexToRemove = i;
                break;
            }
        }
        // If the contact was not found, throw an exception

        if (indexToRemove == -1) {
            throw new Exception("Contact not found.");
        }
        // Shift the remaining contacts in the array to fill the gap
        for (int i = indexToRemove; i < count - 1; i++) {
            contacts[i] = contacts[i + 1];
        }
        // Nullify the last contact and decrement the count
        contacts[--count] = null;
    }

    // Method to search for a contact by name

    public Contact searchContact(String name) throws Exception {
        // Iterate through the contacts to find a match
        for (int i = 0; i < count; i++) {
            if (contacts[i].getName().equals(name)) {
                return contacts[i];  // Return the found contact
            }
        }
        // If the contact was not found, throw an exception
        throw new Exception("Contact not found.");
    }

    // Method to display all contacts in the address book

    public void displayContacts() {
        // Iterate through the contacts and print each one
        for (int i = 0; i < count; i++) {
            System.out.println(contacts[i]);
        }
    }
}

// Main class to test the AddressBook functionality

public class CodingArena2 {
    public static void main(String[] args) {
        try {
            // Initialize the address book with a capacity of 10 contacts
            AddressBook addressBook = new AddressBook(10);

            // Create some contacts
            Contact contact1 = new Contact("Alice", "123 Main St", "555-1234");
            Contact contact2 = new Contact("Bob", "456 Elm St", "555-5678");

            // Add the contacts to the address book
            addressBook.addContact(contact1);
            addressBook.addContact(contact2);

            // Display all contacts in the address book
            addressBook.displayContacts();

            // Test searching for a contact by name
            Contact foundContact = addressBook.searchContact("Alice");
            System.out.println("Found contact: " + foundContact);

            // Test removing a contact by name
            addressBook.removeContact("Alice");
            addressBook.displayContacts();

            // Test handling exceptions by trying to remove a non-existent contact
            addressBook.removeContact("Alice");  // This will throw an exception
        } catch (Exception e) {
            // Catch and print any exceptions that occur during the test
            System.out.println("Error: " + e.getMessage());
        }
    }
}
