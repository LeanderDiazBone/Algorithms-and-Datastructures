package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] Adjlist = {{2,3},{4,5},{1,2},{},{},{},{}};
		int[][] Weights = {{},{},{},{},{},{},{}};
		dijkstra(Adjlist, Weights, 0);
	}
	public static int[] dijkstra(int[][] Adjlist, int[][] Weights, int s) {
		int n = Adjlist.length;
		int[] mDis = new int[n];
		boolean[] marked = new boolean[n];
		marked[s] = true;
		PQueue queue = new PQueue();
		queue.enqueue(s, 0);
		while(queue.size() != 0) {
			V ver = queue.dequeue();
			marked[ver.s] = true;
			mDis[ver.s] = ver.dis;
			for(int i = 0; i < Adjlist[ver.s].length; i++) {
				if(!marked[Adjlist[ver.s][i]]) {
					
				}
			}
			
		}
		return mDis;
	}
	public static int[] Dikjkstra2(int[][] Graph, int[][] w, int s) {
		Vert[] verti = new Vert[Graph.length];
		PriorityQueue<Vert> q = new PriorityQueue<Vert>();
		int[] minDis = new int[Graph.length];
		for(int i = 0; i < Graph.length; i++) {
			Vert v = new Vert(i, 1000000);
			minDis[i] = 1000000;
			verti[i] = v;
			q.add(v);
		}
		minDis[s] = 0;
		q.remove(verti[s]);
		q.add(new Vert(s,0));
		while(!q.isEmpty()) {
			Vert v = q.remove();
			for(int i = 0; i < Graph[v.i].length; i++) {
				if(minDis[Graph[v.i][i]] > minDis[v.i] + w[v.i][i]) {
					minDis[Graph[v.i][i]] = minDis[v.i] + w[v.i][i];
					verti[Graph[v.i][i]].dis = minDis[v.i] + w[v.i][i];
					q.remove(verti[Graph[v.i][i]]);
					q.add(verti[Graph[v.i][i]]);
				}
			}
		}
		return minDis;
	}
}

class Vert implements Comparable{
	int i;
	int dis;
	public Vert(int i, int dis){
		this.i = i;
		this.dis = dis;
	}
	@Override
	public int compareTo(Object o) {
		Vert v = (Vert)o;
		if(dis == v.dis) {
			return 0;
		}else if(dis < v.dis) {
			return 1;
		}else {
			return 0;
		}
}
}
class PQueue{
	ArrayList<V> heap = new ArrayList<V>();
	public void enqueue(int s, int dis) {
		V ver = new V();
		ver.dis = dis;
		ver.s = s;
	}
	public V dequeue() {
		return heap.remove(0);
	}
	public int size() {
		return heap.size();
	}
}

class V{
	int s;
	int dis;
}
