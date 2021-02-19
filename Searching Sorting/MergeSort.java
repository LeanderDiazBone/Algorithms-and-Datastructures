package SearchingSorting;

import java.util.Arrays;

public class MergeSort extends Sort{
	public static void main(String[] args) {
		int[] A = {234,52,345,2345,23,45,234,52,345,2345,2,345,234,5,2345,2,345,23,452345};
		mergeSort(A, 0, A.length-1);
		System.out.println(Arrays.toString(A));
		int[] B = {23452345,52,345,234,5,35,2,345,2,345,23,45,234,5,2345,2,345,23,45,2345};
		mergeSort(B, 0, B.length-1);
		System.out.println(Arrays.toString(B));
		int[] C = {456345,6,3456,34,563,45,345,7,3457,457,3456,435,6,3456,3,456,34,5624,5624,56,246};
		mergeSort(C, 0, C.length-1);
		System.out.println(Arrays.toString(C));
	}
	public void sort(int[] A) {
		mergeSort(A, 0, A.length-1);
	}
	public static void mergeSort(int[] A, int left, int right) {
		if(right-left > 0) {
			int middle = (right+left)/2;
			mergeSort(A, left, middle);
			mergeSort(A, middle+1, right);
			merge(A,left,middle,right);
		}
	}
	public static void merge(int[] A, int left, int middle, int right) {
		int B[] = new int[right-left+1];
		int i = left;
		int j = middle+1;
		int m = 0;
		while(i <= middle && j <= right) {
			if(A[i] < A[j]) {
				B[m] = A[i];
				i++;
				m++;
			}else {
				B[m] = A[j];
				j++;
				m++;
			}
		}
		while(i <= middle) {
			B[m] = A[i];
			m++;
			i++;
		}
		while(j <= right) {
			B[m] = A[j];
			m++;
			j++;
		}
		for(int x = 0; x < B.length; x++) {
			A[left+x] = B[x];
		}
	}
}
