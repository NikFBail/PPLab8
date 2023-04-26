
public class MinMax<T extends Comparable<T>> {
	// the class records the minimum and the maximum 
	// of the added elements
	private T min;
	private T max;
	
	public MinMax() {
		
	}
	
	// constructor with one value; sets the min and the max to the value
	public MinMax(T item) {
		min = item;
		max = item;
	}
	
	// constructor with two values: min, then max
	// Sets both the min and the max
	
	/*
	 * add method: resets the min or the max as needed.
	 * If min and max are null, sets them to the added value
	 */
	public void add(T item) {
		if (min == null) {
			min = item;
			max = item;
		} else if (item.compareTo(min) < 0) {
			min = item;
		} else if (item.compareTo(max) > 0) {
			max = item;
		}
	}
	
	/*
	 * getMin returns min 
	 */
	T getMin() {
		return min;
	}
	
	/*
	 * getMax returns max
	 */
	T getMax() {
		return max;
	}
	
	/*
	 * inRange: takes an item, returns true if min <= item <= max, otherwise
	 * returns false. 
	 * Throws a MinMaxNotInitializedException if min=max=null
	 */

	boolean inRange(T item) {
		if (item.compareTo(min) < 0 && item.compareTo(max) > 0) return true;
		else return false; 
	}
	


}
