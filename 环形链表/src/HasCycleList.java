/**
 * Created with IntelliJ IDEA.
 * Description: 环形链表
 * 给定一个链表, 判断链表中是否有环
 * 为了表示给定链表中的环, 我们使用整数 pos 来表示链表尾连接到链表中的位置(索引从 0 开始), 如果 pos = -1, 说明链表中没有环
 *
 * 思路:
 * 定义两个引用, slow 和 fast, 一个走一步, 一个走两步
 * 如果链表中没有环的话, 快引用(fast)一定会先走到 null
 * 如果链表中有环, 则两个引用在走完一步和两步之后一定会相遇 (slow = fast)
 *
 * 注意:
 * 条件判定的时候, 一定要是 fast != null 在前, fast.next != null 在后, 否则可能会发生空指针异常
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
public class HasCycleList {
    public boolean hasCycle(ListNode head) {
        // 1. 定义两个快慢引用, 一个走一步, 一个走两步
        ListNode slow = head;
        ListNode fast = head;
        // 2. 如果在走的时候, 快引用能够指向 null, 说明链表中没有环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // 如果没有指向 null, 且最终两个引用相遇了, 则说明有环
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}
