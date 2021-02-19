package SearchingSorting;

import java.util.Arrays;

public class BubbleSort extends Sort{

	public static void main(String[] args) {
		int[] arr = {234,6134,234,61345,34542,44,12,4,5,235,34,2134,53234,12412,4,235,2,35};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public void sort(int[] A) {
		bubbleSort(A);
	}
	public static void bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int k = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = k;
				}
			}
		}
	}
}
