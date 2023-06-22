//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int knapSackHelper(int i,int W,int[] val,int[] wt,int[][] dp){
        if(i == 0){
            return (W/wt[0])*val[0];
        }
        if(dp[i][W]!=-1) return dp[i][W];
        int notpick = knapSackHelper(i-1,W,val,wt,dp);
        int pick = 0;
        if(wt[i]<=W){
            pick = val[i]+ knapSackHelper(i,W-wt[i],val,wt,dp);
        }
        return dp[i][W] = Math.max(notpick,pick);
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int[][] dp = new int[N][W+1];
        for(int[] row:dp)
        Arrays.fill(row,-1);
      return  knapSackHelper(N-1,W,val,wt,dp);
    }
}