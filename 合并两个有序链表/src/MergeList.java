/**
 * Created with IntelliJ IDEA.
 * Description: 合并两个有序链表
 * 将两个升序链表合并成一个新的升序链表并返回
 * 输入: 1 -> 2 -> 4,   1 -> 3 -> 4
 * 输出: 1 -> 1 -> 2 -> 3 -. 4 -> 4
 * User: HHH.Y
 * Date: 2020-08-04
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeList {
    public ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode newHead = new ListNode(-1);
        ListNode rear = newHead;
        while (headA != null && headB != null) {
            if(headA.val <= headB.val) {
                rear.next = headA;
                rear = rear.next;
                headA = headA.next;
            } else {
                rear.next = headB;
                rear = rear.next;
                headB = headB.next;
            }
        }
        if(headA != null) {
            rear.next = headA;
        } else {
            rear.next = headB;
        }
        return newHead.next;
    }
}
