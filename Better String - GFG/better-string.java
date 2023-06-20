//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();

            Solution obj = new Solution();
            String ans = obj.betterString(str1, str2);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int findDistSubcnt(String str){
        int n = str.length();
        int[] dp = new int[n+1];
        dp[0] = 1;//for empty string is a subsequence for any string
        Map<Character,Integer> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            dp[i] = 2*dp[i-1];
            char ch = str.charAt(i-1);
            if(map.containsKey(ch)){
                int lastOccur = map.get(ch);
                dp[i] = dp[i] - dp[lastOccur-1];
            }
            map.put(ch,i);
        }
        
        return dp[n];
    }
    public static String betterString(String str1, String str2) {
        // Code here
        int cnt1 = findDistSubcnt(str1);
        int cnt2 = findDistSubcnt(str2);
        if(cnt2>cnt1) return str2;
        else return str1;
    }
}