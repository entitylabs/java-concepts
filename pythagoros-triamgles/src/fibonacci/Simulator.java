package fibonacci;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Simulator {

	public static void main(String[] args) {
		
		Stream.iterate(new int[]{0,1}, arr-> new int[]{arr[1], arr[0]+arr[1]})
		.limit(15)
		.map(arr-> arr[0])
		.forEach(num-> System.out.println(num));
		
//		List.of(1,2,3).stream().collect(Collectors.gr);
		
		
		BiFunction<Integer, Integer, Integer> sum=(a,b)-> a+b;
		
		 var composedFunction=sum.andThen(res-> res*2);
		System.out.println(composedFunction.apply(1,2));
	}
}
