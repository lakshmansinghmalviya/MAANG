package Basics;
import java.util.*;

public class PrintEvenOneToN {
    // static List<Integer> printEven(int n, List<Integer> list , int sum){
    // if(n==0) return list;
    //   list.add(n);
    //   sum+=n;
    //   System.out.println(n);
    //   printEven(n-1, list,sum);
    //   System.out.println(sum);
    //   return list;
    // } 
    static List<Integer> printEven(int n, List<Integer> list , int sum){
        if(n==0) return list;
        if(n%2==0) {
            list.add(n);
            // sum+=n;
        }
          System.out.println(n);
          printEven(n-1, list,sum);
        //   System.out.println(sum);
          return list;
        } 
    public static void main(String[] args) {
     System.out.println(printEven(4, new ArrayList<>(),0));
    }
}
