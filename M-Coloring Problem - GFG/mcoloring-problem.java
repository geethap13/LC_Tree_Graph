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
    
    //Time Complexity: O( N^M *N) (n raised to m)

    //Space Complexity: O(N)
    public boolean isValid(int node,int[] visited,int color,int n,boolean[][] graph, List<List<Integer>> adj){
        // for(int i=0;i<n;i++){
        //     if(i!=node && graph[node][i] == true && visited[i] == color) return false;
        // }
        for(Integer adjNode:adj.get(node)){
            if(adjNode!=node && visited[adjNode] == color) return false;
        }
        return true;
    }
    public boolean graphColoringHelper(int index,boolean graph[][],int m,int n,int[] visited, List<List<Integer>> adj){
        if(index == n){
            return true;
        }
        for(int i=1;i<=m;i++){
            if(isValid(index,visited,i,n,graph,adj)){
            visited[index] = i;
             if(graphColoringHelper(index+1,graph,m,n,visited,adj)) return true;
              visited[index] = 0;
            }
        }
        return false;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int[] visited = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(graph[i][j] == true){
                    adj.get(i).add(j);
                }
            }
        }
        if(graphColoringHelper(0,graph,m,n,visited,adj)) return true;
        return false;
    }
}