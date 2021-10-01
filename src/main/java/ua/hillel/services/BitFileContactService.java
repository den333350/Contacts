package ua.hillel.services;

import ua.hillel.Contacts.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BitFileContactService implements ContactService {
    private final String filename ="contactbit.obj";
    private List<Contact> contactlist = new ArrayList<>();
    @Override
    public List getAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
                contactlist =((ArrayList<Contact>)ois.readObject());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return contactlist;
    }

    @Override
    public void removeContact(int index) {
        contactlist.remove(index);
        writeInFileList();
    }

    @Override
    public void addContact(Contact contact) {
        contactlist.add(contact);
        writeInFileList();
    }

    @Override
    public List searchContact(String search) {
        List<Contact> searches = ListUtils.filter(contactlist,
                contact -> contact.getName().startsWith(search));
        return searches;
    }

    private void writeInFileList(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
            oos.writeObject(contactlist);
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
