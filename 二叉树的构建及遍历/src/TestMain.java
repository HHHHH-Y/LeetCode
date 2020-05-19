import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 二叉树的构建及遍历
 * 通过前序序列构建一棵二叉树并使用中序遍历的方式将其遍历出来
 * User: HHH.Y
 * Date: 2020-05-19
 */
class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}
public class TestMain {
    public static int i = 0; // i是用来遍历字符串的
    public static Node buildTree(String str) {
        Node root = null; // 创建一个根节点
        if(str.charAt(i) != '#') {
            // 1. 字符串的第一个字符一定就是根节点
            // 构建根节点
            root = new Node(str.charAt(i));
            i++;
            // 构建左子树
            root.left = buildTree(str);
            // 构建右子树
            root.right = buildTree(str);
        } else {
            // 如果遇到 #, 就应该让 i 继续走, 直到走到不为 # 为止
            i++;
        }
        return root;
    }

    public static void inOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Node root = buildTree(str);
        inOrderTraversal(root);
    }
}
