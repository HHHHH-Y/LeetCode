/**
 * Created with IntelliJ IDEA.
 * Description: 判断有无环
 * User: HHH.Y
 * Date: 2020-09-01
 */
class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}
public class JudgeHaveLoop {
    public boolean hasCycle(ListNode head) {
        // 定义两个引用, 一个走一步, 一个走两步
        ListNode fast = head;
        ListNode slow = head;
        // 如果链表中出现 null, 则说明链表无环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
}
