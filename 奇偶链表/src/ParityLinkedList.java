/**
 * Created with IntelliJ IDEA.
 * Description: 奇偶链表
 * 给定一个单链表, 把所有的奇数节点和偶数节点分别排在一起.
 * 请注意, 这里的奇数节点和偶数节点值得是节点编号的奇偶性, 而不是节点的值的奇偶性
 * 输入: 1 -> 2 -> 3 -> 4 -> 5 -> null
 * 输出: 1 -> 3 -> 5 -> 2 -> 4 -> null
 * 请使用原地算法完成. 空间复杂度为 O(1), 时间复杂度为 O(n)
 *
 * 使用了两个头指针 odds 和 even, 分别存放 节点编号为奇数的节点 和 节点编号为偶数的节点
 * 当遍历完所有节点之后, 连接奇数链表和偶数链表, 最后返回奇数链表的头结点即可
 * User: HHH.Y
 * Date: 2020-08-03
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() { }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ParityLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode odds = null;
        ListNode oddsRear = null;
        ListNode even = null;
        ListNode evenRear = null;
        int count = 0;
        while (cur != null) {
            count++;
            ListNode node = new ListNode(cur.val);
            if (count % 2 == 1) {
                // 如果是第一次插入
                if (odds == null) {
                    odds = node;
                    oddsRear = node;
                } else {
                    // 如果不是第一次插入
                    oddsRear.next = node;
                    oddsRear = oddsRear.next;
                }
            } else {
                if (even == null) {
                    even = node;
                    evenRear = node;
                } else {
                    evenRear.next = node;
                    evenRear = evenRear.next;
                }
            }
            cur = cur.next;
        }
        oddsRear.next = even;
        return odds;
    }
}
