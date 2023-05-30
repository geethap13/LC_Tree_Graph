//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int n, int arr[], int k){
        // code here
         boolean[] prev = new boolean[k+1];
        prev[0] = true;
        
        if(arr[0]<=k)prev[arr[0]] = true;
        for(int i=1;i<n;i++){
            boolean[] cur = new boolean[k+1];
            cur[0] = true;
            for(int t =0;t<=k;t++){
                
                boolean notpick = prev[t];
                boolean pick = false;
                if(arr[i]<=t) pick = prev[t-arr[i]];
                cur[t] = pick || notpick;
            }
            prev = cur;
        }
        return prev[k];
    }
}