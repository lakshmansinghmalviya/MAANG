package Basics;

public class PrinteEleStartToEnd {
   static void printSToE(int arr[],int index){
      if(index==arr.length) return;
      System.out.println(arr[index]);
      printSToE(arr, index+1);
    }
    public static void main(String[] args) {
     printSToE(new int[]{1,2,3,4,5},0);
    }
}
