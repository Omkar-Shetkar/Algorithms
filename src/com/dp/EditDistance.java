package com.dp;

public class EditDistance {

	private static String source = "OUR";
	private static String target = "HOUR";
	private static int[][] cache = new int[source.length() + 1][target.length() + 1];

	public static void main(String[] args) {

		initCache();
		int editDistance = editDistance(source.length(), target.length());

		System.out.println(editDistance);
	}

	private static void initCache() {
		for (int i = 0; i < cache.length; i++)
			for (int j = 0; j < cache[i].length; j++)
				cache[i][j] = -1;

	}

	private static int editDistance(int sl, int tl) {

		if (sl < 0 || tl < 0)
			return 0;

		if (cache[sl][tl] != -1)
			return cache[sl][tl];

		if (sl == 1 && tl == 0) {
			cache[1][0] = 1;
			return cache[sl][tl];
		}

		if (sl == 0 && tl == 1) {
			cache[0][1] = 1;
			return cache[sl][tl];
		}

		if (sl == 0 && tl == 0) {
			cache[0][0] = 0;
			return cache[sl][tl];
		}

		int substitutionCost = editDistance(sl - 1, tl - 1) + cost(sl, tl);
		int deletionCost = editDistance(sl, tl - 1) + 1;
		int addtionCost = editDistance(sl - 1, tl) + 1;
		cache[sl][tl] = Math.min(substitutionCost,
				Math.min(deletionCost, addtionCost));

		return cache[sl][tl];
	}

	private static int cost(int sl, int tl) {
		if (source.charAt(sl - 1) == target.charAt(tl - 1))
			return 0;
		return 1;
	}
}
