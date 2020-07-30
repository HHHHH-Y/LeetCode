/**
 * Created with IntelliJ IDEA.
 * Description: 删除链表中倒数第 N 个节点
 * User: HHH.Y
 * Date: 2020-07-30
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        if(n == len) {
            // 如果删除的是头节点
            head = head.next;
        } else {
            // 如果删除的是中间节点
            ListNode prev = null; // 记录 slow 的前一个节点
            ListNode slow = head;
            ListNode fast = head;
            // 先让 fast 走 n - 1 步
            for (int i = 0; i < n - 1; i++) {
                fast = fast.next;
            }
            // 然后 fast, slow 一起走
            while (fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next;
            }
            // slow 所指的就是倒数第 n 个节点
            // 如果删除的是倒数第一个节点, 即删除的是最后一个节点
            if(n == 1) {
                prev.next = null;
            } else {
                prev.next = slow.next;
            }
        }
        return head;
    }
}
