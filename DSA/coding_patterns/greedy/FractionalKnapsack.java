import java.util.Arrays;

public class FractionalKnapsack {

    public static double fractionalKnapsack(int[] val, int[] wt, long cap) {
        double arr[][] = new double[val.length][3];

        for (int i = 0; i < val.length; i++) {
            arr[i][0] = val[i];
            arr[i][1] = wt[i];
            arr[i][2] = (double) (arr[i][0] / arr[i][1]);
        }

        double profit = 0;
        Arrays.sort(arr, (a, b) -> Double.compare(b[2], a[2]));

        for (int i = 0; i < val.length; i++) {
            double value = arr[i][0];
            double weight = arr[i][1];
            double ratio = arr[i][2];

            if (cap - weight < 0) {
                // fraction part
                profit += (cap * ratio);
                break;
            } else {
                cap -= weight;
                profit += value;
            }
        }

        return Double.parseDouble(String.format("%.6f", profit));
    }

    public static void main(String[] args) {
        // int[] val = { 60, 100, 120 };
        int[] val = { 500, 1200, 800, 300 };
        // int[] wt = { 10, 20, 30 };
        int[] wt = { 30, 100, 50, 10 };
        long cap = 60;
        System.out.println(fractionalKnapsack(val, wt, cap));
    }
}