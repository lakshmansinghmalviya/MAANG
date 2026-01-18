// https://takeuforward.org/data-structure/check-if-an-array-represents-a-min-heap

package coding_patterns.heap;

// check if the heap is min heap or not

public class CheckMinHeapOrNot {

    boolean isMinHeapOrNot(int arr[]) {

        int n = arr.length / 2 - 1;

        for (int i = 0; i <= n; i++) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            if (left < arr.length && right < arr.length && arr[i] < arr[left] && arr[i] < arr[right])
                continue;
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // int arr[] = { 10, 20, 30, 21, 23 };
        int arr[] = { 10, 20, 30, 25, 15 };
        CheckMinHeapOrNot checkMinHeapOrNot = new CheckMinHeapOrNot();
        System.out.println(checkMinHeapOrNot.isMinHeapOrNot(arr));
    }
}