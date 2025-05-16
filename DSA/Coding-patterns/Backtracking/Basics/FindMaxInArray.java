package Basics;

public class FindMaxInArray {
    static int findMaxInArray(int arr[], int max,int index){
        if(index>=arr.length) return max;
        if(max<arr[index]) max = arr[index];
        return findMaxInArray(arr, max, index+1);
    }
    public static void main(String[] args) {
        System.out.println();
          System.out.println(findMaxInArray(new int[]{1,2,3,45,2},Integer.MIN_VALUE,0));
    }
}
