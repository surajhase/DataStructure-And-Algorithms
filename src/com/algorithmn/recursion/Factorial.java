package com.algorithmn.recursion;

public class Factorial {
	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		System.out.println(factorial.getFactorialUsingIteration(5));
		System.out.println(factorial.getFactorialUsingRecursion(5));
	}

//	O(n)
	private long getFactorialUsingRecursion(int number) {
		long result = number;
		if (number > 1) {
			result = number * getFactorialUsingRecursion(--number);
		}
		return result;
	}

//	O(n)
	private long getFactorialUsingIteration(int number) {
//		long result = 1;
//		for (int i = 2; i <= number; i++) {
//			result = result * i;
//		}
		long result = 5;
		for (int i = number-1; i >= 2; i--) {
			result = result * i;
		}
		return result;
	}
}
