package coding_patterns.dynamic_programming.basic;

public class SellAndBuyStocks {

    // if from left side then keep consider/reassgining minimum one
    public int maxProfit(int[] prices) {
        int min = prices[0], n = prices.length;
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            if (min > prices[i])
                min = prices[i];
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }

    // from right side if we solve

    // public int maxProfit(int[] prices) {
    // int max = 0;
    // int n = prices.length;
    // int rightMax = prices[n - 1];

    // for (int i = n - 1; i >= 0; i--) {
    // if (rightMax < prices[i])
    // rightMax = prices[i];

    // if (max < rightMax - prices[i])
    // max = rightMax - prices[i];
    // }
    // return max;
    // }

    // TLE
    // public int maxProfit(int[] prices) {
    // int max = 0;
    // for(int i=0; i<prices.length; i++){
    // for(int j= i+1; j<prices.length; j++){
    // if(max< prices[j]-prices[i])
    // max = prices[j]-prices[i];
    // }
    // }
    // return max;
    // }

    public static void main(String[] args) {

    }
}
