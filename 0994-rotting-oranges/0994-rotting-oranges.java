class Pair{
    int row;
    int col;
    Pair(int _r,int _cl){
        row = _r;
        col = _cl;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2) q.add(new Pair(i,j));
                if(grid[i][j] == 1) fresh++;
            }
        }
        int[][] del = {{-1,0},{0,1},{1,0},{0,-1}};
        int time = 0;
        while(!q.isEmpty()){
            int k = q.size();
            int fl = 0;
            while(k>0){
                Pair p = q.poll();
                int i = p.row;
                int j = p.col;
                for(int[] d:del){
                    int r = i+d[0];
                    int cl = j+d[1];
                    if(r<0||r>=m||cl<0||cl>=n) continue;
                    if(grid[r][cl] == 1){
                        grid[r][cl] = 2;
                        q.add(new Pair(r,cl));
                        fresh--;
                        fl = 1;
                    }
                }
                k--;
            }
            if(fl==1) time++;
        }
        return fresh>0?-1:time;
    }
}