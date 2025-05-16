
import java.util.*;

public class MoveZerosToEnd {

    static Scanner sc = new Scanner(System.in);

    static void inputArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static void main(String[] a) {

        int n = sc.nextInt();
        int arr[] = new int[n];
        inputArray(arr);
        System.out.println(Arrays.toString(arr));
        moveZerosToEnd(arr);
        System.out.println(Arrays.toString(arr));
    }

   static void moveZerosToEnd(int arr[]) {
        // 1 2 0 7 0 8
        int r = 0, l = 0;
        while (r < arr.length) {
            if(arr[l]==0 && arr[r]!=0){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r++;
            }
            else if(arr[r]==0 && arr[l]!=0){
                l=r;
                r++;
            }
            else r++;
        }
    }
}
