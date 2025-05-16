package Basics;

public class PrintSumofFirstN {
    static int print(int n) {
        if (n == 0)
            return 0;
        return n + print(n - 1);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println(print(5));
    }
}
