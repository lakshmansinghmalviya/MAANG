import java.util.*;
import java.util.stream.Collectors;

public class FindSecondHighestNum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 4, 6, 5);
        List<Integer> sortedList = list.stream().sorted((a, b) -> b - a).skip(1).collect(Collectors.toList());

        sortedList.forEach(System.out::println);
        System.out.println(sortedList.get(0));
    }
}
