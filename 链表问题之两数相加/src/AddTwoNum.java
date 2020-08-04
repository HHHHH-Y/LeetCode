/**
 * Created with IntelliJ IDEA.
 * Description: 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入: 2 -> 4 -> 3    +    5 -> 6 -> 4
 * 输出: 7 -> 0 -> 8
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

public class AddTwoNum {
    public ListNode addTwoNumbers(ListNode headA, ListNode headB) {
        ListNode newHead = new ListNode(0);
        ListNode rear = newHead;
        int carry = 0; // carry 表示进位
        // 只要有一个链表不为空, 就可以进入循环中执行
        while (headA != null || headB != null) {
            int x = headA == null ? 0 : headA.val;  // 如果链表为空, 则返回 0
            int y = headB == null ? 0 : headB.val;
            int sum = x + y + carry;
            carry = sum / 10;
            int num = sum % 10;
            ListNode node = new ListNode(num);
            rear.next = node;
            rear = rear.next;
            if(headA != null) {
                headA = headA.next;
            }
            if(headB != null) {
                headB = headB.next;
            }
        }
        if(carry != 0) {
            rear.next = new ListNode(carry);
            rear = rear.next;
        }
        return newHead.next;
    }
}
