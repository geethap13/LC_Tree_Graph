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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
     int mod = (int)(Math.pow(10,9)+7);
    public int perfectSumHelper(int index,int[] arr,int n,int sum,int[][] dp){
        
        
        if(index == n-1) {
            if(sum==0 && arr[index] == 0){
                return 2;
            }
            if(sum == 0||arr[index] == sum) 
            return 1;
            else return 0;
        }
        if(dp[index][sum]!=-1) return dp[index][sum];
        int notpick = perfectSumHelper(index+1,arr,n,sum,dp);
        int pick = 0;
        if(arr[index]<=sum)
         pick = perfectSumHelper(index+1,arr,n,sum-arr[index],dp);
        return dp[index][sum] = (notpick +pick)%mod;
    }
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int[][] dp = new int[n][sum+1];
	    
	    for(int row[]:dp)
	    Arrays.fill(row,-1);
	   int ans = perfectSumHelper(0,arr,n,sum,dp);
	   return ans;
	} 
}