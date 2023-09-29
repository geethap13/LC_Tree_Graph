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
    public boolean isValid(int node,int color,boolean[][] graph,int nodelen,int[] visited){
        for(int adj=0;adj<nodelen;adj++){
            if(adj!=node && visited[adj] == color && 
            (graph[node][adj]==true || graph[adj][node] == true)) return false;
        }
         return true;
    }
    public boolean Helper(int ind,boolean[][] graph,int n,int m,int[] visited){
        if(ind==n) return true;
        for(int i=1;i<=m;i++){
            if(visited[ind] == 0 && isValid(ind,i,graph,n,visited)){
                visited[ind] = i;
                if( Helper(ind+1,graph,n,m,visited)) return true;
                 visited[ind] = 0;
            }
        }
        return false;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        
        int[] visited = new int[n];
       
        
           
           if( Helper(0,graph,n,m,visited)) return true;
        
        return false;
    }
}