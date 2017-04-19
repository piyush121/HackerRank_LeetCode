/**
 * @author Piyush Chaudhary
 */
package JavaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * @author Piyush Chaudhary
 *
 */
public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> stream = list.stream();
		// System.out.println(stream.map(i -> i * 2.0).reduce(0.0,(a, b) -> a +
		// b));
		System.out.println(stream.filter(i -> i % 2 == 0).findFirst().orElse(0));
		Optional<Integer> opt1 = Optional.ofNullable(null);
		Optional<Integer> opt2 = Optional.ofNullable(20);
		// System.out.println(opt1.get() + opt2.get());
		opt1.ifPresent(i -> System.out.println(i * 5));
	}

}
