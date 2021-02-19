package Graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraADList {
	public static void main(String[] args) {
		int[][] Adlist = {{1,4,6},{2,3,8},{3},{5},{5},{},{},{},{7,9},{6}};
		int[][] w =      {{2,4,15},{1,3,4},{1},{3},{5},{},{},{},{6,5},{2}};
		int s = 0;
		int[] minDis = dijkstra(s,Adlist,w);
		System.out.println(Arrays.toString(minDis));
	}
	public static int[] dijkstra(int s, int[][] Adlist, int[][] w) {
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		boolean[] found = new boolean[Adlist.length];
		int[] pre = new int[Adlist.length];
		int[] mDis = new int[Adlist.length];
		for(int i = 0; i < Adlist.length; i++) {
			pre[i] = -1;
			found[i] = false;
			mDis[i] = Integer.MAX_VALUE;
		}
		mDis[s] = 0;
		found[s] = true;
		Pair st = new Pair(s, 0);
		q.add(st);
		while(!q.isEmpty()) {
			Pair p = q.remove();
			System.out.println(p.node + " " + p.disTo);
			found[p.node] = true; 
			for(int i = 0; i < Adlist[p.node].length; i++) {
				if(!found[Adlist[p.node][i]]) {
					if(mDis[Adlist[p.node][i]] > mDis[p.node]+w[p.node][i]) {
						mDis[Adlist[p.node][i]] = mDis[p.node]+w[p.node][i];
						pre[i] = p.node;
						Pair px = new Pair(Adlist[p.node][i], mDis[Adlist[p.node][i]]);
						q.add(px);
					}
				}
			}
		}
		return mDis;
	}
}
class Pair implements Comparable{
	int disTo;
	int node;
	public Pair(int node, int disTo) {
		this.node = node;
		this.disTo = disTo;
	}
	@Override
	public boolean equals(Object p2){
		if(this.node == ((Pair)p2).node) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Pair p = ((Pair)o);
		if(this.disTo == p.disTo) {
			return 0;
		}else if(this.disTo > p.disTo) {
			return 1;
		}else {
			return -1;
		}
	}
}
