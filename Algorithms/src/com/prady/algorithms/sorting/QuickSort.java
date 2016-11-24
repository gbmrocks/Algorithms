package com.prady.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
	
	
	/*
	 * Method returns the pivot position
	 */
	/*public static int partition(int[] arr, int low, int high){
		int pivot = arr[high];
		int i = low-1;
		for(int j=low; j<high-1; j++){
			if(arr[j] <= pivot){
				i++;
				int temp	= arr[i];
				arr[i]		= arr[j];
				arr[j]		= temp;
			}
		}
		
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high]= temp;
		
		return (i+1);
	}
	
	public static void sort(int[] arr, int low, int high){
		if(low>high)
			return;
		int pivotPosition = partition(arr, low, high);
		sort(arr, low, pivotPosition-1);
		sort(arr, pivotPosition+1, high);
	}
	
	public static void main(String[] args){
		int[] arr = {5,89,65,3,1,84,99,12};
		sort(arr, 0, arr.length-1);
		for(int i:arr)
			System.out.print(i+" ");
	}*/
	
	class Rating{
		float score;
		float scale;
		public Rating(float _score, float _scale){
			this.score = _score;
			this.scale = _scale;
		}
		
		public float caliberatedRating(){
			return (score/scale)*5;
		}
	}
	
	public float calculateAverage(ArrayList<Rating> ratingsList){
		float averageScore 	= 0f;
		int totalRatings 	= ratingsList.size();
		float sum 			= 0;
		for(Rating rating:ratingsList){
			sum += rating.caliberatedRating();
		}
		averageScore = sum/totalRatings;
		return averageScore;
	}
	
	public static void main(String[] args) {
		ArrayList<Rating> lis = new ArrayList<>();
//		lis.add(new Rating(1,2));
//		lis.add(new Rating(4,5));
//		lis.add(new Rating(3,5));
//		lis.add(new Rating(4,5));
//		lis.add(new Rating(4,5));
//		System.out.println(calculateAverage(lis));
	}
}
