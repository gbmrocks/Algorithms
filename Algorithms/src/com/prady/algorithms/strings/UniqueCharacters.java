package com.prady.algorithms.strings;

import java.util.Arrays;
import java.util.Scanner;

public class UniqueCharacters {
	
	/*public static void main(String[] args){
		UniqueCharacters uniqueCharacters= new UniqueCharacters();
		Scanner scanner = new Scanner(System.in);
		System.out.println(uniqueCharacters.checkUniqueness(scanner.nextLine()));
		
	}
	
	public boolean checkUniqueness(String inputString){
		int counter = 0;
		System.out.println(inputString);
		boolean[] test = new boolean[256];
		for(int i=0; i <inputString.length(); i++){
			counter++;
			System.out.println(counter);
			int value = inputString.charAt(i);
			if(test[value])
				return false;
			test[value] = true;
			
		}
		return true;
	}*/
	
	public static void main(String[] args){
        Scanner sc 	= new Scanner(System.in);
//        String str1 = sc.next();
//        String str2 = sc.next();
        System.out.println("Unique? " + checkUniqueness(sc.next()));
        sc.close();
        
        char[] arr = "abf vf".toCharArray();
        
        
        /*int i = 0;
        int j = arr.length-1;
        while(i<j){
        	char temp = arr[i];
        	arr[i]= arr[j];
        	arr[j]= temp;
        	i++;
        	j--;
        }*/
        System.out.println(new StringBuilder("abf vg").reverse().toString());
//        System.out.println("Permutation? " + checkPermutation(str1, str2));
    }


    public static boolean checkUniqueness(String inputString){
        boolean[] isDuplicate     = new boolean[256];
        for(int i=0; i<inputString.length(); i++){
            int charValue = inputString.charAt(i);
            if(isDuplicate[charValue])
                return false;
            isDuplicate[charValue] = true;
        }
        return true;
    }
	
    /*public static boolean checkPermutation(String str1, String str2){
    	HashSet charSet1 = new HashSet();
    	HashSet charSet2 = new HashSet();
    	charSet1.add(str1.toCharArray());
    	charSet2.add(str2.toCharArray());
    	
    	if(charSet1.size() != charSet2.size())
    		return false;
    	Iterator itr = charSet1.iterator();
    	while(itr.hasNext()){
    		char c = (char) itr.next();
    		if(!charSet2.contains(c))
    			return false;
    	}
    	return false;
    }*/
}
