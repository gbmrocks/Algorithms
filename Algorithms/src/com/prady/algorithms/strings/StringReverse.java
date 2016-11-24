package com.prady.algorithms.strings;

public class StringReverse {
	
	public static void reverse(String input){
		char[] inputArr = input.toCharArray();
		int forwardPtr=0;
		int reversePtr=inputArr.length-1; 
		
		while(forwardPtr < reversePtr){
			char a 		= inputArr[forwardPtr];
			char temp 	= inputArr[reversePtr];
			inputArr[reversePtr] 	= a;
			inputArr[forwardPtr]	= temp;
			forwardPtr++;
			reversePtr--;
		}
		System.out.println(new String(inputArr));
	}
	
	public static void main(String[] args){
		reverse("test reverse");
	}
}
