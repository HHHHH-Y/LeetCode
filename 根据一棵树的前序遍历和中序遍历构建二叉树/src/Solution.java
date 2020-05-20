/**
 * Created with IntelliJ IDEA.
 * Description: 通过前序序列和中序序列构建一棵二叉树
 * User: HHH.Y
 * Date: 2020-05-20
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    public int preIndex = 0;
    public TreeNode buildTreeChild(int[] preorder, int[] inorder, int begin, int end) {
        if(begin > end) { // 没有节点了
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]); // 创建一个根节点
        int rootIndex = findRootIndex(inorder, begin, end, preorder[preIndex]); // 找到根节点
        preIndex++;
        if(rootIndex == -1) {
            return null;
        }
        // 遍历左子树
        root.left = buildTreeChild(preorder,  inorder, begin, rootIndex - 1);
        // 遍历右子树
        root.right = buildTreeChild(preorder,  inorder, rootIndex + 1, end);
        return root;
    }

    // 寻找preIndex在中序序列中对应的位置
    public int findRootIndex(int[] inorder, int begin, int end, int val) {
        for (int i = begin; i <= end ; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) {
            return null;
        }
        if(preorder.length <= 0 || inorder.length <= 0) {
            return null;
        }
        return buildTreeChild(preorder, inorder, 0, inorder.length - 1);
    }
}
