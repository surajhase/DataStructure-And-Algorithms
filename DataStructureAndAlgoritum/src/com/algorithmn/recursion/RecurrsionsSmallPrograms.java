package com.algorithmn.recursion;

public class RecurrsionsSmallPrograms {

	public static void main(String[] args) {
		RecurrsionsSmallPrograms recurrsionsSmallPrograms = new RecurrsionsSmallPrograms();
		System.out.println(recurrsionsSmallPrograms.getFactorialUsingIteration(5));
		System.out.println(recurrsionsSmallPrograms.getFactorialUsingRecursion(5));
		System.out.println(recurrsionsSmallPrograms.getFabonacciUsingIteration(11));
		System.out.println(recurrsionsSmallPrograms.getFabonacciUsingRecursion(8));
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
		long result = 1;
		for (int i = 2; i <= number; i++) {
			result = result * i;
		}
		return result;
	}

	// Given the number N return the index value of the fibonacci sequence
	// ie. fibonacci sequence: 0 1 1 2 3 5 8 13 21 34 55 89...
	// index: 0 1 2 3 4 5 6 7 8 9 10 11
	// So in case the input number is 6 then it should return 8
	// the input number is 8 then it should return 21
//	O(2^n)
	private long getFabonacciUsingRecursion(int number) {
		if (number < 2) {
			return number;
		}

		return getFabonacciUsingRecursion(number - 1) + getFabonacciUsingRecursion(number - 2);
	}

	// Given the number N return the index value of the fibonacci sequence
	// ie. fibonacci sequence: 0 1 1 2 3 5 8 13 21 34 55 89...
	// index: 0 1 2 3 4 5 6 7 8 9 10 11
	// So in case the input number is 6 then it should return 8
	// the input number is 8 then it should return 21
//	O(n)
	private long getFabonacciUsingIteration(int number) {
		long nMinusOneIndex = 0;
		long result = 1;
		for (int i = 2; i <= number; i++) {
			long n = result;
			result = result + nMinusOneIndex;
			nMinusOneIndex = n;
		}
		return result;
	}
}
