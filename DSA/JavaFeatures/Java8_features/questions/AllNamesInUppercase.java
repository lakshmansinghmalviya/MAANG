import java.util.*;
import java.util.stream.Collectors;

public class AllNamesInUppercase {
    public static void main(String[] args) { 
        List<String> strList = Arrays.asList("Okay", "hI","HelLO");
        List<String> list = strList.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(list); 
       }
}
