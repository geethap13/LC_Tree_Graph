class Solution {
    int[] dr = {-1,0,1,0};
    int[] dcl ={0,1,0,-1};
    public void dfs(int i,int j,char[][] grid,int[][] visited,int m ,int n){
      visited[i][j] = 1;
      for(int k=0;k<4;k++){
          int r = i + dr[k];
          int cl = j + dcl[k];
          if(r<0||r>=m||cl<0||cl>=n) continue;
          if(grid[r][cl] == '1' && visited[r][cl] == 0) dfs(r,cl,grid,visited,m,n);
      }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int num= 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    num++;
                    dfs(i,j,grid,visited,m,n);
                }
            }
        }
        return num;
    }
}