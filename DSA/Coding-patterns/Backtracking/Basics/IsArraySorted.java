package Basics;

public class IsArraySorted {
    static boolean isArraySorted(int arr[], int index) {
        if (index == arr.length - 1)
            return true;
        if (arr[index] > arr[index + 1])
            return false;
        return isArraySorted(arr, index + 1);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println(isArraySorted(new int[] { 1, 2, 3, 0, 5 }, 0));
    }
}
