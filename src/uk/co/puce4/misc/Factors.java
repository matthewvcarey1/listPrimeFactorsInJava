package uk.co.puce4.misc;

import java.util.ArrayList;

public class Factors {
	public static ArrayList<Integer> listFactors(int num, ArrayList<Integer> primes,ArrayList<Integer> results) {
		if (num < 2) {
			return results;
		}
		for (Integer prime : primes) {
			if (num % prime == 0) {
				results.add(prime);
				final ArrayList<Integer> factors = listFactors(num / prime, primes, results);
				return factors;
			}
		}
		return results;
	}
}

