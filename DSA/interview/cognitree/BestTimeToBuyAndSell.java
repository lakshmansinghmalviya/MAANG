package interview.cognitree;

import java.util.ArrayList;
import java.util.List;

class TimePrice {
    String time;
    double price;

    TimePrice(String time, double price) {
        this.time = time;
        this.price = price;
    }
}

public class BestTimeToBuyAndSell {

    // Input: Array= [],
    // [(01:00, 7.5)],
    // [(02:00, 7.5), (03:30, 7.9), (04:00, 8.0), (05:30, 6.8), (10:00, 9.01)]
    // Given an array of values which represent prices of an item at different
    // instances of time, compute best buying and selling times (max profit). The
    // timestamps in the array are in chronological order.

    String[] findBestBuyAndSellTimes(List<TimePrice> list) {

        double max = 0;
        String buyTime = "";
        String sellTime = "";

        if (list.size() == 0)
            return new String[] { buyTime, sellTime, "" };

        if (list.size() == 1)
            return new String[] { list.get(0).time, list.get(0).time, max + "" };

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (max < (list.get(j).price - list.get(i).price)) {
                    max = (list.get(j).price - list.get(i).price);
                    buyTime = list.get(i).time;
                    sellTime = list.get(j).time;
                }
            }
        }
        return new String[] { buyTime, sellTime, max + "" };
    }

    // optimize in one loop - i stated from the ending we can keep the max and then
    // we can compare

    // Follow ups - can we do it from the front
    // now my answe keep the min , max and keep comparing

    // follow up any other way

    // optimize in one loop - i stated from the ending we can keep the max and then
    String[] findBestBuyAndSellTimesFromEnd(List<TimePrice> list) {
        int n = list.size();
        double max = 0, rightMax = 0;
        String buyTime = "", sellTime = "";

        if (list.size() == 0)
            return new String[] { buyTime, sellTime, "" };

        if (list.size() == 1)
            return new String[] { list.get(0).time, list.get(0).time, max + "" };

        for (int i = n - 1; i >= 0; i--) {

            if (rightMax < list.get(i).price) {
                sellTime = list.get(i).time;
                rightMax = list.get(i).price;
            }

            if (max < (rightMax - list.get(i).price)) {
                max = rightMax - list.get(i).price;
                buyTime = list.get(i).time;
            }
        }

        return new String[] { buyTime, sellTime, max + "" };
    }

    String[] findBestBuyAndSellTimesFromFront(List<TimePrice> list) {

        if (list.size() == 0)
            return new String[] { "", "", "" };

        int n = list.size();
        double max = 0, tillMax = 0, tillMin = list.get(0).price;
        String buyTime = "", sellTime = "";

        if (list.size() == 1)
            return new String[] { list.get(0).time, list.get(0).time, max + "" };

        for (int i = 0; i < n; i++) {

            if (tillMin > list.get(i).price) {
                buyTime = list.get(i).time;
                tillMin = list.get(i).price;
            }

            if (tillMax < list.get(i).price) {
                sellTime = list.get(i).time;
                tillMax = list.get(i).price;
            }

            if (max < (tillMax - tillMin)) {
                max = tillMax - tillMin;
            }
        }
        return new String[] { buyTime, sellTime, max + "" };
    }

    public static void main(String[] args) {
        List<TimePrice> list = new ArrayList<>();
        // [(02:00, 7.5), (03:30, 7.9), (04:00, 8.0), (05:30, 6.8), (10:00, 9.01)]
        list.add(new TimePrice("02:00", 7.5));
        list.add(new TimePrice("03:30", 7.9));
        list.add(new TimePrice("03:30", 7.9));
        list.add(new TimePrice("04:00", 8.0));
        list.add(new TimePrice("05:30", 6.8));
        list.add(new TimePrice("10:00", 9.01));
        // String[] arr = new BestTimeToBuyAndSell().findBestBuyAndSellTimes(list);
        // String[] arr = new
        // BestTimeToBuyAndSell().findBestBuyAndSellTimesFromEnd(list);
        String[] arr = new BestTimeToBuyAndSell().findBestBuyAndSellTimesFromFront(list);
        System.out.println("Buying time  " + arr[0] + "  Selling time " + arr[1] + "  max profit " + arr[2]);
    }
}