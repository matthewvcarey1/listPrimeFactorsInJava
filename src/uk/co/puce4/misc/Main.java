package uk.co.puce4.misc;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
		long start = System.nanoTime();
		int num=100;
		if (args.length > 0) {
			try {
				num = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.err.println("Argument " + args[0] + " must be an integer.");
				System.exit(1);
			}

		}

		ArrayList<Integer> primes = Sieve.primes(num);

		ArrayList<Integer> factors = new ArrayList<Integer>();
		factors	= Factors.listFactors(num,primes, factors);
		ArrayList<BaseExponent> lbe = BuildBaseExponentList.build(factors);
		boolean first = true;
		StringBuffer sb = new StringBuffer();
		for (BaseExponent be : lbe){
			if(!first){
				sb.append(" \u00D7 ");
			}
			first = false;
			sb.append(be);
		}
		System.out.println(sb);

		long end = System.nanoTime();
		long taken = end - start;
		if(taken > 1000000000){
			System.out.printf("\nTime taken: %d.%d s\n", taken / 1000000000, taken % 1000000000);
		}
		else {
			if (taken > 1000000) {
				System.out.printf("\nTime taken: %d.%d ms\n", taken / 1000000, taken % 1000000);
			}
			else{
				if (taken > 1000) {
					System.out.printf("\nTime taken: %d.%d \u03BCs\n", taken / 1000, taken % 1000);
				}
				else{
					System.out.printf("\nTime taken: %d ns\n", taken);
				}
			}
		}
    }
}