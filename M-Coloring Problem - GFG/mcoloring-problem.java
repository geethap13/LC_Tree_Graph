//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean isValid(int node,int[] visited,List<List<Integer>> adj,int color){
        for(int adjNode:adj.get(node)){
            if(visited[adjNode] == color) return false;
        }
        return true;
    }
    public boolean graphColoringHelper(int node,List<List<Integer>> adj,int m,int[] visited,int n){
        if(node == n){
            return true;
        }
        for(int i=1;i<=m;i++){
            if(visited[node] == 0 && isValid(node,visited,adj,i)){
                visited[node] = i;
                if(graphColoringHelper(node+1,adj,m,visited,n)) return true;
                visited[node] = 0;
            }
        }
        return false;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> sublist  = new ArrayList<>();
            for(int j=0;j<n;j++){
                if(graph[i][j]==true){
                    sublist.add(j);
                }
            }
            adj.add(sublist);
        }
        // for(int i=0;i<n;i++){
        //     adj.add(new ArrayList<>());
        // }
        // for(int i=0;i<graph.length;i++){
        //     int u = graph[i][0];
        //     int v = graph[i][1];
        //     adj.get(u).add(v);
        //     adj.get(v).add(u);
        // }
        
        int[] visited = new int[n];
        
        if(graphColoringHelper(0,adj,m,visited,n)) return true;
        return false;
    }
}