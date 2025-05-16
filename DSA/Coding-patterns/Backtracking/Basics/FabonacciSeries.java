package Basics;
public class FabonacciSeries {

    // static void printFabTillN(int n, int a, int b){
    // if(n<=1){
    // System.out.println(a);
    // return;
    // }
    // printFabTillN(n-1,b, a+b);
    // }
    static int returnFabOfN(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return returnFabOfN(n - 1) + returnFabOfN(n - 2);
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(returnFabOfN(n-1));
    }
}
// 0 1 1 2 3 5 8 13 21
// print a
// then send b,a+b
