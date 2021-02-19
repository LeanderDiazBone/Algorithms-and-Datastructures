package SearchingSorting;

import java.util.Arrays;

public class SelectionSort extends Sort{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2456456,3456,45,6,3456,2456,2456,45,63,456,345,6,345,6,456,2,456,245,6,2456,24,56};
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public void sort(int[] A) {
		selectionSort(A);
	}
	public static void selectionSort(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			int min = arr[i];
			int pos = i;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] < min) {
					min = arr[j];
					pos = j;
				}
			}
			for(int j = pos; j > i; j--) {
				arr[j] = arr[j-1];
			}
			arr[i] = min;
		}
	}
}
