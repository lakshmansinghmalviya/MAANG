package Basics;

public class ReverseNumber {

    public static int rev(int n) {
        if (n == 0) {
            return 0;
        }
        int rev = rev(n % 10);
        rev = rev * 10 + n%10;
        return rev;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();
      System.out.println(rev(123));
    }
}
