package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
  public static List<Double> compute1(List<Integer> input) {
	  List<Double> result = new ArrayList<Double>();
	  for (Integer itr : input) {
		  double temp = (itr*2) + 3;
		  int intResult = (int) Math.pow(temp, 5);
		  result.add((double) intResult);  
	  }
    return result;
  }

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {
	  List<String> result = new ArrayList<String>();
	  for (String itr : input) {
		  char first = itr.charAt(0);
		  char firstchar = Character.toUpperCase(first);
		  String newstring = itr.replace(first, firstchar);
		  result.add(newstring+newstring);
	  }
	  return result;
  }
  public static void main(String[] args) {
	  List<Integer> liste = Arrays.asList();
	  System.out.println("Original List: " + liste);
	  List<Double> finalliste = compute1(liste);
	  System.out.println("final List: " + finalliste);
	  
	  List<String> liste2 = Arrays.asList("sldkfj sdflkjs sdf");
	  System.out.println("Original List: " + liste2);
	  List<String> finalliste2 = compute2(liste2);
	  System.out.println("final List: " + finalliste2);
	  
  }

}
