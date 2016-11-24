package com.prady.algorithms.hashtable;

public class UsingCustomHashMap {
	public static void main(String[] args){
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("One", "1");
		map.put("Two", "2.0");
		map.put("Three", "3");
		map.put("Four", "4");
		map.put("Five", "5");
		map.put("One", null);
		
		System.out.println(map.get("One"));
		System.out.println(map.get("Five"));
		System.out.println(map.get("Six"));
		char c = 'A';
		System.out.println((int)c);
	}
}	
