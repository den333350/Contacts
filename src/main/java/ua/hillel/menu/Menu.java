package ua.hillel.menu;

import ua.hillel.menu.action.MenuAction;

import java.util.List;
import java.util.Scanner;

public class Menu {
    List<MenuAction> menuActions;
    Scanner scanner;
    public Menu(List menuActions , Scanner scanner){
        this.menuActions = menuActions;
        this.scanner = scanner;
    }
    public void run(){
        while (true) {
            for (int i = 0; i <= menuActions.size(); i++) {
                if (i < menuActions.size()) System.out.printf("%d - %s ", i+1, menuActions.get(i).getName());
                else {
                    System.out.printf("%d - Выход\n", i+1);
                }
            }

            int choose =scanner.nextInt() ;
            scanner.nextLine();
            if(--choose < menuActions.size()){
                menuActions.get(choose).doAction();
            }
            else break;

        }
    }
}
