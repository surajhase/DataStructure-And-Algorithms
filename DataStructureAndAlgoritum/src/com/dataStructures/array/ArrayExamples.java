package com.dataStructures.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ArrayExamples {

	public static void main(String[] args) {
		ArrayExamples d = new ArrayExamples();
		String[] s1 = { "a", "b", "c", "d", "e" };
		String[] s2 = { "z", "y", "x", "a" };
		boolean is = d.isSimilarElementPresentUsingNestedFor(s1, s2);

		System.out.println(is);

		boolean is1 = d.isSimilarElementPresentUsingHashing(s1, s2);

		System.out.println(is1);
		System.out.println(d.reverseString("Suraj"));
		System.out.println(d.reverseString2("Suraj"));

		int[] i1 = { 1, 3, 5, 6 };
		int[] i2 = { 2, 4, 6, 8, 9 };
		int[] merged = d.mergeSortedArray(i1, i2);
		System.out.println(Arrays.toString(merged));
		int[] x = {2,7,11,15};
		System.out.println(Arrays.toString(d.twoSum(x,9)));
	}

	public int[] twoSum(int[] nums, int target) {
		int[] x = new int[2];
		Map set1 = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			set1.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			if (set1.containsKey(target - nums[i])) {
				x[0] = i;
				x[1] = (int) set1.get(target - nums[i]);
				break;
			}
		}
		return x;
	}

	private int[] mergeSortedArray(int[] i1, int[] i2) {
		int[] mergeArray = new int[i1.length + i2.length];
		int i = 0;
		int i1counter = 0;
		int i2counter = 0;
		while (i1counter < i1.length && i2counter < i2.length) {
			if (i1[i1counter] == i2[i2counter]) {
				mergeArray[i++] = i1[i1counter++];
				i2counter++;
			} else if (i1[i1counter] < i2[i2counter]) {
				mergeArray[i++] = i1[i1counter++];
			} else {
				mergeArray[i++] = i2[i2counter++];
			}
		}
		while (i1counter < i1.length) {
			mergeArray[i++] = i1[i1counter++];
		}
		while (i2counter < i2.length) {
			mergeArray[i++] = i2[i2counter++];
		}
		return mergeArray;
	}

	String reverseString(String s) {
		String reverseString = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			reverseString = reverseString + s.charAt(i);
		}
		return reverseString;
	}

	String reverseString2(String s) {
		char[] reverseString = s.toCharArray();
		int left, right = 0;
		right = reverseString.length - 1;

		for (left = 0; left < right; left++, right--) {
			// Swap values of left and right
			char temp = reverseString[left];
			reverseString[left] = reverseString[right];
			reverseString[right] = temp;
		}
		return new String(reverseString);
	}

	/// O(a*b)
	boolean isSimilarElementPresentUsingNestedFor(String[] s1, String[] s2) {
		for (String string : s1) {
			for (String string2 : s2) {
				if (string.equals(string2)) {
					return true;
				}
			}
		}
		return false;
	}

	// O(a+b)
	boolean isSimilarElementPresentUsingHashing(String[] s1, String[] s2) {
		HashSet<String> set1 = new HashSet<String>();
		for (String string : s1) {
			set1.add(string);
		}
		for (String string2 : s2) {
			if (set1.contains(string2)) {
				return true;
			}
		}
		return false;
	}

}
