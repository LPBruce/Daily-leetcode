### 题目
**难度**：简单
详细内容见：[path-sum](https://leetcode-cn.com/problems/path-sum/submissions/)


### 题解
DFS

**需要注意的是，数据有可能是负数，所以最好不要通过累加数据来判断大小，直接判断等于即可。因为尝试通过判断大小来剪枝，结果报错**

```java
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, targetSum);
    }

    boolean dfs(TreeNode root, int num) {
        if (root.left == null && root.right == null) {
            return (num - root.val) == 0;
        }
        if (root.left != null && dfs(root.left,num - root.val)) {
            return true;
        }
        return root.right != null && dfs(root.right, num - root.val);
    }
}

```

另一种写法
```java
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        if (root == null) {
            return false;
        }
        return  DFS(root, sum, targetSum);
    }

    boolean DFS(TreeNode node, int sum, int targetSum) {
        sum += node.val;
        if (node.left == null && node.right == null) {
            return sum == targetSum;
        }
        if (node.left != null && DFS(node.left, sum, targetSum)) {
            return true;
        }
        return node.right != null && DFS(node.right, sum, targetSum);
    }
}
```