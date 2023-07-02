//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int node;
    int dist;
    Pair(int node,int dist){
        this.node =  node;
        this.dist = dist;
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    for(int i=0;i<V;i++)
	     adj.add(new ArrayList<>());
	     for(int i=0;i<edges.length;i++){
	         int u = edges[i][0];
	         int v = edges[i][1];
	         int wt = edges[i][2];
	         adj.get(u).add(new Pair(v,wt));
	          adj.get(v).add(new Pair(u,wt));
	     }
	    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.dist - b.dist);
	    pq.add(new Pair(0,0));
	    int sum = 0;
	    int[] visited = new int[V];
	    while(!pq.isEmpty()){
	        Pair t = pq.poll();
	        int cnode = t.node;
	        int cdist = t.dist;
	        if(visited[cnode] == 1) continue;
	        visited[cnode] =1;
	        sum +=cdist;
	       for(Pair adjNodes:adj.get(cnode)){
	           if(visited[adjNodes.node] == 0){
	               pq.add(new Pair(adjNodes.node,adjNodes.dist));
	               //visited[adjNodes.node] =1;
	           }
	       }
	    }
	    return sum;
	}
}