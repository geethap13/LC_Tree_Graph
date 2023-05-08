class Disjoint{
    int[] parent;
    int[] size;
    Disjoint(int V){
        parent = new int[V];
        size = new int[V];
        for(int i=0;i<V;i++){
            parent[i] = i;
            size[i] =1;
        }
    }
    int findParent(int node){
        if(node == parent[node]) return node;
        parent[node] = findParent(parent[node]);
        return parent[node];
    }
    void unionBysize(int u,int v){
        int pu = findParent(u);
        int pv = findParent(v);
        if(u==v) return ;
        if(size[pu]>size[pv]){
            parent[pv] = pu;
            size[pu] = size[pu] + size[pv];
        }
        else{
             parent[pu] = pv;
            size[pv] = size[pu] + size[pv];
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Disjoint ds = new Disjoint(n);
        int res = n;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1){
                if(ds.findParent(i) == ds.findParent(j) ) continue;
                res--;
                ds.unionBysize(i,j);
                }
                
            }
        }
        return res;
    }
}