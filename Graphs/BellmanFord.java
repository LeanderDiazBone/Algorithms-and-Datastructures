package Graphs;

import java.util.Arrays;

public class BellmanFord {
	public static void main(String[] args) {
		int[][] Adlist = {{1,4,6},{2,3,8},{3},{5},{5},{},{},{},{7,9},{6}};
		int[][] w =      {{2,4,15},{1,3,4},{1},{3},{5},{},{},{},{6,5},{2}};
		int s = 0;
		int[] minDis = bellmanFord(s,Adlist,w);
		System.out.println(Arrays.toString(minDis));
	}
	public static int[] bellmanFord(int s, int[][] Adlist, int[][] w) {
		int[] pre = new int[Adlist.length];
		int[] minDis = new int[Adlist.length];
		for(int i = 0; i < Adlist.length; i++) {
			pre[i] = -1;
			minDis[i] = Integer.MAX_VALUE;
		}
		minDis[s] = 0;
		//Iterate exactly n-times
		for(int x = 0; x < Adlist.length; x++) {
			//Iterate through every Edge
			for(int i = 0; i < Adlist.length; i++) {
				for(int j = 0; j < Adlist[i].length; j++) {
					if(minDis[Adlist[i][j]] > (minDis[i] + w[i][j])) {
						minDis[Adlist[i][j]] = minDis[i] + w[i][j];
						pre[Adlist[i][j]] = i;
					}
				}
			}
		}
		return minDis;
	}
}
