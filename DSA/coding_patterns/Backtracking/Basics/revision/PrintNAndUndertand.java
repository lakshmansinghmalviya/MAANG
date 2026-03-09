package coding_patterns.backtracking.basics.revision;

public class PrintNAndUndertand {

    public static void printN(int n) {
        if (n == 0)
            return;
        printN(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        // print 1- N without using the sec var
        printN(5);
        ;
    }
}