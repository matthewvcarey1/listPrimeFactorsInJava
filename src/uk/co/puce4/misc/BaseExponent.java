package uk.co.puce4.misc;

import java.util.Stack;

public class BaseExponent {
	int base;
	int exponent;
	public BaseExponent(int base){
		this.base = base;
		this.exponent = 1;
	}
	public void incrementExponent(){
		exponent++;
	}
	private StringBuffer exponentToSuperScript(){
		String superscriptDigits[] = new String[] {
				"\u2070",
				"\u00B9",
				"\u00B2",
				"\u00B3",
				"\u2074",
				"\u2075",
				"\u2076",
				"\u2077",
				"\u2078",
				"\u2079", };
		int n = exponent;
		StringBuffer buff = new StringBuffer();
		Stack<String> s= new Stack<String>();
		while (n > 0){
			int val = n % 10;
			s.push(superscriptDigits[val]);
			n = n / 10;
		}
		while (!s.empty()){
			buff.append(s.pop());
		}
		return buff;
	}
	public String toString(){
		StringBuffer buff = new StringBuffer();
		buff.append(base);
		if(exponent > 1){
			buff.append(exponentToSuperScript());
		}
		return buff.toString();
	}
}
