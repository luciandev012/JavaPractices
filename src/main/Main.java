package main;

import controller.AboardProgramController;
import controller.Validation;
import entities.CheckResult;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(System.in);
        String[] mainMenu = new String[]{"Manage aboard programs", "Manage students", "Register a program for a student", "Report"};
        int choice = 0;
        System.out.println("a\t\t\t\tb");
        do {
            Menu.printMenu("Aboard Program", mainMenu);
            choice = Integer.parseInt(sc.nextLine());
            if(checkValidChoice(choice, mainMenu.length)) {
                System.out.println("Invalid choice! Choose again");
            }
        }while(checkValidChoice(choice, mainMenu.length));
        switch (choice) {
            case 1: {
                AboardProgramController aboardProgramController = new AboardProgramController("./src/input/AboardProgram.txt");
                int aboardChoice = 0;
                int aboardMenuLength = aboardProgramController.getMenuLength();
                do {
                    aboardProgramController.displayAboardMenu();
                    aboardChoice = Integer.parseInt(sc.nextLine());
                    if(checkValidChoice(aboardChoice, aboardMenuLength)) {
                        System.out.println("Invalid choice! Choose again");
                    }
                }while (checkValidChoice(aboardChoice, aboardMenuLength));
                switch (aboardChoice) {
                    case 1: {
                        aboardProgramController.displayAllAboard();
                    } break;
                    case 2: {
                        System.out.println("Add new aboard program:");
                        String id = "";
                        CheckResult res = null;
                        do {
                            System.out.print("Enter Id of program: ");
                            id = sc.nextLine();
                            res = aboardProgramController.checkIdProgram(id);
                            if(!res.getResult()){
                                System.out.println(res.getMessage());
                            }
                        }while (res == null || !res.getResult());
                        aboardProgramController.addNewAboardProgram();
                    } break;
                    case 4: {
                        System.out.print("Please input id to find: ");
                        String id = sc.nextLine();
                        aboardProgramController.displayAboardById(id);
                    } break;
                }
            }
        }
    }

    static boolean checkValidChoice(int choice, int max) {
        return choice < 1 || choice > max;
    }
}
