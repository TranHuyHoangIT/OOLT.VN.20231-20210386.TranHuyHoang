package hust.soict.hedspi.lab01;
import java.util.Scanner;

public class NumbersOfDays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month;
        int year;

        while (true) {
            System.out.print("Enter month: ");
            month = scanner.nextLine().toLowerCase();

            if (isValidMonth(month)) {
                break;
            } else {
                System.out.println("Invalid month. Try again.");
            }
        }

        while (true) {
            System.out.print("Enter year: ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year >= 0) {
                    break;
                }
            }
            scanner.nextLine(); 
            System.out.println("Invalid year. Try again");
        }

        scanner.close();

        int days = getDaysInMonth(month, year);
        System.out.println("Number of days is: " + days + " days.");
    }

    public static boolean isValidMonth(String input) {
        String[] validMonths = {"january", "jan.", "jan", "1", "february", "feb.", "feb", "2", "march", "mar.", "mar", "3",
                "april", "apr.", "apr", "4", "may", "5", "june", "jun.", "jun", "6", "july", "jul.", "jul", "7",
                "august", "aug.", "aug", "8", "september", "sept.", "sept", "9", "october", "oct.", "oct", "10",
                "november", "nov.", "nov", "11", "december", "dec.", "dec", "12"};

        for (String validMonth : validMonths) {
            if (validMonth.equals(input)) {
                return true;
            }
        }
        return false;
    }

    public static int getDaysInMonth(String month, int year) {
        int days;
        switch (month) {
            case "january":
            case "jan.":
            case "jan":
            case "1":
            case "march":
            case "mar.":
            case "mar":
            case "3":
            case "may":
            case "5":
            case "july":
            case "jul.":
            case "jul":
            case "7":
            case "august":
            case "aug.":
            case "aug":
            case "8":
            case "october":
            case "oct.":
            case "oct":
            case "10":
            case "december":
            case "dec.":
            case "dec":
            case "12":
                days = 31;
                break;
            case "february":
            case "feb.":
            case "feb":
            case "2":
                days = isLeapYear(year) ? 29 : 28;
                break;
            default:
                days = 30;
                break;
        }
        return days;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
