package Basics;

public class PrintEleEndToStart {
    static void print(int arr[], int index) {
        if (index == arr.length)
            return;
        print(arr, index + 1);
        System.out.println();
        System.out.println(arr[index]);
    }

    public static void main(String[] args) {
        print(new int[] { 1, 2, 3, 4, 5 }, 0);
    }
}
