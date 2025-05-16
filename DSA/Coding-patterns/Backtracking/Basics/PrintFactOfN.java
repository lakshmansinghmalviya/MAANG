package Basics;

public class PrintFactOfN {
    static int  printFact(int n){
        if(n==0) return 1;
        return n * printFact(n-1);
     }
    public static void main(String[] args) {
        System.out.println();
        System.out.println(printFact(5));
    }
}
