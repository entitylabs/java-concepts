package streams.distinct;

import streams.model.lists.DishMenu;

public class DishDistinct {

	public static void main(String[] args) {
		
		
		// Distinct in stream needs no replay
		

		DishMenu.menu.stream().map(dish -> {
			System.out.println("Before distinct -->"+ dish);
			return dish;
		}).distinct()
		.forEach(System.out::println);
		
		
		System.out.println("\n\n//////////////Parallel///////////////////////\n\n");
		

		// Distinct does a replay in case of parallel stream
		
		DishMenu.menu.parallelStream().map(dish -> {
			System.out.println("Before distinct -->"+ dish);
			return dish;
		}).distinct()
		.forEach(System.out::println);
	}
}
