package main;

public class Menu {
    public static void printMenu(String title, String[] menu) {
        System.out.println(title);
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + 1 + ". " + menu[i]);
        }
        System.out.print("Your choice (1 - " + menu.length + "): ");
    }
}
