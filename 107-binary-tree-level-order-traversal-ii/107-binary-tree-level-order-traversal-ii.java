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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Deque<TreeNode> dq = new LinkedList<>(); 
        
        if (root == null) return res;
        dq.offer(root);
        
        while (!dq.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int levelSize = dq.size();
            for (int i = 0; i < levelSize; i++) {
                if (dq.peek().left != null) dq.offer(dq.peek().left);
                if (dq.peek().right != null) dq.offer(dq.peek().right);
                level.add(dq.poll().val);
            }
            res.add(0, level);
        }
        
        return res;
    }
}