package Graphs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class TrainConnection {

	public static void main(String[] args) {
		MyGraph G = makeGraph();
		//int[] cost = Dijkstra(G);
		int[] cost = new int[G.vertices.size()];
		cost[0] = 0;
		cost[1] = 1;
		cost[2] = 3;
		cost[3] = 4;
		cost[4] = 6;
		cost[5] = 5;
		cost[6] = 6;
		cost[7] = 3;
		cost[8] = 7;
		cost[9] = 5;
		cost[10] = 8;
		int[] length = findLength(G, cost);
		System.out.println(Arrays.toString(cost));
		System.out.println(Arrays.toString(G.namesToArray()));
		System.out.println(Arrays.toString(length));

	}
	public static int[] findLength(MyGraph G, int[] c) {
		int[] length = new int[c.length];
		boolean[] found = new boolean[c.length];
		int[] d2 = new int[c.length];
		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		for(int i = 0; i < c.length; i++) {
			length[i] = Integer.MAX_VALUE;
			found[i] = false;
			d2[i] = Integer.MAX_VALUE;
		}
		length[0] = 0;
		found[0] = true;
		d2[0] = 0;
		int l = 1;
		int vL = 0;			//How many vertices are left
		int vLNR = 0;
		queue.addFirst(G.vertices.get(0));
		while(queue.size() != 0) {
			Vertex v = queue.removeLast();
			int i = G.vertices.indexOf(v);
			for(Edge e : G.edges) {
				if(e.start.name.equals(v.name)) {
					Vertex u = e.end;
					int j = G.vertices.indexOf(u);
					//System.out.println(i + " "+j);
					if(!found[j] && d2[j] > d2[i] + e.w) {
						d2[j] = d2[i] + e.w;
						if(d2[j] == c[j]) {
							length[j] = l;
							//System.out.println("pre: "+ v.city+" post: "+u.city+" "+ length[j]+ " cost "+d2[j]);
							found[j] = true;
							queue.addFirst(u);
							vLNR++;
							//System.out.println(u.city +" l: "+ l+ " vL: "+vL+ " vLNR: "+ vLNR);
							//System.out.println();
						}
					}
				}
			}
			if(vL != 0) {
				vL--;
			}else {
				l++;
				vL = vLNR-1;
				vLNR = 0;
				System.out.println("Change length "+ v.name);
				System.out.println();
			}
		}
		return length;
	}

	public static MyGraph makeGraph() {
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		ArrayList<Edge> edges = new ArrayList<Edge>();
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");
		Vertex g = new Vertex("g");
		Vertex h = new Vertex("h");
		Vertex i = new Vertex("i");
		Vertex j = new Vertex("j");
		Vertex k = new Vertex("k");
		Edge e1 = new Edge(a, b, 1);
		Edge e2 = new Edge(a, c, 6);
		Edge e3 = new Edge(a, d, 7);
		Edge e4 = new Edge(a, e, 8);
		Edge e5 = new Edge(b, c, 2);
		Edge e6 = new Edge(b, d, 3);
		Edge e7 = new Edge(b, f, 10);
		Edge e8 = new Edge(b, g, 6);
		Edge e9 = new Edge(b, h, 2);
		Edge e10 = new Edge(c, i, 4);
		Edge e11 = new Edge(c, j, 3);
		Edge e12 = new Edge(d, e, 2);
		Edge e13 = new Edge(d, i, 3);
		Edge e14 = new Edge(e, k, 2);
		Edge e15 = new Edge(f, g, 1);
		Edge e16 = new Edge(h, f, 2);
		Edge e17 = new Edge(h, j, 2);
		Edge e18 = new Edge(i, k, 1);
		Edge e19 = new Edge(j, k, 3);
		vertices.add(a);
		vertices.add(b);
		vertices.add(c);
		vertices.add(d);
		vertices.add(e);
		vertices.add(f);
		vertices.add(g);
		vertices.add(h);
		vertices.add(i);
		vertices.add(j);
		vertices.add(k);
		edges.add(e1);
		edges.add(e2);
		edges.add(e3);
		edges.add(e4);
		edges.add(e5);
		edges.add(e6);
		edges.add(e7);
		edges.add(e8);
		edges.add(e9);
		edges.add(e10);
		edges.add(e11);
		edges.add(e12);
		edges.add(e13);
		edges.add(e14);
		edges.add(e15);
		edges.add(e16);
		edges.add(e17);
		edges.add(e18);
		edges.add(e19);
		MyGraph G = new MyGraph(vertices, edges);
		return G;
	}
	
	public static int[] Dijkstra(MyGraph G) {	//schlechte DatenStruktur
		int[] d = new int[G.vertices.size()];
		Vertex[] pre = new Vertex[d.length];
		LinkedList<Vertex> minQueue = new LinkedList<Vertex>();
		for(int i = 0; i < d.length; i++) {
			d[i] = Integer.MAX_VALUE;
			pre[i] = null; 
		}
		d[0] = 0;
		addMinQueue(G, d, minQueue, G.vertices.get(0));
		while(minQueue.size() > 0) {
			System.out.println(minQueue.size());
			Vertex v = minQueue.removeFirst();
			int i = G.vertices.indexOf(v);
			for(Edge e : G.edges) {
				if(e.start.name.equals(v.name)) {
					Vertex u = e.end;
					int j = G.vertices.indexOf(u);
					if(pre[j] == null) {
						d[j] = d[i] + e.w;
						pre[j] = v;
						addMinQueue(G,d,minQueue, u);
					}else if(d[j] > d[i] + e.w){
						d[j] = d[i] + e.w;
						pre[j] = v;
					}
				}
			}
		}
		return d;
	}
	public static void addMinQueue(MyGraph G, int[] d, LinkedList<Vertex> minQueue, Vertex v) {
		if(minQueue.size() == 0) {
			minQueue.add(v);
		}else {
			for(int i = 0; i < minQueue.size(); i++) {
				int x = G.vertices.indexOf(v);
				int y = G.vertices.indexOf(minQueue.get(i));
				if(d[x] < d[y]) {
					minQueue.add(i, v);
					break;
				}else if(i == minQueue.size()-1) {
					minQueue.addLast(v);
				}
			}
		}
	}
	public static void decreaseKey(MyGraph G, int[] d, LinkedList<Vertex> minQueue, Vertex u) {
		minQueue.remove(u);
		addMinQueue(G,d,minQueue,u);
	}
}











