package streams.takewhile;

import streams.model.lists.DishMenu;

public class DishTakeWhile {

	public static void main(String[] args) {

		// behavior non deterministic in case of parallel streams

		var streamParallelRakeWhile=DishMenu.menu.parallelStream()
				.sorted((dish1, dish2) -> Double.valueOf(dish1.getCalories())
						
						.compareTo(Double.valueOf(dish2.getCalories())))
				.map(dish -> {
					System.out.println("Before takewhile parallel-> " + dish.toString());
					return dish;
				})
				.parallel()
				.takeWhile(dish -> dish.getCalories() < 400);
		
		streamParallelRakeWhile.forEach(System.out::println);
		 System.out.println("\n\n///////////Parallel//////\n\n");
		 
		 
		 
		 var nonParallelElements=DishMenu.menu.stream()
					.sorted((dish1, dish2) -> Double.valueOf(dish1.getCalories())
							
							.compareTo(Double.valueOf(dish2.getCalories())))
					.map(dish -> {
						System.out.println("Before takewhile non parallel -> " + dish.toString());
						return dish;
					})
					.takeWhile(dish -> dish.getCalories() < 400);

		 nonParallelElements.forEach(System.out::println);
	}
}
