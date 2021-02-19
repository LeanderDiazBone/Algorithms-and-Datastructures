package SearchingSorting;

import java.util.Arrays;

public class QuickSort extends Sort{
	public static void main(String[] args) {
		int[] A = {23452345,13,1,235132,5,13,451,23,4,123,513,45,134,5,1345,1345};
		quickSort(A, 0, A.length-1);
 		System.out.println(Arrays.toString(A));
		int[] B = {2345,234,5,2345,236,245,6,234,65,6,345,7,4568,5,6,2456,3,4567,24,56,234,6,25,6};
		quickSort(B, 0, B.length-1);
 		System.out.println(Arrays.toString(B));
		int[] C = {23462456,2,456,24,56,245,6,234,5,345,2,456,25,6,23,5,2345,23,46,234,5}; 
  		quickSort(C, 0, C.length-1);
 		System.out.println(Arrays.toString(C));
	}
	public void sort(int[] A) {
		quickSort(A, 0, A.length-1);
	}
	public static void quickSort(int[] A, int left, int right) {
		if(left < right) {
			int middle = partition(A, left, right);
			quickSort(A, left, middle-1);
			quickSort(A, middle+1, right);
		}
	}
	public static int partition(int[] A, int left, int right) {
		int midEl = A[right];
		int i = left;
		int j = right-1;
		do {
			//System.out.println(i + " " + A[i] + " " + j + " " +A[j]);
			while(i < right && A[i] <= midEl) i++;
			while(left < j && A[j] >= midEl) j--;
			if(i < j) {
				int b = A[i];
				A[i] = A[j];
				A[j] = b;
			}
		}while(i < j);
		A[right] = A[i];
		A[i] = midEl;
		return i;
	}
}
