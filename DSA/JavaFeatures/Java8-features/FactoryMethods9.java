import java.util.*;
import java.util.stream.*;

public class FactoryMethods9{
       public static void main(String[]a){
        List<Integer> list = List.of(1,2,3,4);
        Set<Integer> set = Set.of(1,2,3,4);
        Map<Integer,String> map = Map.of(1,"one",2,"two");
        
        System.out.println(Stream.of(1, 2, 3, 4, 5)
                        .reduce(0, (x, y) -> x + y));
        // String name = STR."""Lakshman"""; // java21
        // String formattedName = STR."Hello, \{name} !";//java21
        System.out.println(formattedName);
       }
    }