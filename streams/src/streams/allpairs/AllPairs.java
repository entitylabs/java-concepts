package streams.allpairs;

import java.util.Arrays;

public class AllPairs {

	public static void main(String[] args) {

		var num1 = Arrays.asList(1, 2, 3);
		var num2 = Arrays.asList(4, 5, 6);

		num1.stream().flatMap(n1 -> num2.stream().map(n2 -> new int[] { n1, n2 }))
				.forEach(arr -> System.out.println("Pair: [" + arr[0] + "," + arr[1] + "]"));

		num1.stream().flatMap(n1 -> num2.stream().map(n2 -> new int[] { n1, n2 })).filter(arr -> arr[0] + arr[1] > 8)
				.forEach(arr -> System.out.println("Sum greater than 8 [" + arr[0] + "," + arr[1] + "]"));

	}
}
