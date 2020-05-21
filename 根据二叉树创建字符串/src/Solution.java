/**
 * Created with IntelliJ IDEA.
 * Description:  采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
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
    public void tree2strChild(TreeNode t, StringBuffer str) {
        if (t == null) {
            return;
        }
        // 前序遍历这棵二叉树
        str.append(t.val);
        // 遍历左子树
        if (t.left == null) {
            // 左右子树都为空, 就直接返回
            if (t.right == null) {
                return;
            } else {
                // 左子树为空, 右子树不为空
                str.append("()");
            }
        } else {
            str.append("(");
            tree2strChild(t.left, str);
            str.append(")");
        }
        // 遍历右子树
        if (t.right == null) {
            // 若左子树为空, 右子树不为空, 就返回null
            return;
        } else {
            str.append("(");
            tree2strChild(t.right, str);
            str.append(")");
        }
    }

    public String tree2str(TreeNode t) {
        StringBuffer str = new StringBuffer();
        tree2strChild(t, str);
        String ret = str.toString();
        return ret;
    }
}
