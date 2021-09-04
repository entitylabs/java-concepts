package streams.filters;

import java.util.stream.Collectors;

import streams.model.Dish;
import streams.model.lists.DishMenu;

public class DishFilter {

	public static void main(String[] args) {
		Long count=DishMenu.menu.parallelStream().filter(Dish::isVegetarian)
		.collect(Collectors.counting());
		System.out.println(count);
	}
}
