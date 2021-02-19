package Datenstrukturen;

import java.util.*;

@SuppressWarnings("rawtypes")
public class Heap<T extends Comparable> {
	private ArrayList<T> heap;			//Datenstruktur, in dem der heap gespeichert wird
	private boolean max;				//true wenn max-Heap, false wenn min-Heap
	public Heap(boolean max){			//type der Objekte des Heaps, max ist boolean, ob Heap max-Heap ist
		heap = new ArrayList<T>();
		this.max = max;
	}
	public void add(T elem) {
		heap.add(elem);
		moveLastUp();
	}
	public T remove() {
		if(heap.size() == 0) {
			throw new InputMismatchException();
		}
		T m = heap.remove(0);
		if(heap.size() > 1) {
			heap.add(0, heap.remove(heap.size()-1));
			restoreHeapCondition(0);
		}
		return m;
	}
	public void restoreHeapCondition(int p) {
		int pos = p+1; int pos2=2*pos;
		while(pos2-1 < heap.size()) {
			if(pos2 < heap.size() && compare(heap.get(pos2), heap.get(pos2-1))) {
				pos2++;
			}
			if(compare(heap.get(pos2-1), heap.get(pos-1))) {
				exchange(pos2-1,pos-1);
				pos = pos2; pos2 *= 2;
			}else break;
		}
	}

	public void moveLastUp() {
		int pos = heap.size();
		int pos2 = pos/2;
		while(pos > 1) {
			if(compare(heap.get(pos-1), heap.get(pos2-1))) {
				exchange(pos-1, pos2-1);
				pos = pos2;
				pos2 = pos/2;
			}else break;
		}
	}
	@SuppressWarnings("unchecked")
	//gibt zurück ob t1 im einem minHeap kleiner als t2 oder in einem maxHeap größer ist als t2
	public boolean compare(T t1, T t2) {
		if(max) {
			return (t1.compareTo(t2) > 0);
		}else {
			return (t1.compareTo(t2) < 0);
		}
	}
	//Vertauscht das Element an der Stelle i1 mit dem Element an der Stelle i2 im heap(ArrayList)
	public void exchange(int i1, int i2) {
		T t = heap.remove(i1);
		T t2 = heap.remove(i2);
		heap.add(i2, t);
		heap.add(i1, t2);
	}
	//Checkt, ob der Heap ein min-/maxHeap nach Angabe ist
	public boolean isHeap() {	
		for(int i = 1; i < (heap.size()+1)/2; i++) {
			if(compare(heap.get(2*i-1), heap.get(i-1))) {
				return false;
			}else if(2*i+1 <= heap.size() && compare(heap.get(2*i), heap.get(i-1))) {
				return false;
			}
		}
		return true;
	}
	public String toString() {
		return heap.toString();
	}
	
}
