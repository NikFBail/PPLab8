import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;


public class Lambdas {
	public static void main(String [] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
		ArrayList<String> strings = new ArrayList<>();
		for (int i = 0; i < 10; ++i){
			numbers.add(i);
			strings.add(new String(Integer.toBinaryString(i)));
		}
		
		// passing an anonymous function to countElements:
		int countEvens = countElements(numbers, (n) -> (n % 2 == 0));
		System.out.println(countEvens);
		int countOdds = countElements(numbers, (n) -> (n % 2 != 0));
		System.out.println(countOdds);
		int countShortStrings = countElements(strings, (s) -> (s.length() < 4));
		System.out.println(countShortStrings);
		Predicate<String> notSmall = (s) -> (s.length() >= 2);
		Predicate<String> notLarge = (s) -> (s.length() <= 4);
		int countMediumStrings = countElements(strings, notSmall.and(notLarge));
		System.out.println(countMediumStrings);
		
		System.out.println("Problem 2:");
		System.out.println(strings);
		ArrayList<String> reversed = ourMap(strings, reverString);
		System.out.println(reversed);

		ArrayList<String> stuffs = new ArrayList<>();
		stuffs.add("Donut");
		stuffs.add("Rowboat");
		stuffs.add("George Washington");
		stuffs.add("Banananananana");
		System.out.println(stuffs);

		ArrayList<String> reversedAndUpped = ourMap(stuffs, reverseUpper);
		System.out.println(reversedAndUpped);

		ArrayList<Integer> lengths = new ArrayList<>();
		for(int i = 0; i < stuffs.size(); i++) {
			Integer length = getLengths.apply(stuffs.get(i));
			lengths.add(length);
		}
		System.out.println(lengths);

		ArrayList<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Tiger" , 156));
		animals.add(new Animal("Elephant", 723));
		animals.add(new Animal("Snake", 24));

		ArrayList<String> names = new ArrayList<>();
		for(int i = 0; i < animals.size(); i++) {
			String name = getName.apply(animals.get(i));
			names.add(name);
		}
		System.out.println(names);

		System.out.println("Problem 3:");

		ArrayList<String> odds = new ArrayList<>();
		for(int i = 0; i < stuffs.size(); i++) {
			int size = oddLength.applyAsInt(stuffs.get(i));
			if(!(size % 2 == 0)) {
				odds.add(stuffs.get(i));
			}
		}
		System.out.println(odds);

		ArrayList<String> manyAs = new ArrayList<>();
		for(int i = 0; i < stuffs.size(); i++) {
			int count = countingAs.applyAsInt(stuffs.get(i));
			if(count >= 2) {
				manyAs.add(stuffs.get(i));
			}
		}
		System.out.println(manyAs);

		ArrayList<String> notManyAs = new ArrayList<>();
		for(int i = 0; i < stuffs.size(); i++) {
			int count = countingAs.applyAsInt(stuffs.get(i));
			if(count <= 2) {
				notManyAs.add(stuffs.get(i));
			}
		}
		System.out.println(notManyAs);

		ArrayList<Animal> swolAnimol = new ArrayList<>();
		for(int i = 0; i < animals.size(); i++) {
			int weight = lightWeight.applyAsInt(animals.get(i));
			if(weight > 100) {
				swolAnimol.add(animals.get(i));
			}
		}
		System.out.println(swolAnimol);

	}
	
	public static <T> int countElements(ArrayList<T> theList, Predicate<T> cond) {
		int count = 0;
		for (T element: theList) {
			if (cond.test(element)) {
				count++;
			}
		}
		return count;
	}

	// Problem 2
	public static ArrayList<String> ourMap(ArrayList<String> strings, Function func) {
		ArrayList<String> res = new ArrayList<>();
		for(int i = 0; i < strings.size(); i++) {
			String s = (String) func.apply(strings.get(i));
			res.add(s);
		}
		return res;
	}

	/* 1. Takes an arraylist of strings and a function
	 * and returns an arraylist of reversed strings
	 */
	static Function<String, String> reverString = s -> {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	};
	
	/* 2. Use function composition (using either compose or andThen method of a function)
	 * to create a function that reverses and uppercases the strings.
	 * Then use it on the given arraylist of strings
	 */
	static Function reverseUpper = reverString.andThen(String::toUpperCase);

	/* 3. Pass an arrayList of strings and a function that creates an arrayList
	 * of their lengths
	 */
	static Function<String, Integer> getLengths = s -> s.length();

	/* 4. Pass an arrayList of Animals and return an arrayList of their names */
	static Function<Animal, String> getName = s -> s.getName();

	// Problem 3


	/* 1. Given an arrayList of strings, return an ArrayList of all its strings of odd length */
	static ToIntFunction<String> oddLength = s -> s.length();

	/* 2. Given an ArrayList of strings, return an ArrayList of all its strings that have more
	 * than 2 letters 'a'
	 */
	static ToIntFunction<String> countingAs = s -> {
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'a') {
				count++;
			}
		}
		return count;
	};

	/* 3. Given an ArrayList of strings, return an ArrayList of all its strings that have fewer
	 * than 2 letters 'a'
	 */

	 // Same code as part 2

	/* 4. Given an ArrayList of animals, return an ArrayList only of animals that weigh more than 100 */
	static ToIntFunction<Animal> lightWeight = s -> (int) s.getWeight();
}
