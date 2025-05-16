package Medium;

import java.util.*;

public class PrintSubSequences {

    static void printSS(int arr[], List<Integer> list, int index, List<List<Integer>> lists) {
        
        if (index >= arr.length) {
            lists.add(new ArrayList<>(list));
            System.out.println(list);
            return;
        }

        list.add(arr[index]);
        printSS(arr, list, index + 1, lists);
        list.removeLast();
        printSS(arr, list, index + 1, lists);
        // System.out.println(lists);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2 };
        List<List<Integer>> list = new ArrayList<>();
        printSS(arr, new ArrayList<>(), 0, list);
        System.out.println(list);
    }
}