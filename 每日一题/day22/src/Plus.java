/**
 * Created with IntelliJ IDEA.
 * Description: 链式 A+B
 *
 * 有两个用链表表示的整数, 每个结点包含一个数位.这些数位是反向存放的,也就是个位盘在链表的首部.
 * 编写函数对着两个整数求和, 并用量表形式返回结果.
 * 给定两个链表 ListNodeA, ListNodeB, 请返回 A + B 的结果
 * {1, 2, 3}, {3, 2, 1}
 * 返回{4, 4, 4}
 *
 * User: HHH.Y
 * Date: 2020-06-25
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Plus {
    public ListNode plusAB(ListNode a, ListNode b) {
        if(a == null && b == null) {
            return null;
        }
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        ListNode curA = a;
        ListNode curB = b;
        while (curA != null || curB != null) {
            if(curA != null && curB != null) {
                ListNode ret = new ListNode((curA.val + curB.val + carry) % 10);
                cur.next = ret;
                cur = cur.next;
                carry = (curA.val + curB.val + carry) / 10;
                curA = curA.next;
                curB = curB.next;
            } else if(curA != null) {
                ListNode ret = new ListNode((curA.val + carry) % 10);
                cur.next = ret;
                cur = cur.next;
                carry = (curA.val + carry) / 10;
                curA = curA.next;
            } else {
                ListNode ret = new ListNode((curB.val + carry) % 10);
                cur.next = ret;
                cur = cur.next;
                carry = (curB.val + carry) / 10;
                curB = curB.next;
            }
        }
        if(carry > 0) {
            cur.next = new ListNode(carry);
            cur = cur.next;
        }
        return head.next;
    }
}
