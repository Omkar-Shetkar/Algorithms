package com.string;

public class StringSearchRobinKarp {

	private static final int PRIME = 3;

	private static int computeAndGetHash(char[] input, int start, int end) {
		int hash = 0;
		for (int i = start; i < end; i++) {
			hash += input[i] * Math.pow(PRIME, i);
		}
		return hash;
	}

	private static int rehash(int newIndex, int oldIndex, char[] inputChars, int oldHash, int length) {
		return (int) ((oldHash - inputChars[oldIndex]) / PRIME + inputChars[newIndex] * Math.pow(PRIME, length - 1));
	}

	private static int findString(char[] input, char[] searchString) {
		int index = -1;
		int searchHash = computeAndGetHash(searchString, 0, searchString.length);
		int hash = computeAndGetHash(input, 0, searchString.length);
		for (int i = 0; i < input.length - searchString.length; i++) {
			if (hash == searchHash && checkEqual(searchString, input, i, i + searchString.length)) {
				return i;
			}
			if (i < input.length - searchString.length + 1) {
				hash = rehash(i + searchString.length, i, input, hash, searchString.length);
			}

		}
		return index;
	}

	private static boolean checkEqual(char[] searchString, char[] input, int start, int end) {
		for (int i = 0; i < searchString.length; i++) {
			if (searchString[i] != input[start + i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String input = "Hello World!";
		String search = "ld";
		System.out.println(findString(input.toCharArray(), search.toCharArray()));
	}
}
