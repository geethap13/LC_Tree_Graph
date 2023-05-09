/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution 
{
    static TreeNode<Integer> head = null;
    static TreeNode<Integer> prev = null;

    public static void inorderDLL(TreeNode<Integer> root ){
        if(root == null) return;
        inorderDLL(root.left);
        if(prev == null){
            head = root;
        }
        else{
            prev.right = root;
            root.left = prev;
            
            
        }
        prev = root;
        inorderDLL(root.right);
    }
    public static TreeNode<Integer> bstToSortedDLL(TreeNode<Integer> root) {
        // Write your code here.
        prev = null;
        head = null;
        inorderDLL(root);
        return head;
    }
}
