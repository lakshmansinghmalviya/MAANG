package Basics;

public class FindOccurence {
    static int findOccurence(int arr[], int ele, int index, int ocr) {
        if (index >= arr.length)
            return ocr;
        if (ele == arr[index])
            ocr++;
        return findOccurence(arr, ele, index + 1, ocr);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println(
                findOccurence(new int[] { 1, 2, 3, 4, 5,3 }, 3, 0, 0));
    }
}
