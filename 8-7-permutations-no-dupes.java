import java.util.LinkedList;
import java.util.List;

/*
Cracking the Coding Interview - Chapter 8, #8.7: Write a method to compute all permutations of a string of unique characters.
*/

public class PermutationsNoDups {
	public static void main(String[] args) {
		String s = "abc";
		List<String> list = permutationsNoDups(s);
		System.out.println("String: " + s);
		System.out.println("List: " + list);
		System.out.println("# of Elements: " + s.length() + "! = " +  list.size());
	}
	
	public static List<String> permutationsNoDups(String s) {
		List<String> list = new LinkedList<String>();
		StringBuilder build = new StringBuilder();
		String sub; int size;
		list.add(s.substring(0, 1));
		
		for(int i = 1; i < s.length(); i++) {
			sub = s.substring(i, i+1);
			size = list.size();
			for(int j = 0; j < size; j++) {
				for(int k = 0; k < list.get(0).length() + 1; k++) {
					build.setLength(0);
					if(k == 0) {
						build.append(sub);
						build.append(list.get(0));
					}
					else if(k == list.get(0).length()) {
						build.append(list.get(0));
						build.append(sub);
					}
					else {
						build.append(list.get(0).substring(0, k));
						build.append(sub);
						build.append(list.get(0).substring(k));
					}
					list.add(build.toString());
				}
				list.remove(0);
			}
		}
		
		return list;
	}
}
