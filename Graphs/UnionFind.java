package Graphs;

import java.util.LinkedList;

public class UnionFind {
	public static void main(String[] args) {
		
	}
	//Union Find has to keep trac of all Object and their groups
	LinkedList<Group> groups = new LinkedList<Group>();
	public UnionFind(int[] ver) {
		for(int i = 0; i < ver.length; i++) {
			groups.add(new Group(new Ver(ver[i])));
		}
	}
	public void union(Group g1, Group g2) {
		groups.remove(g2);
		g1.last.next = g2.first;
	}
	public Group find(int v) {
		for(Group g : groups) {
			if(g.contains(v)) {
				return g;
			}
		}
		return null;
	}
}
class Group{
	Ver first;
	Ver last;
	public Group(Ver v) {
		first = v;
		last = v;
	}
	public boolean contains(int i) {
		Ver current = first;
		do {
			if(current.num == i) {
				return true;
			}
			current =  current.next;
		}while(current != null);
		return false;
	}
}
class Ver{
	int num;
	Ver next;
	public Ver(int num) {
		this.num = num;
	}
}
