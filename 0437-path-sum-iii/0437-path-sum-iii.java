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
public class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        // Map to store prefix sums and their counts
        HashMap<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);  // Base case: one way to have sum 0

        return dfs(root, 0, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, HashMap<Long, Integer> prefixSumCount) {
        if (node == null) return 0;

        currentSum += node.val;
        // Number of paths ending at current node with sum = targetSum
        int res = prefixSumCount.getOrDefault(currentSum - targetSum, 0);

        // Add current sum to map
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        // Continue search in left and right children
        res += dfs(node.left, currentSum, targetSum, prefixSumCount);
        res += dfs(node.right, currentSum, targetSum, prefixSumCount);

        // Remove current sum from map to backtrack
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

        return res;
    }
}

