package com.prady.algorithms.strings;

public class StringPermutation {
	public static void main(String[] args){
		System.out.println(hasSameChar("prady", "radyp"));
	}
	
	// Not optimal solution because it time complexity is O(n)
	public static boolean isSame(String input1, String input2){
		if(input1.length() != input2.length())
			return false;
		boolean[] charMapArr = new boolean[256];
		for(int i=0; i<input1.length(); i++){
			charMapArr[input1.charAt(i)] = true;
		}
		for(int i =0; i<input2.length();i++){
			if(!charMapArr[input2.charAt(i)])
				return false;
		}
		return true;
	}
	
	/*public static boolean hasSameChar(String str1, String str2){
	    char[] strArr1 = str1.toCharArray();
	    char[] strArr2 = str2.toCharArray();
	    if(strArr1.length != strArr2.length)
	        return false;
	    return true;
	}
	*/
	public static boolean hasSameChar(String str1, String str2){
	    if(str1.length() != str2.length())
	        return false;
	    return sort(str1).equals(sort(str2));
	}

	public static String sort(String str){
	    char[] charArr = str.toCharArray();
	    java.util.Arrays.sort(charArr);
	    return new String(charArr);
	}
}
