package uk.co.puce4.misc;

import java.util.ArrayList;
import java.util.Collections;

public class BuildBaseExponentList {

	public static ArrayList<BaseExponent> build(ArrayList<Integer> factors){
		Collections.sort(factors);
		ArrayList<BaseExponent> lbe = new ArrayList<BaseExponent>();
		int lastFactor = 0;
		BaseExponent current = new BaseExponent(0);
		for (Integer factor: factors){
			if(factor == lastFactor){
				current.incrementExponent();
			}else{
				if(lastFactor > 0){
					lbe.add(current);
				}
				current = new BaseExponent(factor);
				lastFactor = factor;
			}
		}
		if(lastFactor > 0){
			lbe.add(current);
		}
		return lbe;
	}

}
