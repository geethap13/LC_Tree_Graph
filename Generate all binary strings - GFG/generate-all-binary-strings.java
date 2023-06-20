//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static void generateBinaryStringsHelper(int n,String s,List<String> ans){
      if(s.length()==n){
          ans.add(new String(s));
          return;
      }
      generateBinaryStringsHelper(n,s+"0",ans);
      if(s.length() == 0 || s.charAt(s.length()-1) == '0'){
          generateBinaryStringsHelper(n,s+"1",ans);
      }
  }
  public static List<String> generateBinaryStrings(int n) {
    // code here
    List<String> ans = new ArrayList<>();
    generateBinaryStringsHelper(n,"",ans);
    return ans;

  }
}
     
     