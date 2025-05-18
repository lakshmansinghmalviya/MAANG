package Medium;
import java.util.*;

public class PrintSubSequenceOfTarget {
    // 1 2 3 0 - 4
    //pending....

    static List<Integer> findTargetSequence(int[] arr, int target, int index,
            ArrayList<Integer> list) {
                if(target<0) return new ArrayList<>();
                if(target==0) return list;
                list.add(arr[index]);

                List<Integer> temp =  findTargetSequence(arr, target-arr[index], index+1, list);
                list.remove(index);
                List<Integer> temp2 = findTargetSequence(arr, target-arr[index], index+1, list);
                return temp.size()!=0?temp:temp2;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        int t = 4;
        System.out.println(findTargetSequence(arr, t, 0, new ArrayList<>()));
    }
}
