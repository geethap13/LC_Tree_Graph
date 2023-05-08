class Pair{
    int row,col,steps;
    Pair(int _r,int _cl,int _st){
        row = _r;
        col = _cl;
        steps = _st;
    }
}
class Solution {
    int[][] del ={{-1,0},{0,1},{1,0},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] visited  = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i =0 ;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j,0));
                    visited[i][j] = 1;
                }
            }
        }
        int[][] dist = new int[m][n];
        while(!q.isEmpty()){
            Pair cur  = q.poll();
            int row = cur.row;
            int col = cur.col;
            int steps = cur.steps;
            dist[row][col] = steps;
            for(int[] i:del){
                 int adr = row + i[0];
                 int adcl = col + i[1];
                 if(adr<0||adr>=m||adcl<0||adcl>=n) continue;
                 if(visited[adr][adcl] == 0){
                     visited[adr][adcl] = 1;
                     q.add(new Pair(adr,adcl,steps+1));
                 }
            }
        }
        return dist;
    }
}