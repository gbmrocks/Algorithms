package com.prady.algorithms.strings;

import java.util.regex.Pattern;

public class StairCase {
	public static void main(String[] args) {
		int n=6;
		System.out.println("Staircase");
		for(int i=n; i>0; i--){
//			int j=0;
			StringBuffer bf = new StringBuffer();
			int spaces = (i-1);
			int hashes = (n-spaces);
//			String regex = + spaces+"" + hashes + ;
			bf.append("\\s{");
			bf.append(spaces);
			bf.append("}\\#{");
			bf.append(hashes);
			bf.append("}\\n");
			Pattern pat = Pattern.compile(bf.toString());
			/*for(;j<i;j++)
				System.out.print(" ");*/
//			for(;j<n;j++)
//				System.out.print("#");
			System.out.println(pat);
		}
	}
}
