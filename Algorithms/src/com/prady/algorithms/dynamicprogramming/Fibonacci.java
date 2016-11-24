package com.prady.algorithms.dynamicprogramming;

import java.math.BigInteger;
import java.util.*;

public class Fibonacci {
	
	/*static long[] arr;
	public static void main(String[] args){
        int i = 50;
        arr = new long[i+1];
        System.out.println(dCalc(i));
//        System.out.println("Result: " + calculate(i));
    }
	
	//Non-Dynamic
    public static int calculate(int n){
        return n <= 1? n : calculate(n-1) + calculate(n-2);
    }
    
    //Dynamic Programming
    public static long dCalc(int n){
    	if(n<=1){
    		arr[n] = n;
    		return n;
    	}
    	long a 	= arr[n-1]!=0?arr[n-1]:dCalc(n-1);
    	long b 	= arr[n-1]!=0?arr[n-2]:dCalc(n-2);
    	arr[n] 	= a+b;
    	return arr[n];
    }*/
	
	static BigInteger[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger t1  = new BigInteger(sc.nextInt()+"");
        BigInteger t2  = new BigInteger(sc.nextInt()+"");
        BigInteger temp = new BigInteger("0");
        int n   = sc.nextInt();
        arr = new BigInteger[n+1];
        arr[0] = t1;
        arr[1] = t2;
        
        for(int i=3; i <=n; i++){
        	temp = t2;
        	t2 = t1.add(t2.multiply(t2));
        	t1 = temp;
        }
        System.out.println(t2);
        sc.close();
    }
    
    public static BigInteger calculate(int n){
        if(n<=2){
            return arr[n-1];
        }
        BigInteger a = arr[n-1]!=null?arr[n-1]:calculate(n-1);
        BigInteger b = arr[n-2]!=null?arr[n-2]:calculate(n-2);
        
        arr[n] = b.add(a.multiply(a));
        return arr[n];
    }
}
