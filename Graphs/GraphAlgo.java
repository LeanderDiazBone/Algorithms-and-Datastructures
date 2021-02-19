package Graphs;

import java.util.*;

public class GraphAlgo{
	public static void main(String[] args) {
		ArrayList<Edge> edges = new ArrayList<Edge>();
		ArrayList<Vertex> vert = new ArrayList<Vertex>();
		MyGraph G = new MyGraph(vert, edges);
		G.makeGraph();
		GraphAlgo al = new GraphAlgo();
		Vertex s = G.vertices.get(0);
		int[] bfs = al.BFS(G, s);
		Vertex[] dfsrec = (Vertex[])al.DFS(G, s);
		Vertex[] dfsit = (Vertex[])al.DFSIterativ(G, s);
		System.out.println(Arrays.toString(al.BFS(G,s)));
		System.out.println(Arrays.toString(al.DFS(G, s)));
		System.out.println(isTopologicalSort(G,dfsrec));
		System.out.println(Arrays.toString(al.DFSIterativ(G, s)));
		System.out.println(isTopologicalSort(G,dfsit));
	}
	
	public int[] shortestPathWithNumberEdges(MyGraph G, Vertex s, Vertex t, int k){
		int[] dp = new int[k+1];
		for(int i = 0; i <= k; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		LinkedList<Vertex> Queue = new LinkedList<Vertex>();
		LinkedList<Integer> Distances = new LinkedList<Integer>();
		Queue.add(s);
		Distances.add(0);
		for(int i = 0; i <= k; i++) {
			int u = Queue.size();
			for(int j = 0; j < u; j++) {
				Vertex v = Queue.removeLast();
				int dis = Distances.removeLast();
				if(v.equals(t) && dis < dp[i]) {
					dp[i] = dis;
				}
				for(Edge e : G.edges) {
					if(e.start.equals(v)) {
						Queue.addFirst(e.end);
						Distances.addFirst(dis+e.w);
					}
				}
			}
		}
		return dp;
	}
	
	//Computes the minimal number of Edges needed to go from the Starting Vertex s to any other Vertex in the Graph. The order in the Array is determined by the order of the Vertices in the ArrayList
	public int[] BFS(MyGraph G, Vertex s) {
		LinkedList<Vertex> Queue = new LinkedList<Vertex>();
		int[] distances = new int[G.vertices.size()];
		boolean[] marked = new boolean[G.vertices.size()];
		for(int i = 0; i < G.vertices.size(); i++) {
			distances[i] = Integer.MAX_VALUE;
			marked[i] = false;
		}
		Queue.add(s);
		distances[G.vertices.indexOf(s)] = 0;
		while(Queue.size() != 0) {
			Vertex v = Queue.removeLast();
			//System.out.println("Found: "+v.toString());
			int i = G.vertices.indexOf(v);
			marked[G.vertices.indexOf(v)] = true;
			//String en ="Enqueued: ";
			for(Edge e : G.edges) {
				int j = G.vertices.indexOf(e.end);
				if(e.start.equals(v) && !marked[j]) {
					distances[j] = Math.min(distances[j], distances[i]+1);
					Queue.addFirst(e.end);
					//en += e.end.toString()+ " ";
				}
			}
			//System.out.println(en);
		}
		return distances;
	}
	//Calculates A topological Sort of the Graph
	public Vertex[] DFS(MyGraph G, Vertex s) {
		LinkedList<Vertex> top = new LinkedList<Vertex>();
		boolean[] marked = new boolean[G.vertices.size()];
		DFSRec(G, s, marked, top);
		for(Vertex v : G.vertices) {
			if(marked[G.vertices.indexOf(v)] == false) {
				DFSRec(G, v, marked, top);
			}
		}
		
		Vertex[] topsort = new Vertex[top.size()];
		for(int i = 0; i < topsort.length; i++) {
			topsort[i] = top.removeFirst();
		}
		return topsort;
	}
	public void DFSRec(MyGraph G, Vertex v, boolean[] marked, LinkedList<Vertex> top) {
		if(marked[G.vertices.indexOf(v)] == false) {
		top.addLast(v);
		marked[G.vertices.indexOf(v)] = true;
		for(Edge e : G.edges) {
			if(e.start.equals(v) && marked[G.vertices.indexOf(e.end)] == false) {
				DFSRec(G, e.end, marked, top);
			}
		}
		
		}
	}
	public Vertex[] DFSIterativ(MyGraph G, Vertex s) {
		Stack<Vertex> S = new Stack<Vertex>();
		boolean[] marked = new boolean[G.vertices.size()];
		LinkedList<Vertex> topSort = new LinkedList<Vertex>();
		S.push(s);
		topSort.addFirst(s);
		while(!S.empty()) {
			Vertex v = S.pop();
			if(!topSort.contains(v)) {
				topSort.addLast(v);
			}
			marked[G.vertices.indexOf(v)] = true;
			for(Edge e : G.edges) {
				if(e.start.equals(v) && marked[G.vertices.indexOf(e.end)] == false) {
					S.push(e.end);
				}
			}
		}
		Vertex[] topsort = new Vertex[topSort.size()];
		for(int i = 0; i < topsort.length; i++) {
			topsort[i] = topSort.removeFirst();
		}
		return topsort;
	}
	public static boolean isTopologicalSort(MyGraph G, Vertex[] topSort) {
		boolean[] marked = new boolean[G.vertices.size()];
		for(int i = 0; i < topSort.length; i++) {
			marked[G.vertices.indexOf(topSort[i])] = true;
			for(Edge e : G.edges) {
				if(e.end.equals(topSort[i]) && marked[G.vertices.indexOf(e.start)] == false) {
					System.out.println("Problem: "+ e.start +" is not marked "+e.end);
					return false;
				}
			}
		}
		for(int i = 0; i < marked.length; i++) {
			if(marked[i] == false) {
				return false;
			}
		}
		return true;
	}
	public static int[] Dijkstra(MyGraph G, Vertex s) {
		int[] minDis = new int[G.vertices.size()];
		PriorityQueue<Vertex> pQ = new PriorityQueue<Vertex>();
		s.disTo = 0;
		for(Vertex v : G.vertices) {
			pQ.add(v);
		}
		while(!pQ.isEmpty()) {
			Vertex v = pQ.remove();
			for(Edge e : G.edges) {
				if(e.start == v) {
					if(e.end.disTo > v.disTo + e.w) {
						pQ.remove(e.end);
						e.end.disTo = v.disTo + e.w;
						pQ.add(e.end);
					}
				}
			}
		}
		for(int i = 0; i < G.vertices.size(); i++) {
			minDis[i] = G.vertices.get(i).disTo; 
		}
		return minDis;
	}
}












