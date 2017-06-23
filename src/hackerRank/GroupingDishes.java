/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * You have a list of dishes. Each dish is associated with a list of ingredients used to prepare it. You want to to group the dishes by ingredients, so that for each ingredient you'll be able to find all the dishes that contain it (if there are at least 2 such dishes).

Return an array where each element is a list with the first element equal to the name of the ingredient and all of the other elements equal to the names of dishes that contain this ingredient. The dishes inside each list should be sorted lexicographically. The result array should be sorted lexicographically by the names of the ingredients in its elements.

Example

For
  dishes = [["Salad", "Tomato", "Cucumber", "Salad", "Sauce"],
            ["Pizza", "Tomato", "Sausage", "Sauce", "Dough"],
            ["Quesadilla", "Chicken", "Cheese", "Sauce"],
            ["Sandwich", "Salad", "Bread", "Tomato", "Cheese"]]
the output should be
  groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
                            ["Salad", "Salad", "Sandwich"],
                            ["Sauce", "Pizza", "Quesadilla", "Salad"],
                            ["Tomato", "Pizza", "Salad", "Sandwich"]]
For
  dishes = [["Pasta", "Tomato Sauce", "Onions", "Garlic"],
            ["Chicken Curry", "Chicken", "Curry Sauce"],
            ["Fried Rice", "Rice", "Onions", "Nuts"],
            ["Salad", "Spinach", "Nuts"],
            ["Sandwich", "Cheese", "Bread"],
            ["Quesadilla", "Chicken", "Cheese"]]
the output should be
  groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
                            ["Chicken", "Chicken Curry", "Quesadilla"],
                            ["Nuts", "Fried Rice", "Salad"],
                            ["Onions", "Fried Rice", "Pasta"]]
 *
 */
public class GroupingDishes {
	List<List<String>> groupingDishes(String[][] dishes) {
		Map<String, List<String>> map = new TreeMap<>();
		for (String[] arr : dishes) {
			String dish = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (!map.containsKey(arr[i]))
					map.put(arr[i], new ArrayList<>());
				map.get(arr[i]).add(dish);
			}
		}

		List<List<String>> res = new ArrayList<>();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			if (entry.getValue().size() > 1) {
				Collections.sort(entry.getValue());
				res.add(new ArrayList<>());
				res.get(res.size() - 1).add(entry.getKey());
				res.get(res.size() - 1).addAll(entry.getValue());
			}
		}
		return res;
	}

}
