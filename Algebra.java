// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
        if (x2 < 0) {
            for (int i = 0; i < -x2; i++) {
                x1--;
            }
        } else {
            for (int i = 0; i < x2; i++) {
                x1++;
            }
        }
        return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
        if (x2 < 0) {
            for (int i = 0; i < -x2; i++) {
                x1++;
            }
        } else {
            for (int i = 0; i < x2; i++) {
                x1--;
            }
        }
        return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
        int result = 0;
        boolean negative = false;

        // Handle negative multiplier
        if (x2 < 0) {
            x2 = minus(0, x2); // convert to positive
            negative = true;
        }

        for (int i = 0; i < x2; i++) {
            result = plus(result, x1);
        }

        if (negative) {
            result = minus(0, result);
        }

        return result;
}


	// Returns x^n (for n >= 0)
	public static int pow(int a, int b) {
        if (b < 0) return 0; // no real negative powers

        int result = 1;

        for (int i = 0; i < b; i++) {
            result = times(result, a);
        }

        return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int a, int b) {
        if (b == 0) return 0; // undefined, but avoid crash

        boolean negative = false;

        if (a < 0) {
            a = minus(0, a);
            negative = !negative;
        }
        if (b < 0) {
            b = minus(0, b);
            negative = !negative;
        }

        int count = 0;

        while (a >= b) {
            a = minus(a, b);
            count++;
        }

        if (negative) {
            count = minus(0, count);
        }

        return count;
	}

	// Returns x1 % x2
	public static int mod(int a, int b) {
        if (b == 0) return 0;

        boolean negative = false;

        if (a < 0) {
            a = minus(0, a);
            negative = true;
        }
        if (b < 0) {
            b = minus(0, b);
        }

        while (a >= b) {
            a = minus(a, b);
        }

        if (negative) {
            a = minus(0, a);
        }

        return a;
	}	

	public static int sqrt(int a) {
        if (a < 0) return 0;

        int i = 0;

        while (times(i, i) <= a) {
            i++;
        }

        return minus(i, 1);
    
	}	  	  
}