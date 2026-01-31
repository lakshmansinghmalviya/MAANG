import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequency {
	public static void main(String[] args) {
		String str = "HelloHowAreYOu";

		Map<Character, Long> map = str.chars().mapToObj((c) -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Map<Character, Long> map2 = str.chars().mapToObj((c) -> (char) c)
				.collect(Collectors.groupingBy(x -> x, Collectors.counting()));

		System.out.println(map);
		System.out.println(map2);
	}
}
