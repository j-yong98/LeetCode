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
    List<Integer> nodes;
    public TreeNode balanceBST(TreeNode root) {
        nodes = new ArrayList<>();
        inOrder(root);
        return balanced(nodes, 0, nodes.size() - 1);
    }
    
    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        nodes.add(node.val);
        inOrder(node.right);
    }
    
    private TreeNode balanced(List<Integer> tree, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) >> 1;
        TreeNode node = new TreeNode(tree.get(mid));
        node.left = balanced(tree, l, mid - 1);
        node.right = balanced(tree, mid + 1, r);
        return node;
    }
}