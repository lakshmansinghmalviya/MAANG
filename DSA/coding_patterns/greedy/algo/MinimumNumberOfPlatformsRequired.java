package algo;

import java.util.Arrays;

public class MinimumNumberOfPlatformsRequired {

    // T- NlonN
    // S-(N)-(1)//No need to store using merge two sorted array concept
    public int minimumNumberOfPlatformsRequiredOptimal(int arrive[], int depart[]) {
        int maxCnt = 0;
        int n = arrive.length;

        Arrays.sort(arrive);
        Arrays.sort(depart);
        int i = 0;
        int j = 0;
        int cnt = 0;

        while (i < n && j < n) {
            if (arrive[i] < depart[j]) {
                cnt++;
                i++;
            } else {
                cnt--;
                j++;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }

    public static void main(String[] args) {
        MinimumNumberOfPlatformsRequired m = new MinimumNumberOfPlatformsRequired();
        // [900, 1100, 1235]
        // [1000, 1200, 1240]
        int arrive[] = { 900, 1100, 1235 };
        int depart[] = { 1000, 1200, 1240 };

        System.out.println(m.minimumNumberOfPlatformsRequiredOptimal(arrive, depart));
    }

    // Brute force T- n^2
    // S- (1)
    // Similar to merge intervals problem
    public int minimumNumberOfPlatformsRequired(int arrive[], int depart[]) {
        int maxCnt = 0;
        int n = arrive.length;

        for (int i = 0; i < n; i++) {
            int cnt = 1;

            // [900, 1100, 1235]
            // [1000, 1200, 1240]
            // Output : 1

            for (int j = i + 1; j < n; j++) {

                if (depart[i] >= arrive[j]) {
                    cnt++;
                }
                maxCnt = Math.max(maxCnt, cnt);

            }
        }
        return maxCnt;
    }
}