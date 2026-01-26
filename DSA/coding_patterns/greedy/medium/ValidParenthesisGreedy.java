// https://leetcode.com/problems/valid-parenthesis-string/description/.

package medium;

public class ValidParenthesisGreedy {

    public boolean checkValidString(String s) {
        return isValidParenthesis(s, 0, 0);
    }

    // Optimal is to use DP or Use the one loop solution is this but im not able to undetand for now
    // this solution has some issues

    // public boolean checkValidString(String s) {
    // int min = 0;
    // int max = 0;

    // for (int i = 0; i < s.length(); i++) {

    // char ch = s.charAt(i);

    // if (ch == '(') {
    // min = min + 1;
    // max = max + 1;
    // } else if (ch == ')') {
    // min = min - 1;
    // max = max - 1;
    // if (i == s.length() - 1 && max < 0)
    // return false;
    // } else {
    // min = min - 1;
    // max = max + 1;
    // }

    // if (min < 0) {
    // min = 0;
    // }
    // if (max < 0) {
    // max = 0;
    // }
    // }
    // return (min == 0);
    // }

    public static void main(String[] args) {

    }

    // better/brute force approach
    static boolean isValidParenthesis(String s, int index, int cnt) {
        if (index == s.length()) {
            if (cnt == 0)
                return true;
            else
                return false;
        }
        if (cnt < 0)
            return false;

        if (s.charAt(index) == '(' && isValidParenthesis(s, index + 1, cnt + 1) == true)
            return true;

        else if (s.charAt(index) == ')' && isValidParenthesis(s, index + 1, cnt - 1) == true)
            return true;

        else if (s.charAt(index) == '*' && (isValidParenthesis(s, index + 1, cnt - 1) == true
                || isValidParenthesis(s, index + 1, cnt) == true || isValidParenthesis(s, index + 1, cnt + 1) == true))
            return true;
        else
            return false;
    }
}
