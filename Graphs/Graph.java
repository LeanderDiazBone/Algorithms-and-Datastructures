package Graphs;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.lang.Math;


class Graph{
    public static void main(String[] args) {
      
        // Uncomment the following two lines if you want to read from a file
        //In.open("public/test1.in");
        //Out.compareTo("public/test1.out");

        int n = 10;     // number of vertices
        int m = 25;     // number of edges
        
        
        // The following two arrays stores the information of edges
        int[] edge_from_array = {0,6,7,5,6,5,9,0,9,9,0,4,6,5,6,5,4,6,4,1,0,7,2,6,4};
        int[] edge_to_array =   {1,7,3,2,5,4,3,3,1,2,8,7,9,8,0,7,2,3,1,8,4,1,8,2,8};
        // Read edges
        
        
        
        AcyclicGraph G = new AcyclicGraph(n, m, edge_from_array, edge_to_array);
        System.out.println(G.OrderedTriple(6, 9, 2));
        int[] topo = {6, 0, 9, 5, 4, 2 ,7, 1, 3, 8};
        System.out.println(G.IsTopologicalSort(topo));
      
    }

   
}

class AcyclicGraph{
  
  private int n;              // number of vertices
  private int m;              // number of edges
  private int[] out_degrees;  // out_degrees[i]: the out-degree of vertex i
  private int[][] out_edges;  // out_edges[i][j]: the j-th out_edge of vertex i
  private int[] in_degrees;
  private int[][] in_edges;
  
  
  AcyclicGraph(int n, int m, int[] edge_from_array, int[] edge_to_array)
  {
    
    this.n = n;
    this.m = m;
    
    
    out_degrees = new int[n];
    in_degrees = new int[n];
    
    for(int i=0;i<m;i++)
      out_degrees[edge_from_array[i]]++;
      
    for(int i=0;i<m;i++)
      in_degrees[edge_to_array[i]]++;
    
    System.out.println("Out Degree"+Arrays.toString(out_degrees));
    System.out.println("In Degree"+Arrays.toString(in_degrees));
    out_edges = new int[n][];
      
    for(int i=0; i < n ;i++)
    {
      if(out_degrees[i] != 0)
      {
        out_edges[i] = new int[out_degrees[i]];
        /*int counter  = 0;
        for(int j = 0; j < edge_from_array.length; j++) {
        	if(edge_from_array[j] == i) {
        		out_edges[i][counter] = edge_to_array[j];
        		counter++;
        	}
        }*/
        //out_degrees[i]=0;
      }
      else
      {
        out_edges[i]=null;
      }
    }
    in_edges = new int[n][];
    
    for(int i=0;i<n;i++)
    {
      if(in_degrees[i]!=0)
      {
        in_edges[i] = new int[in_degrees[i]];
       /* int counter  = 0;
        for(int j = 0; j < edge_to_array.length; j++) {
        	if(edge_to_array[j] == i) {
        		in_edges[i][counter] = edge_from_array[j];
        		counter++;
        	}
        }*/
        //in_degrees[i]=0;
      }
      else
      {
        in_edges[i]=null;
      }
    }
    //fill in and out edges
    int[] inc = new int[n];
    int[] ouc = new int[n];
    for(int j = 0; j < edge_from_array.length; j++) {
    	int from = edge_from_array[j];
    	int to = edge_to_array[j];
    	out_edges[from][ouc[from]] = to;
    	ouc[from]++;
    	in_edges[to][inc[to]] = from;
    	inc[to]++;
    }
   for(int i = 0; i < n; i++) {
    	System.out.println(Arrays.toString(out_edges[i]));
    }
    System.out.println();
    for(int i = 0; i < n; i++) {
    	System.out.println(Arrays.toString(in_edges[i]));
    }
    
  }
  
  public boolean OrderedTriple(int u, int v, int w)
  {
   if(Edgeexists(u,v) && Edgeexists(u,w) && Edgeexists(v,w)){
     
     return true;
   }else{
     return false;
   } 
  }
  public boolean Edgeexists(int u, int v){
    for(int i = 0; i < out_degrees[u]; i++){
      
      if(out_edges[u][i] == v){
        return true;
      }
    }
    return false;
  }
  
  public boolean Reachable(int u, int v)
  {
    // Please complete this method
	if(u == v) {
		return true;
	}else if(out_degrees[u] == 0) {
		return false;
	}
    for(int i = 0; i < out_degrees[u]; i++){
      int x = out_edges[u][i];
      	if(Reachable(x,v)) {
      		return true;
      	}
    }
    return false;
  }
  public boolean ReachableBreitensuche(int u, int v) {
	  boolean[] mar = new boolean[n];
	  ArrayList<Integer> q = new ArrayList<Integer>(); //Should act like a queue
	  mar[u] = true;
	  q.add(u);
	  while(q.size() > 0) {
		  int x = q.remove(q.size()-1);
		  for(int i = 0; i < out_degrees[x]; i++) {
			  int w = out_edges[x][i];
			  if(mar[w] == false) {
				  mar[w] = true;
				  q.add(0, w);
				  if(w == v) {
					  return true;
				  }
			  }
		  }
	  }
	  return false;
	  
	  
  }
  

  boolean[] marked_array;
  public boolean IsTopologicalSort(int sorted_array[])
  {
    // Please complete this method 
    //Methode aufrufen und einen Array mit in edges erstellen
    //Für jeden Vertex schauen im sorted Array, ob alle in voherigen Vertex schon markiert sind und wenn nicht false ausgeben und wenn ja für alle Edges aufrufen
	//System.out.println(Arrays.toString(sorted_array));
    marked_array = new boolean[n];
    
    int x = sorted_array[0];
    if(in_degrees[x] == 0){
      marked_array[sorted_array[0]] = true;
      for(int i = 1; i < sorted_array.length; i++){
        int z = sorted_array[i];
        if(Check(z)){
          //System.out.println("Checked "+z);
          marked_array[z] = true;
        }else{
          return false;
        }
      }
      return true;
    }else{
      return false;
    }
  }
  public boolean Check(int v){
	//System.out.println("Check "+ v);
    for(int i = 0; i < in_degrees[v]; i++){
    	int x = in_edges[v][i];
    	//System.out.println(v+" "+i+ " "+x+ " "+ in_degrees[v]);
      if(marked_array[x]){
    	  
      }else{
    	//System.out.println("Problem "+x+ " "+ marked_array[x]);
        return false;
      }
    }
    return true;
  }
  boolean[] mar;
  public boolean IsTopologicalSort2(int sorted_array[])
  {
    // Please complete this method 
    //Methode aufrufen und einen Array mit in edges erstellen
    //Für jeden Vertex schauen im sorted Array, ob alle in voherigen Vertex schon markiert sind und wenn nicht false ausgeben und wenn ja für alle Edges aufrufen
	//System.out.println(Arrays.toString(sorted_array));
    mar = new boolean[n];
    
    int x = sorted_array[0];
    if(in_degrees[x] == 0){
      mar[sorted_array[0]] = true;
      for(int i = 1; i < sorted_array.length; i++){
        int z = sorted_array[i];
        if(Check(z)){
          mar[z] = true;
        }else{
          return false;
        }
      }
      return true;
    }else{
      return false;
    }
  }
  
}