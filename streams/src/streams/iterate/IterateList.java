package streams.iterate;

import java.util.stream.Stream;

public class IterateList {

	public static void main(String[] args) {
		
		Stream.iterate(0,n-> n+1)
		.limit(10)
		.forEach(System.out::println);
	}
}
