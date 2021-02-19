package Graphs;

import java.util.LinkedList;

public class UndirectedGraph {
	public static void main(String[] args) {
		
	}
	public int kRegular(boolean[][] graph) {
		int[] degree = new int[graph.length];
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j <= i; j++) {
				if(graph[i][j]) {
					degree[i]++;
					degree[j]++;
				}
			}
		}
		int k = degree[0];
		for(int i = 1; i < degree.length; i++) {
			if(degree[i] != k) {
				return -1;
			}
		}
		return k;
	}
	public boolean hasTriangle(boolean[][] graph) {
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j <= i; j++) {
				if(graph[i][j]) {
					for(int x = 0; x < graph.length; x++) {
						if(graph[j][x] && graph[x][i]) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	public int getGraphDiameter(boolean[][] graph) {
		int max = 0;
		for(int i = 0; i < graph.length; i++) {
			int[] arr = BFS(graph, i);
			for(int j = 0; j < arr.length; j++) {
				max = Math.max(max, arr[j]);
			}
		}
		if(max == Integer.MAX_VALUE) return -1;
		else return max;
	}
	public int[] BFS(boolean[][] graph, int s) {
		boolean[] marked = new boolean[graph.length];
		int[] minDis = new int[graph.length];
		for(int i = 0; i < graph.length; i++)minDis[i] = Integer.MAX_VALUE;
		//int[] pre = new int[graph.length];
		minDis[s] = 0;
		marked[s] = true;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		while(!queue.isEmpty()) {
			int x = queue.removeLast();
			for(int i = 0; i < graph.length; i++) {
				if(graph[x][i] && !marked[i]) {
					queue.add(i);
					minDis[i] = minDis[x]+1;
					marked[i] = true;
				}
			}
			
		}
		return  minDis;
	}
	public boolean containsEulerWalk(boolean[][] graph) {
		int uneven = 0;
		int degree = 0;
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph.length; j++) {
				if(graph[i][j]){
					degree++;
				}
			}
			if(degree % 2 == 1) uneven++;
			degree = 0;
		}
		if(uneven > 2) {
			return false;
		}
		return true;
	}
}
