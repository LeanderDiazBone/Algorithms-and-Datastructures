package SearchingSorting;

public class Search {
	public static void main(String[] args) {
		int[] arr = {1, 23, 42, 50, 81, 92, 105, 129, 147};
		int key = 92;
		System.out.println(binaerySearch(arr, key, 0, arr.length-1));
	}
	//arr has to be sorted 
	public static int binaerySearch(int[] arr, int key, int start, int end) {
		if(start == end) {
			if(key == arr[start]) {
				return start;
			}else {
				return -1;
			}
		}
		int middle = (end+start)/2;
		if(arr[middle] == key) {
			return middle;
		}else if(key < arr[middle]) {
			return binaerySearch(arr, key, start, middle);
		}else {
			return binaerySearch(arr, key, middle, end);
		}
	}
	public static int linearSearch(int[] arr, int key) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == key) {
				return i;
			}
		}
		return -1;
	}
	public static boolean isSorted(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i] > arr[i+1]) {
				return false;
			}
		}
		return true;
	}
}
