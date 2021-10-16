package uk.co.puce4.misc;

import java.util.ArrayList;

public class Sieve {
	public static ArrayList<Integer> primes(int num){
		boolean[] bool = new boolean[num];

		for (int i = 0; i< bool.length; i++) {
			bool[i] = true;
		}
		for (int i = 2; i< Math.sqrt(num); i++) {
			if(bool[i] == true) {
				for(int j = (i*i); j<num; j = j+i) {
					bool[j] = false;
				}
			}
		}
		ArrayList<Integer> results = new ArrayList<Integer>();
		for (int i = 2; i< bool.length; i++) {
			if(bool[i]==true) {
				results.add(i);
			}
		}
		return results;
	}
}
