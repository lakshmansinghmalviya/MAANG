// https://takeuforward.org/plus/dsa/problems/shortest-job-first

package algo;

import java.util.Arrays;

public class SortestJobFirst {

    public static int averageWaitingTime(int arr[]) {
        Arrays.sort(arr);

        // 1, 2, 3, 4, 7
        // p1 p2 p3 p4 p5

        int averageWaitingTime = 0;
        int time = 0;

        for (int i = 0; i < arr.length; i++) {
            time += averageWaitingTime; // this should always before the below line as we dont want to add the last one,
                                        // coz that won't wait
            averageWaitingTime += arr[i];
        }

        return time / arr.length;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 1, 3, 7, 2 };
        System.out.println(averageWaitingTime(arr));
    }
}