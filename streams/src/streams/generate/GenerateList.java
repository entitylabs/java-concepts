package streams.generate;

import java.util.stream.Stream;

public class GenerateList {

	public static void main(String[] args) {
		Stream.generate(()-> 1)
		.limit(10)
		.forEach(System.out::println);
	}
}
