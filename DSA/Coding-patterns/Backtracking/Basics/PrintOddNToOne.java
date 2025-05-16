package Basics;

public class PrintOddNToOne {
    public static String printOdd(int n, String s) {
        if (n == 0)
            return s;
        if (n % 2 != 0) {
            System.out.println(n);
            s += n;
        }
        String temp = printOdd(n - 1, s);
        return temp;
    }
    
    // String also works like the primitive only if we dont store and then returns from the stack just like the int sum 
    // public static String printOdd(int n, String s) {
    //     if (n == 0)
    //         return s;
    //     if (n % 2 != 0) {
    //         System.out.println(n);
    //         s += n;
    //     }
    //     printOdd(n - 1, s);
    //     return s;
    // }

    public static void main(String[] args) {
      System.out.println(printOdd(5,""));
    }
}
