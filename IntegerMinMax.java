import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IntegerMinMax <Integer extends Comparable<Integer>>{
    // default constructor
    private Integer min;
    private Integer max;

    public IntegerMinMax() {
    }

    public IntegerMinMax(Integer item) {
        min = item;
        max = item;
    }

    // constructor with two values: min, then max
    // Sets both the min and the max

    /*
     * add method: resets the min or the max as needed.
     * If min and max are null, sets them to the added value
     */
    public void add(Integer item) {
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
    Integer getMin() {
        return min;
    }

    /*
     * getMax returns max
     */
    Integer getMax() {
        return max;
    }

    // Problem 4
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        IntegerMinMax m = new IntegerMinMax(5);
        Field[] fields = m.getClass().getDeclaredFields();
        for(int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            System.out.println(fields[i].get(m));
        }

        Method[] methods = m.getClass().getDeclaredMethods();
        methods[1].invoke(m, 7);
        System.out.println(m.max);
        System.out.println(methods[2].invoke(m));
        System.out.println(methods[3].invoke(m));
    }
}