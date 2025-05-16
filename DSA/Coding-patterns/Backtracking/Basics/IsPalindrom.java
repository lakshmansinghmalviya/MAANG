package Basics;

public class IsPalindrom {
    static boolean isPalindrom(String s, int index) {
        if (index >= s.length() / 2)
            return true;
        if (s.charAt(index) != s.charAt(s.length() - index - 1))
            return false;
        return isPalindrom(s, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrom("aabaa", 0));
    }
}
