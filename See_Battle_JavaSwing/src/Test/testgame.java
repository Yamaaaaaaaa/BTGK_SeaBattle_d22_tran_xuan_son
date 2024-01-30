package Test;

import model.menu.Menu_Selection;
import view.View_SelectionMenu;

import java.util.Scanner;

public class testgame {

    public static final Scanner  sc = new Scanner(System.in);
    public static void main(String[] args) {
        Menu_Selection menuSelection = new Menu_Selection();
        View_SelectionMenu viewSelectionMenu = new View_SelectionMenu(menuSelection);
        viewSelectionMenu.open();
    }
}
//0 0
//0 1
//1 0
//1 1
//2 0
//2 3
//3 0
//3 2
//4 0
//4 4