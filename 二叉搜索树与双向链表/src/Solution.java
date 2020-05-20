
/**
 * Created with IntelliJ IDEA.
 * Description: 输入一个二叉搜索树, 将该二叉搜索树转化成一个排序的双向链表.
 *              要求不能创建任何新的节点, 只能调整树中节点指针的指向.
 *
 * 二叉搜索树: 当其不为空树时, 它左子树上的所有元素都小于根节点的元素,
 *            而根节点右子树上的节点元素都大于根节点的元素
 *
 *  将一棵二叉搜索树转换成一个排序的双向链表, 需要使用中序遍历
 *  在中序遍历的时候再修改树的结构
 * User: HHH.Y
 * Date: 2020-05-20
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {

    public TreeNode prev = null; // 用于表示pCur的前驱节点
    public void ConvertChild(TreeNode pCur) {
        // 进行中序排序
        if(pCur == null) {
            return;
        }
        // 遍历左子树
        ConvertChild(pCur.left);
        // 建立pCur的前驱节点
        pCur.left = prev;

        if(prev != null) {
            prev.right = pCur;
        }
        prev = pCur;

        // 遍历右子树
        ConvertChild(pCur.right);
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return null;
        }
        ConvertChild(pRootOfTree);
        TreeNode head = pRootOfTree;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }
}
