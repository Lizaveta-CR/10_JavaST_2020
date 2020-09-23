package by.tsvirko.task02.task2;

public class InverseString {
    public static void main(String[] args) {
        reverse(args);
    }

    private static void reverse(String[] args) {
        if (args.length == 0) {
            System.out.println("Args are empty!");
        } else if (args.length == 1) {
            System.out.println("Nothing to reverse!");
        } else {
            for (int i = args.length - 1; i >= 0; i--) {
                System.out.println(args[i]);
            }
        }
    }
}
