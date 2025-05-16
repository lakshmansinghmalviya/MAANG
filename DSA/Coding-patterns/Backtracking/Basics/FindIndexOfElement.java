package Basics;

public class FindIndexOfElement {

    static int printIndex(int arr[], int ele, int index) {
        if (index >= arr.length)
            return -1;
            
        if (ele == arr[index])
            return index;
        return printIndex(arr, ele, index + 1);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println(
                printIndex(new int[] { 1, 2, 3, 4, 3, 5 }, 0, 0));
    }
}
