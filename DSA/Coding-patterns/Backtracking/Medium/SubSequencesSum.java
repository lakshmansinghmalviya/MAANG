package Medium;

import java.util.*;
public class SubSequencesSum {
     
    public static void printSubSequenceSum(int arr[], int index, int sum, List<Integer> list ){
            if(index>=arr.length){
                list.add(sum);
                return;
            }
            printSubSequenceSum(arr,index+1,sum+arr[index],list);
            printSubSequenceSum(arr,index+1,sum,list);
    }
    
    public static void main(String[] args) {
       int arr[]  = new int[]{1,2,3};
       List<Integer> list = new ArrayList<>();
      printSubSequenceSum(arr,0,0,list);
      System.out.println(list);
    }
}