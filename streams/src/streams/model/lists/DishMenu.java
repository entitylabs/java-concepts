package streams.model.lists;

import java.util.Arrays;
import java.util.List;

import streams.constants.DishType;
import streams.model.Dish;

public class DishMenu {

	public static final List<Dish> menu = Arrays.asList(

			new Dish("Pork", false, 800, DishType.MEAT), new Dish("Beef", false, 700, DishType.MEAT),
			new Dish("Chicken", false, 400, DishType.MEAT), new Dish("French fries", true, 500, DishType.OTHER),
			new Dish("Rice", true, 200, DishType.MEAT), new Dish("Season fruit", true, 300, DishType.MEAT),
			new Dish("Pasta", true, 450, DishType.MEAT), new Dish("Pizza", true, 650, DishType.MEAT),
			new Dish("Prawns", false, 450, DishType.MEAT), new Dish("Salmon", false, 250, DishType.MEAT),
			new Dish("Salmon", false, 250, DishType.MEAT), new Dish("Poisson", false, 440, DishType.MEAT),
			new Dish("Tofu", true, 120, DishType.MEAT));
}
