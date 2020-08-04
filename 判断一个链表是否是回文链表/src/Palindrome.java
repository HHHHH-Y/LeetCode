/**
 * Created with IntelliJ IDEA.
 * Description: 回文链表
 * 判断一个链表是否是回文链表
 *
 * 思路:
 * 1. 找到链表中的中间节点位置
 * 2. 对链表的后半段进行反转
 * 3. 反转之后, 找两个指针, 一个从前向后走, 一个从后向前走
 * 4. 在向中间走的时候, 只要两个节点的值不相同, 就不是回文链表
 * 5. 如果链表有偶数个节点, 那么结束条件是 前面节点.next = 后面节点
 * 6. 否则, 当两个节点相遇, 说明就是回文链表
 * User: HHH.Y
 * Date: 2020-08-04
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
     }
}
public class Palindrome {
    public boolean isPalindrome(ListNode head) {
        // 1. 空链表也是回文链表
        if(head == null) {
            return true;
        }

        // 2. 如果链表中只有一个节点, 也是回文链表
        if(head.next == null) {
            return true;
        }

        // 3. 先将链表的后半段反转
        // 3.1 找到链表的中间节点(使用快慢指针)
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow 一定指向中间节点
        // 3.2 反转后半段的链表
        ListNode pre = slow;
        ListNode cur = slow.next; // 当前需要反转的节点
        while (cur != null) {
            // 只有 cur != null 的时候, 才会有 curNext 的存在
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        // prev 所在的位置就是最后一个节点的位置

        // 两个引用, 一个从前走, 一个从后走
        cur = pre;
        while (head != cur) {
            // 只要有一个节点不同, 就不是回文链表
            if(head.val != cur.val) {
                return false;
            }
            // 如果链表中有偶数个节点
            if(head.next == cur) {
                return true;
            }
            head = head.next;
            cur = cur.next;
        }
        // 当两个节点相遇, 说明是回文节点
        return true;
    }
}
