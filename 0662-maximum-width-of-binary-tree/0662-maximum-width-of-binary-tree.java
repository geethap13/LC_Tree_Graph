/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Pair{
     TreeNode node;
     int index;
     Pair(TreeNode _node,int _index){
        node = _node;
        index = _index;
     }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        int res = 0;
        while(!q.isEmpty()){
            int k = q.size();
            int left =0;
            int right = 0;
            int n = q.size();
            int curmin = q.peek().index;
            while(k>0){
                Pair p = q.poll();
                TreeNode node = p.node;
                int index = p.index-curmin;
                if(k == n) left = index;
                if(k == 1) right = index;
                if(node.left!=null){
                    q.add(new Pair(node.left,index*2+1));
                }
                if(node.right!=null){
                    q.add(new Pair(node.right,index*2+2));
                }
                k--;
            }
            res = Math.max(res,right-left+1);
        }
        return res;
    }
}