package ua.hillel.menu.action;

import lombok.RequiredArgsConstructor;
import ua.hillel.services.ContactService;
import ua.hillel.ui.ContactView;

@RequiredArgsConstructor
public class SearchContactMenuAction implements MenuAction{

    private final ContactService contactService;
    private final ContactView contactView;

    @Override
    public String getName() {
        return "Поиск контакта";
    }

    @Override
    public void doAction() {
        String search = contactView.readSearch();
        contactView.writeContacts(contactService.searchContact(search));
    }
}
