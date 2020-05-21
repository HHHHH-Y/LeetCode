/**
 * Created with IntelliJ IDEA.
 * Description: 递增顺序查找树
 * 给定树中的结点数介于 1 和 100 之间。
 *
 * 在中序遍历二叉树的时候, 修改二叉树的构造
 * 将其左树全部置为空
 * 使用 prev 引用表示一个节点的前驱, 通过它修改节点的右子树.
 * 还需要定义一个节点 head, 用来返回头节点的位置
 *
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
    public TreeNode prev; // 由于prev表示节点的前驱, 因此, prev是不听的在变化, 因此, 应将prev 定义成一个全局变量
    public void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left); // 遍历左子树
        root.left = null; // 无论哪个节点, 都需要将它的左树置为空
        prev.right = root; // cur 一定不能为空
        prev = prev.right;

        inorder(root.right); // 遍历右子树
    }
    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = new TreeNode(0);
        prev = head;
        inorder(root);
        return head.right;
    }
}
