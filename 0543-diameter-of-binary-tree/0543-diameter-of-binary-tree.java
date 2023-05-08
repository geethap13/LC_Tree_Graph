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
    int h;
    int res;
    Pair(int _h,int _res){
        h = _h;
        res = _res;
    }
}
class Solution {
    
  public int diameterOfBinaryTreeHelper(TreeNode root,int[] res) {
      if(root == null) return 0;
      int left = diameterOfBinaryTreeHelper(root.left,res);
      int right = diameterOfBinaryTreeHelper(root.right,res);
      int height = Math.max(left,right)+1;
      res[0] = Math.max(res[0],left+right);
      return height;
  }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int[] res = new int[1];
         diameterOfBinaryTreeHelper(root,res);
         return res[0];
    }
}