/**
 * Created with IntelliJ IDEA.
 * Description: 合并两个有序链表
 * 将两个升序链表合并为一个新的升序链表并返回
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * User: HHH.Y
 * Date: 2020-04-26
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        // 1. 创建一个新的头节点, 用来接收新的单链表
        // 2. 比较两个链表的节点的值, 从小到大将节点拼接到新的链表上
        // 3. 如果其中一个单链表已经拼接完了, 直接将另一个单链表剩余部分全部拼接上即可
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (headA != null && headB != null) {
            if(headA.val < headB.val) {
                tmp.next = headA;
                tmp = tmp.next;
                headA = headA.next;
            } else {
                tmp.next = headB;
                tmp = tmp.next;
                headB = headB.next;
            }
        }
        if(headA == null) {
            tmp.next = headB;
        } else {
            tmp.next = headA;
        }
        return newHead.next;
    }
}
