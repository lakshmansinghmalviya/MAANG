// https://leetcode.com/problems/lemonade-change//

package medium;

public class LemonadeChnage {
    public boolean lemonadeChange(int[] bills) {

        int five = 0, ten = 0;

        for (int i = 0; i < bills.length; i++) {

            int target = bills[i] - 5;

            while (target > 0) {
                if (target >= 10 && ten >= 1) {
                    target = target - 10;
                    ten--;
                }
                if (target >= 5) {
                    if (five <= 0)
                        return false;
                    target = target - 5;
                    five--;
                }
            }

            if (target != 0)
                return false;

            if (bills[i] == 5)
                five++;
            else if (bills[i] == 10)
                ten++;
        }
        return true;
    }

    public static void main(String[] args) {

    }

    // not a good solution as we have number of coins limited

    // public boolean lemonadeChange(int[] bills) {
    // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    // // 5,5,5,10,5,20,5,10,5,20
    // // 20,5,10,5,20

    // for (int i = 0; i < bills.length; i++) {
    // if (bills[i] >= 10) {
    // int target = bills[i] - 5;
    // List<Integer> list = new ArrayList<>();

    // while (!maxHeap.isEmpty() && target > 0) {
    // int element = maxHeap.poll();
    // if (element <= target) {
    // target -= element;
    // } else
    // list.add(element);
    // }
    // for (int elem : list)
    // maxHeap.offer(elem);
    // if (target != 0)
    // return false;
    // }
    // maxHeap.offer(bills[i]);
    // }
    // return true;
    // }
}
