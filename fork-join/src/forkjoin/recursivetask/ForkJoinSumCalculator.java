package forkjoin.recursivetask;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;


//Task has to always extend Recursive task
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final long[] numbers;
	private final int start;
	private final int end;
	public static final long THRESHOLD = 100_000;

	public ForkJoinSumCalculator(long[] numbers) {

		this(numbers, 0, numbers.length);
	}

	private ForkJoinSumCalculator(long[] numbers, int start, int end) {
		super();
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {

		int length = end - start;

		if (length <= THRESHOLD) {
			return computeSequentially();
		}

		ForkJoinSumCalculator leftSubtask = new ForkJoinSumCalculator(numbers, start, start + length / 2);

		// Fork the left subtask 
		leftSubtask.fork();

		ForkJoinSumCalculator rightSubtask = new ForkJoinSumCalculator(numbers, start + length / 2, end);

		// call compute in place of fork so that this task can reuse the current thread
		// preventing one overhead
		Long rightResult = rightSubtask.compute();

		// join should be last statement after compute
		Long leftResult = leftSubtask.join();
		return leftResult + rightResult;
	}

	private Long computeSequentially() {

		long sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		return sum;
	}

	public static void main(String[] args) {

		long[] numbers = LongStream.rangeClosed(1, 1000_000).toArray();

		ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
		
		// invoke should be called from outside the recursive task
		Long result = new ForkJoinPool().invoke(task);
		System.out.println(result);
	}

}
