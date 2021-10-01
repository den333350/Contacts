package ua.hillel.menu.action;

import lombok.RequiredArgsConstructor;
import ua.hillel.services.ContactService;
import ua.hillel.ui.ContactView;

@RequiredArgsConstructor
public class AddContactMenuAction implements MenuAction {

    private final ContactService contactService;
    private final ContactView contactView;

    @Override
    public String getName() {
        return "Добавать контакт";
    }

    @Override
    public void doAction() {
        System.out.println("Создайте новый контакт:");
        contactService.addContact(contactView.readContact());
    }
}
