package streams.iterate.fibonacci;

import java.util.stream.Stream;

public class FibonacciSeries {

	public static void main(String[] args) {
		
		Stream.iterate(new int[] {0, 1}, arr-> new int[] {arr[1], arr[0]+arr[1]})
		.limit(10)
		.forEach(arr-> System.out.print(arr[0]+"\t"));
	}
}
