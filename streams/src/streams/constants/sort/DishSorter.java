package streams.constants.sort;

import streams.model.lists.DishMenu;

public class DishSorter {

	public static void main(String[] args) {
		
		/** Parallel stream does not guarantee ordering
		
		Stream is collected by sort to operate sort and then replayed
		
		This is inefficient
		**/

		DishMenu.menu.stream().map(dish -> {
			System.out.println("Before sort-> " + dish.toString());
			return dish;
		}).sorted((dish1, dish2) -> dish1.getName().compareTo(dish2.getName())).map(dish -> {
			System.out.println("After sort-> " + dish.toString());
			return dish;
		}).forEach(System.out::println);

	}
}
