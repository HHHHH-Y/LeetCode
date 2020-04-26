import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 输出链表中倒数第 k 个节点
 * User: HHH.Y
 * Date: 2020-04-24
 */
 class ListNode {
     int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 1. 判断单链表是否为空, 若为空, 则没有倒数第k个节点
        // 2. 要对k进行合法性判断
        // 3. 定义两个引用, 一个先走k-1步
        //    然后两个引用一起走, 直到先走的引用到达最后一个节点为止
        if(k < 1) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
            if(fast == null) {
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
