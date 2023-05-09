class Solution {
    int[] dr = {-1,0,1,0};
    int[] dc ={0,1,0,-1};
    public void dfs(int i,int j,char[][] board,int m ,int n){
        board[i][j] = 'T';
        for(int k=0;k<4;k++){
            int r = i+dr[k];
            int cl = j+dc[k];
            if(r<0||r>=m||cl<0||cl>=n) continue;
            if(board[r][cl] == 'O') dfs(r,cl,board,m,n);
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];
        for(int i=0;i<m;i++){
            if(board[i][0] == 'O')dfs(i,0,board,m,n);
            if(board[i][n-1] == 'O')dfs(i,n-1,board,m,n);
        }
        for(int i=0;i<n;i++){
            if(board[0][i] == 'O')dfs(0,i,board,m,n);
            if(board[m-1][i] == 'O')dfs(m-1,i,board,m,n);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }
}