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
    public static int findDistinctSubsequence(String S){
        int n = S.length();
        int[] dp = new int[n+1];
        dp[0]=1;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            dp[i] = dp[i-1]*2;
            char ch = S.charAt(i-1);
            if(map.containsKey(ch)){
                int last = map.get(ch);
                dp[i] = dp[i] - dp[last];
            }
            map.put(ch,i-1);
        }
        return dp[n]-1;
    }
    public static String betterString(String str1, String str2) {
        // Code here
        int st1 = findDistinctSubsequence(str1);
        int st2 = findDistinctSubsequence(str2);
        if(st1>=st2) return str1;
        return str2;
    }
}