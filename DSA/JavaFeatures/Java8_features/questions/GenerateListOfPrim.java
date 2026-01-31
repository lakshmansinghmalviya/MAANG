import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.*;

public class GenerateListOfPrim {
    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1, 100).boxed().toList();
        System.out.println("List is like this " + list);

        List<Double> list2 = DoubleStream.of(1.0).boxed().toList();
        System.out.println("List is like this " + list2);

        List<Float> floatList = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> (float) i)
                .toList();
        System.out.println("Float List: " + floatList);

        List<Double> doubleList = IntStream.rangeClosed(1, 100)
                .mapToDouble(i -> (double) i)
                .boxed()
                .toList();
        System.out.println("Double List: " + doubleList);

        List<Character> listChar = IntStream.rangeClosed('A', 'Z').mapToObj((i)->(char)i).toList();
        System.out.println("List of the chars "+listChar);
    }
}