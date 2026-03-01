
public class CountOccurInSortedArray {
        
    static int findFirst(int arr[], int k) {
        int low = 0;
        int high = arr.length;
        // 1, 2, 3, 8, 11
        // key-0
        int ans = -1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (k == arr[mid]) {
                ans = mid;
                high = mid;
            } else if (k < arr[mid]) {
                high = mid;
            } else
                low = mid + 1;
        }
        return ans;
    }

    static int findLast(int arr[], int k) {
        int low = 0;
        int high = arr.length;
        // 1, 2, 3, 8, 11
        // key-0
        int ans = -1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (k == arr[mid]) {
                ans = mid;
                low = mid + 1;
            }
            if (k < arr[mid]) {
                high = mid;
            } else
                low = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 8, 8, 8, 11, 11 };
        int k = 11;
        System.out.println(findFirst(arr, k) + "  " + (findLast(arr, k)));
        System.out.println("Total occurence of the num is " + (findLast(arr, k) - findFirst(arr, k) + 1));
    }
}