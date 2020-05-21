/**
 * Created with IntelliJ IDEA.
 * Description: 递增顺序查找树
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
    public TreeNode cur; // 由于cur 表示节点的前驱, 因此, cur是不听的在变化, 因此, 应将cur 定义成一个全局变量
    public void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left); // 遍历左子树
        root.left = null; // 无论哪个节点, 都需要将它的左树置为空
        cur.right = root; // cur 一定不能为空
        cur = cur.right;

        inorder(root.right); // 遍历右子树
    }
    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = new TreeNode(0);
        cur = head;
        inorder(root);
        return head.right;
    }
}
