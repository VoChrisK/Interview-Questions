package etc;

import java.util.*;

/*
 * Given a string of digits i.e "14982". Find all substrings of digits, 
 * like "149" and "1". Calculate the product between the digits 
 * (so for "149" it's 36). Return whether all such products of 
 * substrings is unique or not.  
*/

public class SubStringProduct {

	public static void main(String[] args) {
		String digitsInString = "25364";
		int[] digitsInArray = new int[10];
		Random random = new Random();
		
		for(int i = 0; i < digitsInArray.length; i++) {
			digitsInArray[i] = random.nextInt(9);
			//System.out.print(digitsInArray[i]);
		}
		
		System.out.println(digitsInString);
		System.out.println("\n" + isUnique(digitsInString));
	}
	
	//alt method #1
	public static boolean isUnique(String digits) {
		int parsed = 0;
		int multiply = 0;
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < digits.length(); i++) {
			parsed = Integer.parseInt(digits.substring(i, i+1));
			
			for(int j = 0; j < list.size(); j++) {
				multiply = list.get(j) * parsed;
				if(set.contains(multiply)) return false;
				list.set(j, multiply);
				set.add(multiply);
			}
		
			list.add(parsed);
			set.add(parsed);
		}
		
		return true;
	}
	
	//atl method #2
	public static boolean isUnique(int[] digits) {
		int multiply = 0;
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < digits.length; i++) {
			for(int j = 0; j < list.size(); j++) {
				multiply = list.get(j) * digits[i];
				if(set.contains(multiply)) return false;
				list.set(j, multiply);
				set.add(multiply);
			}
		
			list.add(digits[i]);
			set.add(digits[i]);
		}
		
		return true;
	}

	/*		EXAMPLE:
	 * 		14982
	 *		1
	 *		14, 4
	 *		149, 49, 9
	 *		1498, 498, 98, 8
	 *		14982, 4982, 982, 82, 2 
	 *		This will return false because 1*4*9 = 36 and 4*9 = 36 so the products are not unique
	 */

}
