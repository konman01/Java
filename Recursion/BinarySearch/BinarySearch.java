package com.konman01.recursion;

public class BinarySearch {
	
	
	private int notFound = -1;
	
	// function to find the number using binary search iteratively
	public int searchNumberItarative(int[] arr, int val) {
		
	
		
		// if the array is null or array length is 0
		if(arr == null || arr.length == 0) {
			
			// then return not found
			return this.notFound;
		}
		
		// get the start and end pointers for the array
		int start = 0;
		int end = arr.length - 1;
		
		while(start <= end) {
			
			// get the mid of the array selected 
			int mid = start + (end - start) / 2;
			
			// if the element of the array at index mid is equal to val
			if(arr[mid] == val) {
				//return the mid index
				return mid;
			}
			
			// element not found
			
			// if the element at the index mid is less than val
			if(arr[mid] < val) {
				// then right part of the array from mid
				start = mid + 1;
			}else {
				
				// else consider the left part of the array from mid
				end = mid - 1;
				
			}// end of if else
			
		}// end of while
		
		
		return -1;
		
	}// end of function
	
	
	private int binarySearch(int[] arr, int start, int end, int val) {
		
		//index start is greater than end
		if(start > end) {
			
			//then val is not found in the array
			return this.notFound;
		}
		
		//get the index of mid index for array with start and end index
		int mid = start + (end - start) / 2;
		
		// if the value at the index mid is val
		if(arr[mid] == val) {
			
			// then return the mid index
			return mid;
		}
		
		// if the value at the index mid is less than val
		if(arr[mid] < val) {
			
			// do the binarySearch on right part of the array from mid index
			return binarySearch(arr, mid+1, end, val);
		}
		
		// else do the binary search on left part of the array from mid index
		return binarySearch(arr, start, mid - 1, val);
		
	}// end of function
	
	
	
	// function to search an val in sorted array in BS fashion recursively
	public int searchNumberRecursive(int arr[], int val) {
		
		// if the array length is 0 or array is null
		if(arr == null || arr.length == 0) {
			return this.notFound;
		}
		
		// get the start and end index of the array
		int start = 0;
		int end = arr.length - 1;
		
		return binarySearch(arr, start, end, val);
		
	}
	
}

// Test cases
// 1. if the key value at the exact middle of the array
// 2. if the array length is even
// 3. if the array length is odd
// 4. if the key is present at the last index of the array
// 5. if the key is not present in the array
// 6. if the key is present at the first index of the array