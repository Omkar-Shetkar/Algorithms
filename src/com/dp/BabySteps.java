package com.dp;

public class BabySteps {

	static int totalSteps = 2;
	static int[] cache = new int[totalSteps + 1];

	public static void main(String[] args) {
		initCache();
		int totalWays = countWays(totalSteps);
		System.out.println(totalWays);
	}

	private static void initCache() {
		for (int i = 0; i < cache.length; i++)
			cache[i] = -1;
	}

	private static int countWays(int n) {
		if (n < 0)
			return 0;

		if (cache[n] != -1)
			return cache[n];

		if (n == 0) {
			cache[n] = 1;
			return cache[n];
		}

		int oneStepToGo = countWays(n - 1);
		int twoStepsToGo = countWays(n - 2);
		int threeStepsToGo = countWays(n - 3);
		cache[n] = oneStepToGo + twoStepsToGo + threeStepsToGo;

		return cache[n];
	}

}
