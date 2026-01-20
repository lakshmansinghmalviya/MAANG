// https://www.naukri.com/code360/problems/merge-two-binary-max-heaps_1170049

package coding_patterns.heap.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoBinaryMaxHeap {

    // means place the root at the correct place
    static void heapify(ArrayList<Integer> arr, int n, int index) {
        int largest = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        if (left < n && arr.get(largest) < arr.get(left)) {
            largest = left;
        }
        if (right < n && arr.get(largest) < arr.get(right)) {
            largest = right;
        }
        if (largest != index) {
            Collections.swap(arr, largest, index);
            heapify(arr, n, largest);
        }
    }

    public static ArrayList<Integer> mergeHeap(List<Integer> arr1, List<Integer> arr2) {

        ArrayList<Integer> ans = new ArrayList<>();
        if (arr1 != null && !arr1.isEmpty())
            ans.addAll(arr1);
        if (arr2 != null && !arr2.isEmpty())
            ans.addAll(arr2);
        // System.out.println(ans);
        // 0 based indexing means 2*i+1;
        // 1 based indexing means 2*i
        int size = ans.size();

        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapify(ans, size, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(10, 5, 6, 2);
        List<Integer> list2 = List.of(12, 7, 9);
        List<Integer> merged = MergeTwoBinaryMaxHeap.mergeHeap(list1, list2);
        System.out.println(merged); // 12 10 9 2 5 7 6
    }
}