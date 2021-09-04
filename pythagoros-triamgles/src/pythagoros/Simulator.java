package pythagoros;

import java.util.stream.IntStream;

public class Simulator {

	public static void main(String[] args) {
		
		var pythagorosStreams=IntStream.rangeClosed(1, 100).boxed()
		.flatMap(a-> 
					IntStream.rangeClosed(1,100).filter(b-> Math.sqrt(a*a + b*b) %1==0)
					.mapToObj(b-> new int[] {a,b, (int)Math.sqrt(a*a + b*b)})
		
		);
		
		pythagorosStreams.limit(5).forEach(arr->System.out.println(arr[0]+ ","+ arr[1]+","+ arr[2]));
	}
}
