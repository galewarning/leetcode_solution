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
        TreeNode cur = root;
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if (cur == null) return res;
        s1.push(root);
        
        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            
            while (!s1.isEmpty()) {
                cur = s1.pop();
                tmp.add(cur.val);
                if (cur.left != null) s2.push(cur.left);
                if (cur.right != null) s2.push(cur.right);
            }
            if (!tmp.isEmpty()) res.add(tmp);
            
            tmp = new ArrayList<>();
            while (!s2.isEmpty()) {
                cur = s2.pop();
                tmp.add(cur.val);
                if (cur.right != null) s1.push(cur.right);
                if (cur.left != null) s1.push(cur.left);
            }
            if (!tmp.isEmpty()) res.add(tmp);
        }
        
        return res;
    }



    
}