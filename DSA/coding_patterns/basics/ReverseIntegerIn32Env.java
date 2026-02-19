// https://leetcode.com/problems/reverse-integer/description/
package coding_patterns.basics;

public class ReverseIntegerIn32Env {
    // Long not allowed read the questions assume the enviroment not allowed to
    // store 64 bit integer
    public int reverse(int x) {
        boolean isNeg = false;

        if (x < 0) {
            x = x * -1;
            isNeg = true;
        }
        String strAbs = String.valueOf(Math.abs(x));
        StringBuilder sb = new StringBuilder(strAbs).reverse();

        try {
            x = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        return isNeg ? x * -1 : x;
    }

    public static void main(String[] args) {

    }
}
