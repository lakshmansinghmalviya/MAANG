import java.util.*;
import java.util.stream.*;

public class SumOfNumbersTest{
       public static void main(String[]a){
        System.out.println("Hello Java 8 stream");
        List<Integer> list = List.of(1,2,3,4,5);
        int sum = list.stream().reduce(0,(x,y)->{
            System.out.println(x+" "+y);//y is 1
            return x+y;
            });
        System.out.println(sum);

        sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
       
       sum = list.stream().mapToInt(x->x).sum();
        System.out.println(sum);

       }
}