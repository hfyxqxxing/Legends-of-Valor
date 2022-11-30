/*
 * This class is a scanner singleton warpper
 */

package legendsofvalor.utils;

import java.util.Scanner;

public class UserInput {
    private static UserInput instance;
    private Scanner scanner;

    private UserInput() {
        scanner = new Scanner(System.in);
    }

    public static UserInput getInstance() {
        if (instance == null) {
            instance = new UserInput();
        }
        return instance;
    }

    public String getString() {
        return scanner.nextLine();
    }

    public int getInt() {
        while (!scanner.hasNextInt()) {
            ColorPrint.error("Not a valid integer, please try again.");
            scanner.next();
        }
        int re = scanner.nextInt();
        scanner.nextLine();
        return re;
    }

    public int getChoice(int min, int max) {
        int choice;
        while (true) {
            choice = getInt();
            if (choice >= min && choice <= max) {
                break;
            }
            ColorPrint.error("Choice out of range, please try again.");
        }
        scanner.nextLine();
        return choice;
    }

    public void getNextline() {
        scanner.nextLine();
    }

}
