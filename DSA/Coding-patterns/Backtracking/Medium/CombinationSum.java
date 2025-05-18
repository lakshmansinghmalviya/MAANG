package Medium;

import java.util.*;

public class CombinationSum {
    // given an arry of the distinct elements
    // return a list of the list Which sums upto a target
    // [2,3,4] k=7
    // ans [[2,2,3], [3,4]]

    public static void combinationSum(int arr[], int index, List<Integer> list, List<List<Integer>> lists, int target,
            int sum) {
        if (index >= arr.length)
            return;
        if (target == sum) {
            lists.add(new ArrayList<>(list));
            return;
        }
        if (sum > target)
            return;

        list.add(arr[index]);
        sum += arr[index];
        combinationSum(arr, index, list, lists, target, sum);
        list.removeLast();
        sum -= arr[index];
        combinationSum(arr, index + 1, list, lists, target, sum);
    }

    // return any sub sequence of the target
    public static List<Integer> combinationSum(int arr[], int index, int target, int sum, List<Integer> list) {
        if (index >= arr.length) {
            if (target == sum)
                return new ArrayList<>(list);
            return new ArrayList<>();
        }
        if (target == sum)
            return new ArrayList<>(list);

        if (sum > target)
            return new ArrayList<>();

        list.add(arr[index]);
        sum += arr[index];
        List<Integer> list1 = combinationSum(arr, index + 1, target, sum, list);
        list.removeLast();
        sum -= arr[index];
        List<Integer> list2 = combinationSum(arr, index + 1, target, sum, list);
        System.out.println("list1&2 " + list1 + list2);

        if (!list1.isEmpty())
            return list1;

        if (!list2.isEmpty())
            return list2;
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        int arr[] = new int[] { 2, 3, 4 };
        combinationSum(arr, 0, new ArrayList<>(), lists, 7, 0);
        System.out.println(combinationSum(arr, 0, 4, 0, new ArrayList<>()));
        System.out.println();
        System.out.println(lists);
    }
}
