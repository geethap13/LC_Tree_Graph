//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


//Time Complexity: O(N+E),  N is the time taken and E is for traveling through adjacent nodes overall. 

//Space Complexity: O(N)
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean dfs(int node,int parent,int V,ArrayList<ArrayList<Integer>> adj,int[] visited){
        visited[node] = 1;
        for(Integer adjNode:adj.get(node)){
            if(visited[adjNode]==0){
                if(dfs(adjNode,node,V,adj,visited) == true) return true;
            }
            else if(parent!=adjNode) return true;
        }
        return false;
    }
    public boolean bfs(int i,int V,ArrayList<ArrayList<Integer>> adj,int[] visited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,-1});
        visited[i] =1;
        while(!q.isEmpty()){
            int[] pair = q.poll();
            int node = pair[0];
            int parent = pair[1];
            for(Integer adjNode:adj.get(node)){
                if(visited[adjNode] == 0){
                    q.add(new int[]{adjNode,node});
                    visited[adjNode]=1;
                }
                else if(parent !=adjNode) return true;
            }
            
        }
        return false;
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visited = new int[V];
        for(int i=0;i<V;i++){
            if(visited[i] == 0){
                // if(dfs(i,-1,V,adj,visited) == true) return true;
                if(bfs(i,V,adj,visited) == true) return true;
            }
        }
        return false;
    }
}