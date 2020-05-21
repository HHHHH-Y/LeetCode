/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-21
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
    // 由于 postIndex 需要进行变动, 因此不能定义成一个局部变量.
    public int postIndex = 0; // 用于遍历前序序列的节点
    public TreeNode buildTreeChild(int[] postorder, int[] inorder, int begin, int end) {
        if(begin > end) {
            return null;
        }
        // 创建根节点
        TreeNode root = new TreeNode(postorder[postIndex]);
        // 找到根节点在中序遍历中的位置
        int rootIndex = findIndexOfInorder(inorder, begin, end, postorder[postIndex]);
        // 找到根节点之后就可以将postIndex--
        postIndex--;
        if(rootIndex == -1) {
            return null;
        }
        // 创建右子树
        root.right = buildTreeChild(postorder,  inorder, rootIndex + 1, end);
        // 创建左子树
        root.left = buildTreeChild(postorder,  inorder, begin, rootIndex - 1);

        return root;
    }
    // 每次寻找的根节点的范围是不同的, 因此这里应该传入 begin 和 end
    public int findIndexOfInorder(int[] inorder, int begin, int end, int val) {
        for (int i = begin; i <= end; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 如果两个数组都为空, 就返回空
        if(postorder == null || inorder == null) {
            return null;
        }
        // 如果两个数组都开辟了空间, 但是里面却没有存放元素, 也返回空
        if(postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        postIndex = postorder.length - 1;
        return buildTreeChild(postorder, inorder, 0,inorder.length - 1);
    }
}
