package chapter8;

/*
Cracking the Coding Interview - Chapter 8, #8.4: Write a method to return all subsets of a set.
*/

import java.util.HashSet;

public class PowerSet {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<HashSet<Integer>> powerSet = new HashSet<HashSet<Integer>>();
		for(int i = 1; i < 5; i++) set.add(i); //populate the set
		powerSet = getPowerSet(set);
		System.out.println("Set: " + set);
		System.out.println("# of Elements: " + set.size());
		System.out.println("----------------------------------------");
		System.out.println("Power Set: " + powerSet);
		System.out.println("# of Elements: " + powerSet.size());
	}
	
	@SuppressWarnings("unchecked")
	public static HashSet<HashSet<Integer>> getPowerSet(HashSet<Integer> set) {
		  HashSet<HashSet<Integer>> powerSet = new HashSet<HashSet<Integer>>();
		  HashSet<Integer> tempSet = new HashSet<Integer>();
		  powerSet.add(new HashSet<Integer>()); //adds the empty set -- every set will always have the empty set

		  if(set.size() == 1) {
			  powerSet.add(set);
			  return powerSet;
		  }

		  HashSet<Integer> newSetA = new HashSet<Integer>();
		  HashSet<Integer> newSetB = new HashSet<Integer>();
		  int counter = 0;

		  //divides the set into two sets - half and half recursion approach
		  for(int i : set) {
			  if(counter < (set.size() / 2)) newSetA.add(i);
			  else newSetB.add(i);
			  counter++;
		  }
		  
		  for(HashSet<Integer> i : getPowerSet(newSetA)) {
			  for(HashSet<Integer> j : getPowerSet(newSetB)) {
				  tempSet = (HashSet<Integer>) j.clone();
				  tempSet.addAll(i);
				  powerSet.add(tempSet);
			  }
		  }

		  return powerSet;
	}
}
