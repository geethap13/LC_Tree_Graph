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
     int level;
     int hdist;
     Pair(TreeNode _node,int _level,int _hd){
         node = _node;
         level = _level;
         hdist = _hd;
     }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Map<Integer,Map<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode node = p.node;
            int keyhd = p.hdist;
            int keylevel = p.level;
            if(!map.containsKey(keyhd)){
                map.put(keyhd,new TreeMap<>());
            }
             if(!map.get(keyhd).containsKey(keylevel)){
                map.get(keyhd).put(keylevel,new PriorityQueue<>());
            }
            map.get(keyhd).get(keylevel).add(node.val);

            if(node.left != null) q.add(new Pair(node.left,keylevel+1,keyhd-1));
            if(node.right != null) q.add(new Pair(node.right,keylevel+1,keyhd+1));
        }

        for(Map<Integer,PriorityQueue<Integer>> level:map.values()){
            List<Integer> sublist = new ArrayList<>();
            for(PriorityQueue<Integer> pq:level.values()){
                while(!pq.isEmpty()){
                    sublist.add(pq.poll());
                }
            }
            res.add(sublist);
        }
        return res;
    }
}