// https://leetcode.com/problems/online-stock-span/

package coding_patterns.stack.hard;

import java.util.Stack;

class Pair {
    int value;
    int index;

    Pair(int v, int i) {
        value = v;
        index = i;
    }
}

class StockSpanner {
    Stack<Pair> stack;
    int index = 0;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        while (!stack.isEmpty() && stack.peek().value <= price) {
            stack.pop();
        }
        int previousIndex = stack.isEmpty() ? -1 : stack.peek().index;
        stack.push(new Pair(price, index));
        int result = index - previousIndex;
        index++;
        return result;
    }
}

public class StockSpan {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        stockSpanner.next(100); // return 1
        stockSpanner.next(80); // return 1
        stockSpanner.next(60); // return 1
        stockSpanner.next(70); // return 2
        stockSpanner.next(60); // return 1
        stockSpanner.next(75); // return 4, because the last 4 prices (including today's price of 75) were less
                               // than or equal to today's price.
        stockSpanner.next(85); // return 6
    }
}
