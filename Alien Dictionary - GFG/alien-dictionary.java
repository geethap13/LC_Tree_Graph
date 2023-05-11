//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String toposortBfs(int K,ArrayList<ArrayList<Integer>> adj){
        String ans = "";
        int[] indegree = new int[K];
        for(int i=0;i<K;i++){
        for(int j=0;j<adj.get(i).size();j++){
            indegree[adj.get(i).get(j)]++;
        }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<K;i++){
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            ans += (char)(node + (int)('a'));
            for(int adjnode:adj.get(node)){
                indegree[adjnode]--;
                if(indegree[adjnode] == 0) q.add(adjnode);
            }
        }
        return ans;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,int[] visited,int node,Stack<Integer> st){
        visited[node] = 1;
        for(int adjnode:adj.get(node)){
            if(visited[adjnode]==0) dfs(adj,visited,adjnode,st);
        }
        st.add(node);
    }
    public String toposortdfs(int K,ArrayList<ArrayList<Integer>> adj){
        int[] visited = new int[K];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<K;i++){
            if(visited[i]==0){
                dfs(adj,visited,i,st);
            }
        }
        String ans = "";
        while(!st.isEmpty()){
            ans += (char)(st.pop() +(int)'a');
        }
        return ans;
    }
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        int len = dict.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<len-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int minLen = Math.min(s1.length(),s2.length());
            for(int j=0;j<minLen;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        //toposortBfs(K,adj);
        return toposortdfs(K,adj);
    }
}