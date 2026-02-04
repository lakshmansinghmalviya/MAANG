import java.util.*;

public class MaxSubArrayXOR {
   static  int  subArrays(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();
         map.put(0, 1);
         int sum = 0;
         int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            sum ^=arr[i];
           if(map.containsKey(sum ^ arr[i])){
                 cnt  += map.get(sum ^ arr[i]);
           }
           map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
     return cnt;
    }
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 3, 4, 5, 6 };
        System.out.println(subArrays(arr));
    }
}