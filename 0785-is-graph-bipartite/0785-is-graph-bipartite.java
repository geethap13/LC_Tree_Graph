class Solution {
    public boolean dfs(int node,int[][] graph,int[] visited,int n,int color){
        visited[node] = color;
        int m = graph[node].length;
        for(int i= 0;i<m;i++){
            int adj = graph[node][i];
            if(visited[adj]== -1) {
                if(dfs(adj,graph,visited,n,1-color) == false) return false;
            }
            else if(visited[adj]== color){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        Arrays.fill(visited,-1);
        for(int i=0;i<n;i++){
            if( visited[i]== -1){
                 if(dfs(i,graph,visited,n,0) == false) return false;
            } 
        }
        return true;
    }
}