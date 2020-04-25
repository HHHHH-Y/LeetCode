/**
 * Created with IntelliJ IDEA.
 * Description: 给定一个链表，返回链表开始入环的第一个节点. 如果链表无环，则返回 null
 * User: HHH.Y
 * Date: 2020-04-25
 */
class ListNode {
    int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
    }
}
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 1. 判断链表是否有环, 当链表有环是, 才可以寻找入环的第一个节点
        // 2. 链表有环时, 找到 从头节点到入环节点的长度 和 从相遇处到入环节点的长度的关系, 找到入环的节点
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                // 单链表中有环
                slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        // 单链表中无环
        return null;
    }
}
