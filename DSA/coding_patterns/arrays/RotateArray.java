import java.util.Arrays;

class RotateArray {

    void reverse(int arr[], int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    void rotate(int[] nums, int k) {
        k = k % nums.length;
        int n = nums.length - 1;
        reverse(nums, nums.length - k, n);
        System.out.println(Arrays.toString(nums));
        reverse(nums, 0, n);
        reverse(nums, k, n);
    }
}

// k=3
// [1,2,3,4,5,6,7] reverse (n-k,n) ->
// [1,2,3,4,7,6,5] reverse(0,n);
// 5,6,7,4,3,2,1 reverser (0 , n-k)
// 5 6 7 1 2 3 4