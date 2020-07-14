import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 最近公共祖先
 * 有一棵无穷大的满二叉树, 其节点按根节点一层一层地从左往右依次编号
 * 根节点编号为 1. 现在有两个节点 a, b. 请设计一个算法, 求出 a 和 b 点的最近公共祖先的编号
 * 给定两个 int a, b. 为给定节点的编号.
 * 请返回 a 和 b 的最近公共祖先的编号. 注意这里节点本身也可认为是其祖先
 *
 * 思路:
 * 如果两个节点编号相同, 则该节点编号就为 最近公共祖先
 * 如果两个节点编号不同, 就让 较大的节点编号/2 (因为根节点的编号为 1), 直到两个节点的编号相同为止
 * User: HHH.Y
 * Date: 2020-07-14
 */
public class RecentCommonAncestor {
    public static int getLCA(int a, int b) {
        while (a != b) {
            if(a > b) {
                a = a / 2;
            } else {
                b = b / 2;
            }
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(getLCA(a, b));
    }
}
