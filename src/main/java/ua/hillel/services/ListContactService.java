package ua.hillel.services;

import ua.hillel.Contacts.Contact;

import java.util.ArrayList;
import java.util.List;

public class ListContactService implements ContactService {
    List<Contact> contacts = new ArrayList<>();

    @Override
    public List<Contact> getAll() {
        return contacts;
    }

    @Override
    public void removeContact(int index) {
        contacts.remove(index);
    }

    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> searchContact(String search){
        List<Contact> searches = ListUtils.filter(contacts,
                contact -> contact.getName().startsWith(search));
//        for (Contact contact : contacts) {
//            if (contact.getName().startsWith(search)) {
//                searches.add(contact);
//            }
//        }
        return searches;
    }
}