package ua.hillel.menu.action;

import lombok.RequiredArgsConstructor;
import ua.hillel.services.ContactService;
import ua.hillel.ui.ContactView;

@RequiredArgsConstructor
public class ShowAllContactsMenuAction implements MenuAction {

    private final ContactService contactService;
    private final ContactView contactView;

    @Override
    public String getName() {
        return "Показать все контакты";
    }

    @Override
    public void doAction() {
        contactView.writeContacts(contactService.getAll());
    }
}
