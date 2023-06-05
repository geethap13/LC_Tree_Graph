//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    static int[][] del = {{1,0},{0,-1},{0,1},{-1,0}};
    public static void findPathHelper(int i,int j,int[][] m,int n,String path,ArrayList<String> ans,int[][] visited){
        // System.out.println(path);
        if(i == n-1 && j == n-1) {
            ans.add(new String(path));
            return;
        }
        String dir ="DLRU";
        for(int k=0;k<4;k++){
            int row = i+del[k][0];
            int col = j+del[k][1];
            if(row<0||row>=n ||col<0||col>=n) continue;
            if(visited[row][col] == 0 && m[row][col] ==1) {
                visited[row][col] = 1;
                findPathHelper(row,col,m,n,path+dir.charAt(k),ans,visited);
                visited[row][col] = 0;
            }
            
        }
        
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        int[][] visited = new int[n][n];
        visited[0][0] = 1;
        if(m[0][0]==1)
        findPathHelper(0,0,m,n,"",ans,visited);
        return ans;
    }
}