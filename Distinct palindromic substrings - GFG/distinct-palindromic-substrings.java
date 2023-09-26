//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String str = read.readLine().trim(); 
            Solution obj = new Solution();
            int ans = obj.palindromeSubStrs(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    int palindromeSubStrs(String s) { 
        // code here      
         int n = s.length();
        if(n<2) return n;
        
       
        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            int left = i,right =i;
            
            while(left>=0 && right<n && s.charAt(left) == s.charAt(right)){
                set.add(s.substring(left,right+1));
                left--;
                right++;
            }
            left = i;right =i+1;
            while(left>=0 && right<n && s.charAt(left) == s.charAt(right)){
                set.add(s.substring(left,right+1));
                left--;
                right++;
            }

        }
        return set.size();
    }
} 