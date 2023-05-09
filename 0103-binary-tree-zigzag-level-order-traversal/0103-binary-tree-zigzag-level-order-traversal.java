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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean ltor = true;
        while(!q.isEmpty()){
            int k = q.size();
            List<Integer> sublist = new ArrayList<>();
            while(k>0){
                  TreeNode node = q.poll();
                  if(ltor) sublist.add(node.val);
                  else sublist.add(0,node.val);
                  if(node.left!=null) q.add(node.left);
                  if(node.right!=null) q.add(node.right);
                  k--;
            }
            ltor = !ltor;
            res.add(sublist);
        }
        return res;
    }
}