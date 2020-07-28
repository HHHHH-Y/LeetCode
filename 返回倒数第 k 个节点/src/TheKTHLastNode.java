/**
 * Created with IntelliJ IDEA.
 * Description: 返回倒数第 k 个节点
 *
 * 思路:
 * 定义两个节点cur, curNext, 分别指向头节点
 * 让 curNext 先走 k - 1 步, 然后两个节点一起走
 * 当 curNext 到达最后一个节点的时候, cur 就到达了倒数第 k 个节点了
 * User: HHH.Y
 * Date: 2020-07-28
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class TheKTHLastNode {
    public int kthToLast(ListNode head, int k) {
        ListNode cur = head;
        ListNode curNext = cur;
        for (int i = 0; i < k - 1; i++) {
            curNext = curNext.next;
        }
        while (curNext.next != null) {
            cur = cur.next;
            curNext = curNext.next;
        }
        return cur.val;
    }
}
