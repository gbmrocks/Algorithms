package com.prady.algorithms.graph;

public class Knapsack {
	
	/*public int findTotal(int[] arr, int max){
		
	}*/
	
	static int[] values = new int[] {894, 260, 392, 281, 27};
	static int[] weights = new int[] {8, 6, 4, 0, 21};
	static int W = 30;

	private static int knapsack(int i, int W) {
	    if (i < 0) {
	        return 0;
	    }
	    if (weights[i] > W) {
	        return knapsack(i-1, W);
	    } else {
	        return Math.max(knapsack(i-1, W), knapsack(i-1, W - weights[i]) + values[i]);
	    }
	}

	public static void main(String[] args) {
	System.out.println(knpsck(values.length - 1, W));}
	
	
	
	public static int knpsck(int i, int wt){
		if(i<0)
			return 0;
		if(weights[i]>wt)
			return knpsck(i-1, wt);
		else
			return Math.max(knpsck(i-1, W), knpsck(i-1, wt-weights[i])+values[i]);
	}
}
