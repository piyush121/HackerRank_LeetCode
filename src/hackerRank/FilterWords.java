package hackerRank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author Piyush Chaudhary
 *
 *         Question > Can't Disclose due to NDA.
 */
public class FilterWords {
	final HashSet<Character> ALLOWED_LETTERS = new HashSet<>();

	public void filterWords(String passage) {
		ALLOWED_LETTERS.add('r');
		ALLOWED_LETTERS.add('s');
		ALLOWED_LETTERS.add('t');
		ALLOWED_LETTERS.add('l');
		ALLOWED_LETTERS.add('n');
		ALLOWED_LETTERS.add('a');
		ALLOWED_LETTERS.add('e');
		ALLOWED_LETTERS.add('i');
		ALLOWED_LETTERS.add('o');
		ALLOWED_LETTERS.add('u');
		String[] words = passage.split("' |,|\\.|\\s");

		ArrayList<String> result = new ArrayList<>();
		HashSet<Character> temp;

		for (String word : words) {
			word = word.toLowerCase();
			temp = new HashSet<>();
			for (int i = 0; i < word.length(); i++) {
				if (!ALLOWED_LETTERS.contains(word.charAt(i))) // checking if
																// the letter is
																// allowed or
																// not.
					temp.add(word.charAt(i));
				if (temp.size() > 1) {
					break;
				}
				if (i == word.length() - 1)
					result.add(word);

			}
		}
		Collections.sort(result, new LengthComparator()); // O(nlogn)
		System.out.println(result);
		System.out.println("Most Common Word is: " + mostCommonWord(result));
	}

	private String mostCommonWord(ArrayList<String> words) {
		HashSet<String> hash = new HashSet<>();
		String common = "";
		int maxCount = 0;
		for (String word : words)
			hash.add(word);

		for (String word : hash) {
			int frequency = Collections.frequency(words, word);
			if (frequency > maxCount) {
				common = word;
				maxCount = frequency;
			}
		}
		return common;
	}

	public static void main(String[] args) {
		FilterWords obj = new FilterWords();
		obj.filterWords(
				"Two households, both alike in dignity,In fair Verona, where we lay our scene,From ancient grudge break to new mutiny,Where civil blood makes civil hands unclean.From forth the fatal loins of these two foes A pair of star-cross'd lovers take their life Whose misadventured piteous overthrows Do with their death bury their parents' strife. The fearful passage of their death-mark'd love,And the continuance of their parents' rage,Which, but their children's end, nought could remove,Is now the two hours' traffic of our stage;The which if you with patient ears attend,What here shall miss, our toil shall strive to mend.");
	}
}
