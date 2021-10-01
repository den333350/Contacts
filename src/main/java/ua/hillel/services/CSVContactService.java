package ua.hillel.services;

import ua.hillel.Contacts.Contact;
import ua.hillel.Contacts.Type;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSVContactService implements ContactService{
    private final String filename = "contacts.csv";
    private List<Contact> contactlist = new ArrayList<>();
    @Override
    public List getAll() {
        try(FileReader reader = new FileReader(filename)){
            BufferedReader buffer = new BufferedReader(reader);
            contactlist = buffer.lines()
                    .map(l->l.split(","))
                    .map(a->new Contact(a[0],a[1],Type.valueOf(a[2])))
                    .collect(Collectors.toList());
        } catch (IOException e) {
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

        try (FileWriter writer = new FileWriter(filename)){
            for (Contact contact : contactlist) {
                writer.write(String.format("%s,%s,%s\n", contact.getName(), contact.getPhone(), contact.getType()));
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
