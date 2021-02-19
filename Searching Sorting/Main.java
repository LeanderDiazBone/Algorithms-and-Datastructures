package SearchingSorting;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Sort> sorter = new ArrayList<Sort>();
		BubbleSort bS = new BubbleSort();
		sorter.add(bS);
		HeapSort hS = new HeapSort();
		sorter.add(hS);
		InsertionSort iS = new InsertionSort();
		sorter.add(iS);
		MergeSort mS = new MergeSort();
		sorter.add(mS);
		QuickSort qS = new QuickSort();
		sorter.add(qS);
		SelectionSort sS = new SelectionSort();
		sorter.add(sS);
		for(Sort sort : sorter) {
			int[] A = randomArray(50);
			sort.sort(A);
			System.out.println(Search.isSorted(A));
		}
	}
	public static int[] randomArray(int n) {
		int[] A = new int[n];
		for(int i = 0; i < n; i++) {
			A[i] = (int)Math.random()*200-100;
			
		}
		return A;
	}
}
