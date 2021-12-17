package com.javastreams;

public class Test {
	public static void main(String[] args) {
		new Test().inception();
	}

	private void inception() {
		inception();

	}
}
