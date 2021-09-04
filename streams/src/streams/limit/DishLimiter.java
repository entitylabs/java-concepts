package streams.limit;

import streams.model.Dish;
import streams.model.lists.DishMenu;

public class DishLimiter {

	public static void main(String[] args) {
		var sum = DishMenu.menu.parallelStream().limit(3).mapToDouble(Dish::getCalories).sum();

		System.out.println(sum);
	}
}
