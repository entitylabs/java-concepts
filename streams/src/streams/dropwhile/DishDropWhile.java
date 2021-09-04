package streams.dropwhile;

import streams.model.lists.DishMenu;

public class DishDropWhile {

	public static void main(String[] args) {
		// behavior non deterministic in case of parallel streams

		var streamParallelRakeWhile = DishMenu.menu.parallelStream()
				.sorted((dish1, dish2) -> Double.valueOf(dish1.getCalories())

						.compareTo(Double.valueOf(dish2.getCalories())))
				.map(dish -> {
					System.out.println("Before dropWhile parallel-> " + dish.toString());
					return dish;
				}).parallel().dropWhile(dish -> dish.getCalories() < 400);

		streamParallelRakeWhile.forEach(System.out::println);
		
		System.out.println("\n\n///////////Parallel//////\n\n");

		var nonParallelElements = DishMenu.menu.stream().sorted((dish1, dish2) -> Double.valueOf(dish1.getCalories())

				.compareTo(Double.valueOf(dish2.getCalories()))).map(dish -> {
					System.out.println("Before dropWhile non parallel -> " + dish.toString());
					return dish;
				}).dropWhile(dish -> dish.getCalories() < 400);

		nonParallelElements.forEach(System.out::println);
	}
}
