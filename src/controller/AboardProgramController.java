package controller;

import entities.AboardProgram;
import entities.CheckResult;
import main.Menu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AboardProgramController {
    private final ArrayList<AboardProgram> listAboards;
    private final  String[] aboardMenu = new String[]{
            "Display all aboard programs",
            "Add a new board program",
            "Edit information a program by Id",
            "Search and display a program by Id",
            "Back to main Menu"};

    public AboardProgramController(String aboardPath) throws FileNotFoundException, ParseException {
        System.setIn(new FileInputStream(aboardPath));
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        listAboards = new ArrayList<AboardProgram>();
        while(sc.hasNextLine()) {
            String tempInput = sc.nextLine();
            String[] tempInputArr = tempInput.split(",");
            AboardProgram aboardProgram = new AboardProgram(tempInputArr[0], tempInputArr[1], tempInputArr[2], dateFormat.parse(tempInputArr[3]), dateFormat.parse(tempInputArr[4]), Integer.parseInt(tempInputArr[5]), tempInputArr[6] + ", " + tempInputArr[7], Float.parseFloat(tempInputArr[8]), tempInputArr[9]);
            listAboards.add(aboardProgram);
        }
    }

    public void displayAllAboard() {
        displayHeader("All board programs:");
        for(int i = 0; i < listAboards.size(); i++) {
            listAboards.get(i).print(i + 1);
        }
    }

    public void addNewAboardProgram() {

    }

    public CheckResult checkIdProgram(String id) {
        if(id.trim().isEmpty()) {
            return new CheckResult(false, "Id must not be empty");
        }else {
            boolean check = true;
            for(int i = 0; i < listAboards.size(); i++) {
                if(listAboards.get(i).getId().equalsIgnoreCase(id)) {
                    check = false;
                    break;
                }
            }
            if(!check) {
                return new CheckResult(false, "Id is duplicate");
            }
        }
        return new CheckResult(true, "");
    }

    public void displayAboardById(String id) {
        AboardProgram result = null;
        for(AboardProgram aboardProgram : listAboards) {
            if(aboardProgram.getId().equalsIgnoreCase(id)) {
                result = aboardProgram;
            }
        }
        if(result != null) {
            displayHeader("Result");
            result.print(1);
        }else {
            System.out.println("Cannot find program matches specified id");
        }
    }

    public void displayAboardMenu() {
        Menu.printMenu("Manage aboard programs", aboardMenu);
    }
    public int getMenuLength() {
        return aboardMenu.length;
    }

    private void displayHeader(String title) {
        System.out.println(title);
        System.out.format("%-5s%-5s%-30s", "No", "Id", "Name"); //can write multiple variable in 1 line, but the line in this case is too long.
        System.out.format("%-15s", "Time");
        System.out.format("%-15s", "From Reg Date");
        System.out.format("%-15s", "End Reg Date");
        System.out.format("%-5s", "Days");
        System.out.format("%-50s", "Location");
        System.out.format("%-10s", "Cost");
        System.out.format("%-20s\n", "Content");
    }
}
