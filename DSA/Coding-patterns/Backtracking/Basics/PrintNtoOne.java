package Basics;

import java.util.*;

// print one to n and return a list of the same elements
// 5 4 3 2 1
public class PrintNtoOne {
    // reference understadnding....
    public static List<Integer> print(int n, List<Integer> list) {
        if (n == 0)
            return list;
        list.add(n);
        System.out.println(n);
        List<Integer> newList = print(n - 1, list);
        System.out.println(list + "   " + newList);
        return newList;
    }

    // WE should store the result if we dont want of the stack and want of the last
    // return whenever the base case is reached

    // public static List<Integer> print(int n, List<Integer> list) {
    // if (n == 0)
    // return list;
    // list.add(n);
    // System.out.println(n);
    // List<Integer> newList = print(n - 1, list);
    // System.out.println(list+" "+newList);
    // return newList;
    // }

    // without ref understadnding....
    // public static int print(int n, int sum) {
    // if (n == 0)
    // return sum;
    // sum += n;
    // System.out.println(n);
    // int finalSum = print(n - 1, sum);// if we dont store the value of the sum
    // then it will print the value of the
    // // stack
    // // if we store and then return then i will give the last sum else it gives
    // sum
    // // from the stack
    // System.out.println(sum + " " + finalSum);
    // return finalSum;
    // }

    public static void print(int i, int n) {
        if (i > n)
            return;
        print(i + 1,n);
        System.out.println();
        System.out.println();
        System.out.println(i);
    }

    public static void main(String[] args) {
        // System.out.println(print(4, new ArrayList<>()));
        // System.out.println(print(4, 0));
        print(1, 5);
    }
}
