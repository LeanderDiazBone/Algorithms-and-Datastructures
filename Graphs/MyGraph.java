package Graphs;
import java.util.ArrayList;

public class MyGraph {
	ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	ArrayList<Edge> edges = new ArrayList<Edge>();
	int n;
	int m;
 	public MyGraph(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {
		this.vertices = vertices;
		this.edges = edges;
		this.n = vertices.size();
		this.m = edges.size();
	}
	public String[] namesToArray() {
		String[] names = new String[vertices.size()];
		for(int i = 0; i < vertices.size(); i++) {
			Vertex v = vertices.get(i);
			names[i] = v.name;
		}
		return names;
	}
	public void makeGraph() {
		GraphMaker maker = new GraphMaker();
		maker.makeG(vertices, edges);
	}
}

class Vertex implements Comparable{
	String name;
	int disTo;
	public Vertex(String name) {
		this.name = name;
		this.disTo = Integer.MAX_VALUE;
	}
	public String toString() {
		return name;
	}
	@Override
	public int compareTo(Object o) {
		Vertex v = (Vertex) o;
		if(this.disTo == v.disTo) {
			return 0;
		}else if(this.disTo < v.disTo){
			return 1;
		}else {
			return -1;
		}
	}
}

class Edge implements Comparable{
	Vertex start;
	Vertex end;
	int w;
	public Edge() {
		
	}
	public Edge(Vertex start, Vertex end, int w) {
		this.start = start;
		this.end = end;
		this.w = w;
	}
	public String toString() {
		String ed = "'"+start.toString() + " to " + end.toString() + " weight: "+ this.w + "'";	return ed;
	}
	
	@Override
	//returns 1 if this Edge has a greater weight then the Edge given as a parameter
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Edge e = (Edge) o;
		if(e.w == this.w) {
			return 0;
		}else if(this.w > e.w) {
			return 1;
		}else {
			return -1;
		}
	}
}

