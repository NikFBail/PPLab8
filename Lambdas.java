import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.lang.StringBuilder;

public class Lambdas implements Function {

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
	/* Takes an arraylist of strings and a function
	 * and returns an arraylist of reversed strings
	 */
	public static ArrayList<String> reverse(ArrayList<String> orig, Function func) {
		ArrayList<String> res = new ArrayList<>(orig.size());
		return res;
	}

	@Override
	public Object apply(Object t) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'apply'");
	}
	

}
