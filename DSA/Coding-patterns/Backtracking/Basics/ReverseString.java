package Basics;

public class ReverseString {

    public static String rev(String s, int index) {
        if (index == s.length())
            return "";
        // rev(s, rev, index + 1);
        String rev = rev(s, index + 1);
        rev = rev + s.charAt(index);
        return rev;
    }

    public static void main(String[] args) { 
        System.out.println();
        System.out.println(rev("abas", 0)); 
    }
}
