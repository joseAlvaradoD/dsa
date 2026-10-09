package maximumDepthOfBinaryTree;

import utils.TreeNode;

public class Main {

    int max = 0;
    public int maxDepth(TreeNode root) {
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if(root == null) return 1;

        int l = dfs(root.left);
        int r = dfs(root.right);

        max = Math.max(l,r);
        return max + 1;
    }
}
