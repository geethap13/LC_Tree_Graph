//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{
    // public static Node buildTree(int inorder[], int preorder[], int n)
    // {
    //     // code here 
    // }
        public static Node buildTreeHelper(int[] preorder,int[] inorder,int prest,int preend,int inst,int inend,Map<Integer,Integer> map){
        if(prest>preend || inst>inend) return null;
        Node newNode = new Node(preorder[prest]);
        // int index = map.get(newNode.data);
        int index   = -1;
        for(int i=inst;i<=inend;i++){
            if(inorder[i] == newNode.data){
                index = i;
                break;
            }
        }
        int numLeft = index-inst+1;

        newNode.left = buildTreeHelper(preorder,inorder,prest+1,prest+numLeft-1,inst,index-1,map);
        newNode.right = buildTreeHelper(preorder,inorder,prest+numLeft,preend,index+1,inend,map);
        return newNode;
    }
    public static Node buildTree(int inorder[], int preorder[], int n){
        // int n = preorder.length;
        // int m = inorder.length;
        Map<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<n;i++){
        //     map.put(inorder[i],i);
        // }
        return buildTreeHelper(preorder,inorder,0,n-1,0,n-1,map);
    }
}
