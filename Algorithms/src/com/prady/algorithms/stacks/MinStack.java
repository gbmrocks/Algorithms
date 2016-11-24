package com.prady.algorithms.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class MinStack extends Stack<Integer>{
	/** initialize your data structure here. */
    Stack<Integer> minStack;
    
    public MinStack() {
        super();
        minStack = new Stack<Integer>();
    }
    
    
    public Integer push(Integer x) {
        if(minStack.peek() == null || (minStack.peek() != null && minStack.peek() <= x))
            minStack.push(x);
        return super.push(x);
    }
    
    
    public Integer pop() {
        Integer popInt = super.pop();
        if(popInt == minStack.peek()){
            minStack.pop();
        }
        ArrayList list = new ArrayList<>();
        list.get(list.size()-1);
        return popInt;
    }
    
    public int top() {
        return super.peek().intValue();
    }
    
    
    public int getMin() {
        return minStack.size() > 0 ? minStack.peek() : null;
    }
	/*TreeMap<Integer, Integer> minMap = new TreeMap<Integer, Integer>();
	
	public MinStack(){
		super();
	}
	
	@Override
	public Integer push(Integer input){
		super.push(input);
		int count = 1;
		if(minMap.containsKey(input)){
			count = minMap.get(input) + 1;
		}
		minMap.put(input, count);
		return input;
	}
	
	public int getMin(){
		return minMap.size()>0 ? minMap.firstKey() : null;
	}
	
	@Override
	public Integer pop(){
		return super.pop();
		System.tim
	}*/
}
