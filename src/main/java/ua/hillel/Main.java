package ua.hillel;

import ua.hillel.menu.Menu;
import ua.hillel.menu.action.*;
import ua.hillel.services.BitFileContactService;
import ua.hillel.services.CSVContactService;
import ua.hillel.services.ContactService;
import ua.hillel.services.ListContactService;
import ua.hillel.ui.ContactView;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactView contactView=new ContactView(scanner);
        ContactService contactService = new CSVContactService();

        List<MenuAction> menuActions = Arrays.asList(
                new ShowAllContactsMenuAction(contactService,contactView),
                new AddContactMenuAction(contactService,contactView),
                new DeleteContactMenuAction(contactService,contactView),
                new SearchContactMenuAction(contactService,contactView)
        );


        Menu menu = new Menu(menuActions, scanner);
        menu.run();
    }
}
