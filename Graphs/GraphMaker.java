package Graphs;

import java.util.ArrayList;

public class GraphMaker {
	public void makeG(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {
		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");
		Vertex v3 = new Vertex("v3");
		Vertex v4 = new Vertex("v4");
		Vertex v5 = new Vertex("v5");
		Vertex v6 = new Vertex("v6");
		Vertex v7 = new Vertex("v7");
		Vertex v8 = new Vertex("v8");
		Vertex v9 = new Vertex("v9");
		Vertex v10 = new Vertex("v10");
		Vertex v11 = new Vertex("v11");
		Vertex v12 = new Vertex("v12");
		Vertex v13 = new Vertex("v13");
		Edge e1 = new Edge(v1, v2, 10);
		Edge e2 = new Edge(v1, v11, 10);
		Edge e3 = new Edge(v2, v10, 10);
		Edge e4 = new Edge(v2, v8, 10);
		Edge e5 = new Edge(v3, v11, 10);
		Edge e6 = new Edge(v4, v12, 10);
		Edge e7 = new Edge(v5, v7, 10);
		Edge e8 = new Edge(v6, v13, 10);
		Edge e9 = new Edge(v7, v9, 10);
		Edge e10 = new Edge(v8, v10, 10);
		Edge e11 = new Edge(v9, v1, 10);
		Edge e12 = new Edge(v10, v6, 10);
		Edge e13 = new Edge(v10, v13, 10);
		Edge e14 = new Edge(v11, v3, 10);
		Edge e15 = new Edge(v12, v6, 10);
		Edge e16 = new Edge(v12, v5, 10);
		Edge e17 = new Edge(v13, v4, 10);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);
		vertices.add(v5);
		vertices.add(v6);
		vertices.add(v7);
		vertices.add(v8);
		vertices.add(v9);
		vertices.add(v10);
		vertices.add(v11);
		vertices.add(v12);
		vertices.add(v13);
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
	}
}
