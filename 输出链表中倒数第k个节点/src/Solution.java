import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 输出链表中倒数第 k 个节点
 * User: HHH.Y
 * Date: 2020-04-24
 */
 class ListNode {
     int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        // 判断k的位置是否合法
        ListNode cur = head;
        int size = 0;
        while(cur != null) {
            size += 1;
            cur = cur.next;
        }
        if(k < 1 || k > size) {
            return null;
        }
        int count = k - 1;
        while (fast.next != null) {
            while (count != 0) {
                fast = fast.next;
                count--;
            }
            if(fast.next == null) {
                return slow;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
