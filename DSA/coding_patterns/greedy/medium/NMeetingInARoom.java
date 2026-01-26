// https://takeuforward.org/plus/dsa/problems/n-meetings-in-one-room

package medium;

import java.util.Arrays;

public class NMeetingInARoom {

    public int nMeetingInARoom(int arr1[], int arr2[]) {

        // Use the TPair with the array or priorityQueue

        int arr[][] = new int[arr1.length][3];

        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = arr1[i];
            arr[i][1] = arr2[i]; // meeting ending time
            arr[i][2] = i; // index not needed until the interviewer demands
        }

        Arrays.sort(arr, (a, b) -> (a[1] - b[1]));
        int previousMeetinEndedAt = arr[0][1];
        int cnt = 1;

        for (int i = 1; i < arr.length; i++) {
            if (previousMeetinEndedAt < arr[i][0]) {
                previousMeetinEndedAt = arr[i][1];
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        NMeetingInARoom nMeetingInARoom = new NMeetingInARoom();
        int arr1[] = { 1, 3, 0, 5, 8, 5 };
        int arr2[] = { 2, 4, 6, 7, 9, 9 };
        System.out.println(nMeetingInARoom.nMeetingInARoom(arr1, arr2));
    }
}