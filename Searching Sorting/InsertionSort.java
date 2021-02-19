package SearchingSorting;

import java.util.Arrays;

public class InsertionSort extends Sort{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {435,234,23,567,2645,7357,3456,357,3567,35,66,356,357345,7357,3457354};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr)); 
	}
	public void sort(int[] A) {
		insertionSort(A);
	}
	public static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int pos = i;
			int key = arr[i];
			for(int j = 0; j < i; j++) {
				if(arr[j] > key) {
					pos = j;
					break;
				}
			}
			for(int j = i; j > pos; j--) {
				arr[j] = arr[j-1];
			}
			arr[pos] = key;
		}
	}
}
