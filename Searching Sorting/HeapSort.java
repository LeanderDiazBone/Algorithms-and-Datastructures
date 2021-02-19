package SearchingSorting;

import java.util.Arrays;

public class HeapSort extends Sort{
	public static void main(String[] args) {
		int[] A = {124,124,23,312,423,52345,23,5,234,1,24,13,5};
		int[] B = {14315,34,34,5,1345,1345,1,345,6,34,5,134,5134,6,3146,13,45};
		int[] C = {134,51,345,134,5,145,2,34,1235,4,5,34,5,2345,235,23,5,234,234,32,4,234,23,4};
		heapSort(A);
		heapSort(B);
		heapSort(C);
	}
	public static void heapSort(int[] A) {
		int n = A.length;
		makeHeap(A);
		//System.out.println(Arrays.toString(A));
		for(int i = 0; i < n; i++) {
			int b = A[0];
			//System.out.println("Max: "+b);
			A[0] = A[n-i-1];
			A[n-i-1] = b;
			//System.out.println(Arrays.toString(A)+ " "+isHeap(A));
			heapify(A,0,n-i-1);
			//System.out.println(Arrays.toString(A)+ " "+isHeap(A));
		}
		System.out.println("Sorted: "+Arrays.toString(A));
		System.out.println();
	}
	public static void makeHeap(int[] A) {
		int n = A.length;
		for(int i = n/2; i >= 0; i--) {
			heapify(A, i,n);
		}
	}
	public static void heapify(int[] A, int i, int m) {	//Array A soll zum Heap bis zur Pos m werden
		while(2*i < m) {
			int j = 2*i;
			if(j+1 < m && A[j+1] > A[j]) {
				j++;
			}
			if(A[j] <= A[i]) {
				break;
			}else {
				int b = A[i];
				A[i] = A[j];
				A[j] = b;
				i = j;
			}
		}
	}
	public static boolean isHeap(int[] A) {
		int n = A.length;
		for(int i = 0; i < n/2;i++) {
			int j1 = 2*i;
			int j2 = 2*i+1;
			if(j1 < n && A[j1] > A[i]) {
				return false;
			}
			if(j2 < n && A[j2] > A[i]) {
				return false;
			}
		}
		return true;
	}
}
	