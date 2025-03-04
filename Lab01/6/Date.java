import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Date {
    private static final Map<String, Integer> MONTHS = new HashMap<>();
    private static final int[] DAYS_IN_MONTH_COMMON = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] DAYS_IN_MONTH_LEAP = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static {
        String[] monthNames = {"january", "february", "march", "april", "may", "june",
                "july", "august", "september", "october", "november", "december"};
        String[] monthAbbr = {"jan", "feb", "mar", "apr", "may", "jun",
                "jul", "aug", "sep", "oct", "nov", "dec"};
        String[] monthAbbrWithDot = {"jan.", "feb.", "mar.", "apr.", "may", "june",
                "july", "aug.", "sept.", "oct.", "nov.", "dec."};

        for (int i = 0; i < 12; i++) {
            MONTHS.put(monthNames[i], i + 1);
            MONTHS.put(monthAbbr[i], i + 1);
            MONTHS.put(monthAbbrWithDot[i], i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year = getValidYear(scanner);
        String monthInput = getValidMonth(scanner);
        int monthNumber = getMonthNumber(monthInput);
        int days = getDaysInMonth(monthNumber, year);

        System.out.println("The month " + formatMonthOutput(monthInput) + " in " + year + " has " + days + " days.");

        scanner.close();
    }

    private static int getValidYear(Scanner scanner) {
        int year = -1;
        while (year < 0) {
            System.out.print("Enter the year : ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year < 0) {
                    System.out.println("Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric year ");
                scanner.next();
            }
        }
        return year;
    }

    private static String getValidMonth(Scanner scanner) {
        String month = "";
        while (true) {
            System.out.print("Enter the month: ");
            month = scanner.next().trim().toLowerCase();
            if (isValidMonth(month)) {
                break;
            } else {
                System.out.println("Invalid month. Please enter a valid month format ");
            }
        }
        return month;
    }

    private static boolean isValidMonth(String month) {
        if (month.matches("\\d+")) {
            int monthNum = Integer.parseInt(month);
            return monthNum >= 1 && monthNum <= 12;
        }
        return MONTHS.containsKey(month);
    }

    private static String formatMonthOutput(String month) {
        if (month.matches("\\d+")) {
            int monthNum = Integer.parseInt(month);
            String[] monthNames = {"January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"};
            return monthNames[monthNum - 1];
        }
        return month.substring(0, 1).toUpperCase() + month.substring(1);
    }

    private static int getMonthNumber(String month) {
        if (month.matches("\\d+")) {
            return Integer.parseInt(month);
        }
        return MONTHS.getOrDefault(month, 1);
    }

    private static int getDaysInMonth(int monthNumber, int year) {
        boolean isLeapYear = isLeapYear(year);
        return isLeapYear ? DAYS_IN_MONTH_LEAP[monthNumber - 1] : DAYS_IN_MONTH_COMMON[monthNumber - 1];
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}