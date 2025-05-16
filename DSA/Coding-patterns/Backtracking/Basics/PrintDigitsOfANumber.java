package Basics;

public class PrintDigitsOfANumber {
    static void printDigits(int n) {
        if (n == 0)
            return;
        System.out.println();
        System.out.println(n % 10);
        printDigits(n / 10);
    }

    public static void main(String[] args) {
        printDigits(123);
    }
}
