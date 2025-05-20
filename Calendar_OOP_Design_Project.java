import java.util.Scanner;

public class Calendar {
    
    public static void main(String[] args) {
         Scanner Console = new Scanner(System.in);
        System.out.println("Days in the Month: ");
        int monthLength = Console.nextInt();
        System.out.println("What day is the first Sunday of the Month?"); //probably have to fix this eventually
        int firstSunday = Console.nextInt();
        printCalendar(monthLength, firstSunday);
    }

    public static void printCalendar(int monthLength, int firstSunday) {
        int numBlanks;

        numBlanks = (8 - firstSunday) % 7;
        System.out.println("   Sun    Mon   Tues    Wed    Thu    Fri    Sat");
        printDividerRow();
        printFirstWeek(numBlanks);
        int dayspassed = printSecondFourthWeek(firstSunday, monthLength);
        printEnding(dayspassed, monthLength, numBlanks);
        System.out.println();
        printDividerRow();
    }

    public static void printDividerRow() {
        System.out.print("+");
        for (int i = 1; i < 2; i++) {
            for (int j = 1; j <= 7; j++) {
                for (int k = 1; k <= 6; k++) {
                    System.out.print("-");
                }
                System.out.print("+");
            }
        }
    }

    public static void printFirstWeek(int b) {
        for (int i = 0; i < b; i++) {
            for (int j = 0; j == i; j++) {
                System.out.println();
                System.out.print("|");
            }
            printBlankDay();
        }
        //print correct number of real days with numbers
        for (int i = 1; i <= (7 - b) % 7; i++) {
            printDay(i);
        }
    }

    public static int printSecondFourthWeek(int x, int y) {
        for (int a = 1; a <= (y / 7); a++) {
            for (int j = 1; j < 2; j++) {
                System.out.println();
                System.out.print("|");// this could probably be shortened
            }
            for (int i = x; i < x + 7 && i <= y; i++) {
                printDay(i);
            }
            x = x + 7;
        }
        int z = x;
        return z;
    }

    public static void printEnding(int x, int y, int b) {// this could probably be shortened
        for (int n = 29; n == x; n++) {
            System.out.println();
            System.out.print("|");
        }
        for (int i = x; i <= y; i++) {
            printDay(i);
        }

        for (int f = 35; f > y + b; f--) {
            printBlankDay();
        }

    }
   public static void printBlankDay() {
        System.out.print("      |");
    }

    public static void printDay(int i) {
        System.out.print(padded(i, 4) + "  |");
    }

    private static String padded(int n, int width) {
        String s = "" + n;
        for (int i = s.length(); i < width; i++) {
            s = " " + s;
        }
        return s;
    }

}
