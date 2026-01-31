// https://takeuforward.org/plus/dsa/problems/job-sequencing-problem

package algo;

import java.util.Arrays;

class Job {
    int jobId;
    int deadline;
    int profit;

    Job(int j, int d, int p) {
        jobId = j;
        deadline = d;
        profit = p;
    }
}
// or two array with 3 element in the 1d array

public class JobSequencingProblem {
    static int[] findTotalJobWithinDeadlineAndMaxProfit(Job arr[]) {
        int cnt = 0;
        int profit = 0;

        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        int maxDeadline = Arrays.stream(arr).map(job -> job.deadline).max(Integer::compare).get();
        // max deadline once should be one before the less deadline
        System.out.println("MAx dL " + maxDeadline);
        int jobCompleted[] = new int[maxDeadline + 1];
        Arrays.fill(jobCompleted, -1);

        for (int i = 0; i < arr.length; i++) {
            int curProfit = arr[i].profit;

            for (int j = arr[i].deadline; j > 0; j--) {
                if (jobCompleted[j] == -1) {
                    profit += curProfit;
                    jobCompleted[j] = arr[i].deadline;
                    cnt++;
                    break;
                }
            }
        }
        return new int[] { cnt, profit };
    }

    public static void main(String[] args) {

        // [1, 4, 20] ,
        // [2, 1, 10] ,
        // [3, 1, 40] ,
        // [4, 1, 30]

        // Output : 2 60
        // Job[] arr = new Job[] { new Job(1, 4, 20), new Job(2, 1, 10),
        // new Job(3, 1, 40), new Job(4, 1, 30) };
        Job[] arr = new Job[] { new Job(1, 2, 100), new Job(2, 1, 19),
                new Job(3, 2, 27), new Job(4, 1, 25), new Job(5, 1, 15) };

        // [ [1, 2, 100] , [2, 1, 19] , [3, 2, 27] , [4, 1, 25] , [5, 1, 15] ]

        // Output : 2 127
        System.out.println(Arrays.toString(findTotalJobWithinDeadlineAndMaxProfit(arr)));
    }
}
