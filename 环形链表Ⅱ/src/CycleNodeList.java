/**
 * Created with IntelliJ IDEA.
 * Description: 给定一个链表, 返回链表开始入环的第一个节点, 如果链表无环, 则返回 null
 *
 * 思路:
 * 返回链表开始入环的第一个节点 的前提是: 链表得有环
 * 当判断出链表有环后, 再让其中一个指针指向头结点处
 * 然后两个指针一起走, 在什么地方相遇, 什么地方就是入环的地方
 * User: HHH.Y
 * Date: 2020-07-30
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class CycleNodeList {
    public ListNode detectCycle(ListNode head) {
        // 判断链表是否有环
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                // 说明链表有环
                // 让其中一个指针指向头节点, 然后两个指针一起走, 在哪里相遇, 哪里就是入环的第一个节点
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                // 说明两个指针走到了入环的节点处
                return slow;
            }
        }
        // 说明链表没有环
        return null;
    }
}
