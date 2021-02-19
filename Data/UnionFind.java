package Datenstrukturen;
import java.util.*;
public class UnionFind<T> {
	private int maxPar;
	private Map<Integer, T> m;
	private Map<T, Integer> map;
	public UnionFind(List<T> list) {
		maxPar = list.size();
		m = new HashMap<Integer, T>();
		map = new HashMap<T, Integer>();
		int counter = 1;
		for(T t : list) {
			m.put(counter, t);
			map.put(t, counter);
			counter++;
		}
	}
	public void union(T t1, T t2) {
		T x = find(t1);
		T y = find(t2);
		int i = map.get(y);
		map.put(x, i);
	}
	public T find(T t) {
		LinkedList<T> list = new LinkedList<T>();
		T t1 = t;
		int i = map.get(t1);
		T t2 = m.get(i);
		while(!t1.equals(t2)) {
			list.add(t1);
			t1 = t2;
			i = map.get(t1);
			t2 = m.get(i);
		}
		for(T t3 : list) {
			map.put(t3, i);
		}
		return t2;
	}
	public String toString() {
		String s = "";
		for(int i = 1; i <= maxPar; i++) {
			s += i+": ";
			for(T t : map.keySet()) {
				if(map.get(t) == i) {
					s += t+",";
				}
			}
			//s += "\n";
			s += "   ";
		}
		return s;
	}
}
