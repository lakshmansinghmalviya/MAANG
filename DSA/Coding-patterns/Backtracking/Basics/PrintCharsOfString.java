package Basics;

public class PrintCharsOfString {
    
     static void printRev(String s,int index){
        if(index==s.length()) return;
        printRev(s, index+1);
        System.out.println(s.charAt(index));
     }

     public static void main(String[] args) {
        System.out.println();
        System.out.println();
        printRev("abcd",0);
     }
}
