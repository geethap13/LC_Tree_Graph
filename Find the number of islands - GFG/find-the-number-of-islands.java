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
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    int[][] del = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
    public void dfs(int row,int col,char[][] grid,int[][] visited,int n ,int m){
        visited[row][col] = 1;
        for(int[] i:del){
            int nrow = row+i[0];
            int ncol = col+i[1];
            if(nrow<0||nrow>=n||ncol<0||ncol>=m)continue;
            if(grid[nrow][ncol] == '1'&&visited[nrow][ncol] == 0){
                dfs(nrow,ncol,grid,visited,n,m);
            }
        }
    }
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    res++;
                    dfs(i,j,grid,visited,n,m);
                }
            }
        }
        return res;
    }
}