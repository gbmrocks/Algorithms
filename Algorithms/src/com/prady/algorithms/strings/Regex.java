package com.prady.algorithms.strings;

import java.util.*;
import java.util.regex.*;

public class Regex {
	public static void main(String[] args) {
		/*	String input = 
	                  "E: piyush14jkjfgsdkhghshsghsghsuly@gmail.com";
			Pattern p = Pattern.compile("(?<=.{4}).{0,}(?=.*.@)");
			Matcher m = p.matcher(input);
			String result = m.replaceFirst("***").toString();
			System.out.println(result);
		 */


		String input2 = "P:+13334445678";
		String reg = "(?<=.{2,3})\\d{10}";
//		if(input2.)
		Pattern p2 = Pattern.compile("(?<=.{2,3})\\d(?=.*.{4})");
		Matcher m2 = p2.matcher(input2);
		StringBuffer temp = new StringBuffer();
		while(m2.find()){
			m2.appendReplacement(temp, "*");
		}	
		m2.appendTail(temp);
		String regex = "\\*(\\s*)\\(";
		Pattern p3 = Pattern.compile(regex);
		Matcher m3 = p3.matcher(temp);
		String result = m3.replaceFirst("*-").toString();
		result = result.replaceAll("\\(", "");
		result = result.replaceAll("\\)", "-");
		System.out.println(result);
		
		
		//Email Mask
		emailMask("neog.pradyumna@gmail.com");
		removeChar("2-4a0r7-4k", 3);
		reformat("2-4a0r7-4k", 3);
	}
	
	
	public static void emailMask(String input){
		String regex = "(?<=.{1}).(?=.*.@)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		StringBuffer buffer = new StringBuffer();
		while(matcher.find()){
			matcher.appendReplacement(buffer, "*");
		}
		buffer = matcher.appendTail(buffer);
		String result = buffer.toString().replaceAll("\\*{1,}", "*****");
		System.out.println(result);
	}
	
	
	public static void phoneMask(String input){
		
	}
	
	/**
	 * Method that removes characters from an input string that matches a regex
	 * @param input
	 */
	public static void removeChar(String input, int splitLength){
		/*String regex 	= "(?=.*)-(?=.*)";
		Pattern pattern	= Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		StringBuffer buffer = new StringBuffer();
		while(matcher.find()){
			matcher.appendReplacement(buffer, "");
		}
		matcher.appendTail(buffer);
		
		String regex2 	= ".(?=.{4})*"; 
		Pattern ptrn2 	= Pattern.compile(regex2);
		Matcher matchR 	= ptrn2.matcher(buffer);
		StringBuffer buf2 = new StringBuffer();
		if(matchR.find()){
			matchR.appendReplacement(buf2, "$1-");
		}
		matchR.appendTail(buf2);
		System.out.println(buf2.toString());*/
		input = input.replaceAll("-", "").toUpperCase();
		
		System.out.println(input);
		char[] inputCharArr = input.toCharArray();
		Stack<Character> charStack = new Stack<Character>();
		int counter = 0;
		for(int i = inputCharArr.length-1; i>=0; i--){
			if(counter == splitLength){
				charStack.push('-');
				counter = 0;
			}
			charStack.push(inputCharArr[i]);
			counter++;
		}
		StringBuffer buffer = new StringBuffer();
		while(!charStack.isEmpty()){
			buffer.append(charStack.pop());
		}
		System.out.println(buffer.toString());
//		Character[] output = (Character[])charStack.toArray();
//		System.out.println(new String(output.toString()));
	}
	
	public static void reformat(String input, int split){
		char[] inputArr = input.replaceAll("-", "").toUpperCase().toCharArray();
//		int count = 0;
		StringBuffer buffer = new StringBuffer();
		for(int i = inputArr.length-1; i>=0; i--){
			if((i%split)==0){
				buffer.append("-");
//				count = 0;
			}
			buffer.append(inputArr[i]);
//			count++;
		}
		System.out.println(buffer.reverse().toString());
	}
}
