//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int N) {
        //code here
    
    int[][] dp = new int[N][N+1];
    for(int t=0;t<=N;t++){
        dp[0][t] = t*price[0];
    }
  for(int i=1;i<N;i++){
      for(int t=0;t<=N;t++){
          int notpick = dp[i-1][t];
          int pick =0;
          int rodLen = i+1;
          if(rodLen<=t){
              pick = price[i] + dp[i][t-rodLen]; 
          }
          dp[i][t] = Math.max(notpick,pick);
      }
  }
  
  return dp[N-1][N];
    }
}