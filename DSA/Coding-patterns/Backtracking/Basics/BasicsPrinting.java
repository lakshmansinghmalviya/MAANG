package Basics;
public class BasicsPrinting {

    static void printN(int n) {
        if (n == 0)
            return;

        printN(n - 1);
        printN(n - 1);
        System.out.println(n);
    }

    public static void main(String[] a) {
        printN(2);
    }
}