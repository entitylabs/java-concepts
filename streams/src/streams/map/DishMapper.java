package streams.map;

import streams.model.Dish;
import streams.model.lists.DishMenu;

public class DishMapper {

	public static void main(String[] args) {
		var sum=DishMenu.menu.parallelStream().mapToDouble(Dish::getCalories)
		.sum();
		
		System.out.println(sum);
	}
}
