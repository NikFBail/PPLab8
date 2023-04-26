import java.util.ArrayList;

public class Examples {

	// Static: one per class; non-static: one per instance (needs an instance)
	public static void main(String[] args) {
		int n = 2;
		int m = 4;
		
		// passed by value
		int k = sum(n,m);
		System.out.println("n = " + n + " m = " + m + " k = " + k);
		
		
		A a1 = new A(2);
		A a2 = new A(4);
		// passed by reference
		A a3 = a1.sum(a2);
		
		System.out.println("Is a1 an object? " + (a1 instanceof Object));
		System.out.println("Is a1 of type A? " + (a1 instanceof A));
		System.out.println("Class of a1 = " + a1.getClass());
		
		System.out.println("a1: " + a1 + ", a2: " + a2 + ", a3: " + a3);
		
		
		// Typecasting vs typechecking
		B b1 = new B(5,7);
		System.out.println(b1);
		A a4 = b1; // no typecasting needed: every B is an A
		
		// Which of these are allowed? What would they do if they run? 
		System.out.println("print here " + a4); // what should happen?
		B b2 = b1.product(b1);
		System.out.println(b2);
		A a5 = a4.sum(b1);
		System.out.println(a5);
		//B b3 = (B) a4.sum(b1); // compiles because some As are Bs, but it fails at runtime because this A (returned from sum) is not B
		//System.out.println(b3);
		B b4 = ((B) a4).product(b1); // what happens? 
		System.out.println(b4);
		
		
		
		// primitive types vs their wrappers
		// Boxing (putting in a "box"):
		Integer n1 = n;
		System.out.println(n1);
		System.out.println("Is n1 an object? " + (n1 instanceof Object));
		System.out.println("Is n1 an Integer? " + (n1 instanceof Integer));
		System.out.println("Class of n1 = " + n1.getClass());
		
		// Boxed types (Integer, Double, etc.) are immutable - no methods to change them  
		
		// You can't put primitive types into a Collection
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(2); // implicit boxing
		arr.add(new Integer(6)); // explicit boxing (now deprecated)
		System.out.println(arr.get(0));
		System.out.println(arr.get(0).getClass());
		int k1 = (int) arr.get(0);

		// Type parameters of collections can be only Object types. 
		// Boxing and unboxing for primitive types is implicit 
		
		// Some generic (parametric) classes require their elements 
		// to be Comparable.
		
		MinMax<Integer> minMaxInt = new MinMax<>();
		minMaxInt.add(2);
		minMaxInt.add(4);
		minMaxInt.add(3);
		System.out.println(minMaxInt.getMin());
		System.out.println(minMaxInt.getMax());
	System.out.println(minMaxInt.inRange(3));

		// MinMax<String> minMaxStr = new MinMax<>();
		// minMaxStr.add("22");
		// minMaxStr.add("4");
		// minMaxStr.add("3");
		// System.out.println(minMaxStr.getMin());
		// System.out.println(minMaxStr.getMax());
		
	}
	
	public static int sum(int x, int y) {
		// What happens if we change x or y in this method? 
		int s = x + y;
		x++;
		return s;
	}
	
	// must be static (used in static main). 
	// Generally making classes and methods static may save memory.
	// If it doesn't need to be attached to an instance, make it static
	private static class A {
		protected int a;
		
		public A(int a) {
			this.a = a;
		}
		
		public A sum(A other) {
			// What happens if we change other in this method? 
			int s = this.a + other.a;
			//other.a = 7;
			return new A(s);
		}
		
		public String toString() {
			return "A: a = " + a;
		}
	}
	
	private static class B extends A {
		private int b;
		
		public B(int a, int b) {
			super(a);
			this.b = b;
		}
		
		public B product(B other) {
			return new B(this.a, this.b * other.b);
		}
		
		public String toString() {
			return "B: a = " + a + " b = " + b;
		}
	}

}
