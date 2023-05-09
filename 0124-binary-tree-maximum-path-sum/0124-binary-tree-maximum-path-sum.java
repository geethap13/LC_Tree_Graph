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
class Solution {
    public int maxPathSumHelper(TreeNode root,int[] res){
        if(root == null) return Integer.MIN_VALUE ;
        int lefts = Math.max(0,maxPathSumHelper(root.left,res));
        int rights = Math.max(0,maxPathSumHelper(root.right,res));
        res[0] = Math.max(res[0],lefts+root.val+rights);
        return Math.max(lefts,rights)+root.val;

    }
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        maxPathSumHelper(root,res);
        return res[0];
    }
}