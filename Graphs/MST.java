package Graphs;

import java.util.LinkedList;

public class MST {
	public static void main(String[] args) {
		int n = 4;
		Edges[] edges = new Edges[8];
		edges[0] = new Edges(0,1,4);
		edges[1] = (new Edges(0,3,6));
		edges[2] = (new Edges(1,2,12));
		edges[3] = (new Edges(1,3,5));
		edges[4] = (new Edges(2,0,7));
		edges[5] = (new Edges(2,1,3));
		edges[6] = (new Edges(3,0,9));
		edges[7] = (new Edges(3,2,4));
		kruskal(n, edges);
	}
	public static void kruskal(int n, Edges[] edges) {
		int sum = 0;
		sort(edges);
		int[] ver = new int[n];
		for(int i = 0; i < n; i++)ver[i]=i;
		UnionFind u = new UnionFind(ver);
		int counter = 0;
		while(u.groups.size() != 1 || counter == edges.length) {
			Edges e = edges[counter];
			if(!u.find(e.start).equals(u.find(e.end))) {
				//System.out.println(" asdf");
				u.union(u.find(e.start), u.find(e.end));
				sum += e.w;
			}
			counter++;
		}
		System.out.println(sum);
	}
	public static void sort(Edges[] edges) {
		for(int i = 0; i < edges.length; i++) {
			for(int j = 0; j < edges.length-1-i; j++) {
				if(edges[j].w > edges[j+1].w) {
					Edges e = edges[j];
					edges[j] = edges[j+1];
					edges[j+1] = e;
				}
			}
		}
	}
}
class Edges{
	int w;
	int start;
	int end;
	public Edges(int start, int end, int w) {
		this.w = w;
		this.start = start;
		this.end = end;
	}
}
