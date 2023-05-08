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

class Pair{
    int node;
    int parent;
    Pair(int _node,int _parent){
        node = _node;
        parent =_parent;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean dfs(int node,int[] visited,ArrayList<ArrayList<Integer>> adj,int parent){
        visited[node] = 1;
        for(int adjNode:adj.get(node)){
            if(visited[adjNode] == 0){
                if(dfs(adjNode,visited,adj,node) == true) return true;
            }
            else if(parent!=adjNode) return true;
        }
        return false;
    }
    public boolean bfs(int node,int[] visited,ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node,-1));
        while(!q.isEmpty()){
            Pair curnode = q.poll();
            for(int adjNode:adj.get(curnode.node)){
            if(visited[adjNode] == 0){
                q.add(new Pair(adjNode,curnode.node));
                visited[adjNode] = 1;
            }
            else if(curnode.parent!=adjNode) return true;
            }
        
        }
       
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visited = new int[V];
        for(int i=0;i<V;i++){
            if(visited[i] == 0){
                if(bfs(i,visited,adj) == true) return true;
            }
        }
        
        return false;
    }
}
