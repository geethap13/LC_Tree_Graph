//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int totalSum = 0;
		
		for(int i =0;i<n;i++){
			totalSum +=arr[i];
		}
		int ans = Integer.MAX_VALUE;
		// boolean[][] dp = new boolean[n][totalSum+1];
		boolean[] prev= new boolean[totalSum+1];
		prev[0] = true;
		// for(int i=0;i<n;i++){
		// 	dp[i][0] = true;
		// }
		if(arr[0]<=totalSum) prev[arr[0]] = true;
		for(int i=1;i<n;i++){
			boolean[] cur = new boolean[totalSum+1];
			cur[0] = true;
			for(int t=1;t<=totalSum;t++){
				boolean notpick = prev[t];
				boolean pick = false;
				if(arr[i]<=t) pick = prev[t-arr[i]];
				cur[t] = pick || notpick;
			}
			prev = cur;
		}
		for(int t=0;t<=totalSum;t++){
			boolean exist = prev[t];
			if(exist){
				int s2 = totalSum - t;
				ans = Math.min(ans,Math.abs(t-s2));
			}
		}
		return ans;
	} 
}
