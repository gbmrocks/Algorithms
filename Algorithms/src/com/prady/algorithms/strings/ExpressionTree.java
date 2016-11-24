package com.prady.algorithms.strings;

import java.util.Scanner;
import java.util.Stack;

public class ExpressionTree {
	public static String expressionTree,seqOfOper;
	public static Stack<Character> store = new Stack<Character>();
	public static void main(String args[] ) throws Exception {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			String input = s.nextLine();
			String[] inputSplit = input.split("/");
			if(inputSplit.length == 2){
				expressionTree = inputSplit[0];
				seqOfOper = inputSplit[1];
				expressionTree = expressionTree.replaceAll("\\s","");
				seqOfOper = seqOfOper.replaceAll("\\s","");

				for(int i = 0;i<seqOfOper.length();i++){
					for(int j =0;j<expressionTree.length();j++){
						store.push(expressionTree.charAt(j));
					}
					expressionTree = performOper(store,seqOfOper.charAt(i), expressionTree);
					System.out.println(expressionTree);
				}
				//System.out.println(expressionTree);
			}
			else if(inputSplit.length == 1){
				System.out.println(inputSplit[0]);
			}
		}
		s.close();
	}

	public static String performOper(Stack<Character> store,char oper, String input){

		String tree = ""; 

		switch(oper){
		case 'R':
			while(!store.empty()){
				char c = store.pop();
				if(c == '('){
					c = ')';
				}
				else if(c == ')'){
					c = '(';
				}
				tree = tree + c;
			}
			return tree;

		case 'S':
			Stack<Character> simpleStack 	= new Stack<Character>();
			Stack<Character> bracketStack 	= new Stack<Character>();
			char[] inputArr	= input.toCharArray();
			char[] outputArr = new char[inputArr.length];
			for(int i= inputArr.length-1; i>=0; i--){
				simpleStack.push(inputArr[i]);
			}
			
			int size = simpleStack.size();
			int counter = 0;
			for(int i=0; i<size; i++){
				char poppedCharacter = simpleStack.pop();
				if(poppedCharacter == '(' && bracketStack.isEmpty()){
					bracketStack.push('(');
				}else if(poppedCharacter == ')' && !bracketStack.isEmpty() && bracketStack.peek() == '('){
					bracketStack.pop();
				}else{
					outputArr[counter] = poppedCharacter;
					counter++;
				}
			}
			
			return new String(outputArr);
			
			/*int count = 0;
			boolean hasleft = false, hasright = false; 
			while(!store.empty()){
				char c = store.pop();
				if(c == '('){
					if(count%3!=0 && hasright){
						hasright = false;
					}
					else if(count%3 == 0 && hasright){
						hasright = false;
					}
					else if(count%3 !=0 && !hasright){
						hasleft = true;
					}
					else{
						tree = c + tree;
					}
				}
				else if(c == ')'){
					if(count%3!=0 && hasleft){
						hasleft = false;
					}
					else if(count%3 == 0 && hasleft){
						hasleft = false;
					}
					else if(count%3 !=0 && !hasleft){
						hasright = true;
					}
					else{
						tree = c + tree;
					}
				}
				else{
					tree = c + tree;
					count++;
				}
			}
			return tree;*/
		default:
			return tree;
		}
	}
}
