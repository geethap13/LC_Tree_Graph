class Solution {
    int[][] del = {{-1,0},{0,1},{1,0},{0,-1}};
    public void dfs(int i,int j ,int[][] grid,int m,int n){
      grid[i][j] = 0;
      //System.out.println(i+"j "+j);
      int sum = 1;
      for(int[] d:del){
          int r = i + d[0];
          int cl = j + d[1];
          if(r<0||r>=m||cl<0||cl>=n)continue;
          if(grid[r][cl] == 1) {
              dfs(r,cl,grid,m,n);
          }
      } 
    
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int num = 0;
       // int[][] visited = new int[m][n];
        for(int i=0;i<m;i++){
            if(grid[i][0] == 1 ) dfs(i,0,grid,m,n);
            if(grid[i][n-1] == 1 )dfs(i,n-1,grid,m,n);
        }
        for(int i=0;i<n;i++){
            if(grid[0][i] == 1 ) dfs(0,i,grid,m,n);
            if(grid[m-1][i] == 1) dfs(m-1,i,grid,m,n);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) num++;
            }
        }
        return num;
    }
}