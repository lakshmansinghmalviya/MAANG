package Basics;
public class OneToNPrinting {

    public static void printOneToN(int n) {
        if (n == 0) {
            return;
        }
        printOneToN(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        int N = 5;
        printOneToN(N);
    }
}