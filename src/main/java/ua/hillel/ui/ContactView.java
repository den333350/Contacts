package ua.hillel.ui;

import lombok.RequiredArgsConstructor;
import ua.hillel.Contacts.Contact;
import ua.hillel.Contacts.Type;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class ContactView {
    private final Scanner sc;

    public Contact readContact(){
        System.out.print("Введите имя: ");
        String name = sc.nextLine();
        System.out.print("Номер - 1, почта - 2");
        Type type;
        if(sc.nextInt()==1) {type = Type.NUMBER;
        }else {type = Type.EMAIL;}
        sc.nextLine();
        System.out.print("Ввдите номер:");
        String phone = sc.nextLine();
        System.out.println("\n");
        return new Contact().setName(name).setPhone(phone).setType(type);

    }

    public void writeContact(Contact contact){
        System.out.printf("%18s %13s %5s\n", contact.getName(), contact.getPhone(), contact.getType().toString());
    }


    public void writeContacts(List<Contact> contacts){
        System.out.println("Контакты");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.printf("%d ",i+1);
            writeContact(contacts.get(i));
        }
        System.out.println("_________________");
    }

    public int readIndex(){
        System.out.print("Введите номер: ");
        int iter = sc.nextInt();
        sc.nextLine();
        return --iter;
    }

    public String readSearch(){
        System.out.print("Введите начало контакта: ");
        return sc.nextLine();
    }
}
