package diameterOfBinaryTree;

import utils.TreeNode;

public class Main {

    static int maxDiameter;
    public static int diameterOfBinaryTree(TreeNode root) {
        maxDiameter=0;
        dts(root);
        return maxDiameter;
    }
    static int dts(TreeNode root){
        if(root == null) return 0;
        int l = dts(root.left);
        int r = dts(root.right);
        maxDiameter = Math.max(maxDiameter,(l+r));
        return Math.max(l,r)+1;
    }
}
