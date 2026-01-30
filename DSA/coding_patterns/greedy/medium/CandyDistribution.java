package medium;

public class CandyDistribution {

    // using the slove visualization
    // see the up and down and dry run the difference finding

    public int candy(int[] ratings) {

        // get the left and right max of the both and sum that we will get the min cost
        // to distribute
        int n = ratings.length;
        int sum = 1;
        int i = 1;

        while (i < n) {
            // Equals case handing
            while (i < n && ratings[i - 1] == ratings[i]) {
                sum += 1;
                i++;
                continue;
            }

            // handle upper slove
            int peek = 1;
            while (i < n && ratings[i - 1] < ratings[i]) {
                peek++;
                sum = sum + peek;
                i++;
            }

            int down = 1;

            while (i < n && ratings[i - 1] > ratings[i]) {
                sum = sum + down;
                down++;
                i++;
            }

            if (down > peek) {
                sum = sum + (down - peek);
            }
        }
        return sum;
        // return sum+1;
    }

    public static void main(String[] args) {

    }

    // Brute force
    public int candy(int[] ratings) {

        // get the left and right max of the both and sum that we will get the min cost
        // to distribute
        int n = ratings.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = 1;
        right[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) {
                left[i] = left[i - 1] + 1; // very imp here to i-1
            } else
                left[i] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1; // very imp here to i+1
            } else
                right[i] = 1;
        }

        int sum = 0;
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));

        // we can remove this loop can do calculation in the right array iteration
        // improving 3N - 2N and S - 0(2N)
        for (int i = 0; i < n; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}