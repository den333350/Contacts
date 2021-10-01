package ua.hillel.menu.action;

import lombok.RequiredArgsConstructor;
import ua.hillel.services.ContactService;
import ua.hillel.ui.ContactView;

@RequiredArgsConstructor
public class DeleteContactMenuAction implements MenuAction{

    private final ContactService contactService;
    private final ContactView contactView;

    @Override
    public String getName() {
        return "Удалить контакт";
    }

    @Override
    public void doAction() {
        contactService.removeContact(contactView.readIndex());
    }
}
