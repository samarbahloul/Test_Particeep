package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
  public static Option<Integer> power(Integer i, Integer n) {
	  Option<Integer> temp= Option.of(1);
	  int tmp = temp.get();
	  while (n != 0) {
		 tmp = tmp * i ;
		  n--;
	  }
    return Option.of(tmp);
  }
  public static void main(String[] args) {
	  Option<Integer> origin = power(2,9);
	  System.out.println(origin);
	  
	  
  }
}
