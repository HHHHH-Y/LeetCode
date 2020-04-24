/**
 * Created with IntelliJ IDEA.
 * Description: 给定一个带有头结点 head 的非空单链表，返回链表的中间结点.如果有两个中间结点，则返回第二个中间结点。
 * [1, 2, 3, 4, 5] --> 返回 3
 * [1, 2, 3, 4, 5, 6] --> 返回 4
 * User: HHH.Y
 * Date: 2020-04-24
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) { // 只有fast不为空的时候, 才可以进行fast.next的判断
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
