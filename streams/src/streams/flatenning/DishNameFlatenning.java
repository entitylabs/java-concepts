package streams.flatenning;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import streams.model.lists.DishMenu;

public class DishNameFlatenning {

	public static void main(String[] args) {

		var words = DishMenu.menu.parallelStream().flatMap(dish -> Stream.of(dish.getName().split(""))).distinct()
				.collect(Collectors.toList());

		System.out.println(words);
	}
}
