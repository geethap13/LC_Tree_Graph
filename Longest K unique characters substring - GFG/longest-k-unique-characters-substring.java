//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
       int start  =0,end = 0,counter = 0,len =0,n=s.length();
        int[] map = new int[128];
        while(end<n){
            char ch = s.charAt(end);
            if(map[ch] == 0) counter++;
            map[ch]++;
            end++;
            
            while(counter>k){
                char ch2 = s.charAt(start);
                map[ch2]--;
                if(map[ch2] ==0) counter--;
                start++;
            }
            // if(counter == k){
                len = Math.max(len,end-start);
            // }
        }
        return len == 0?-1:len;
    }
}