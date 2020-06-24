/**
 * Created with IntelliJ IDEA.
 * Description: 链表分割
 * 编写代码, 以给定值 x 为基准将链表分割成两部分, 所有小于 x 的节点排在大于或等于 x 的节点之前
 * 给定一个链表的头指针 ListNode * pHead, 请返回重新排列后的链表的头指针.
 * 注意: 分割以后保持原来的数据顺序不变
 * User: HHH.Y
 * Date: 2020-06-24
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        while (pHead != null) {
            if(pHead.val < x) {
                if(bs == null) {
                    bs = pHead;
                    be = pHead;
                } else {
                    be.next = pHead;
                    be = be.next;
                }
            } else {
                if(as == null) {
                    as = pHead;
                    ae = pHead;
                } else {
                    ae.next = pHead;
                    ae = ae.next;
                }
            }
            pHead = pHead.next;
        }
        if(bs == null) {
            return as;
        }
        be.next = as;
        if(ae != null) {
            ae.next = null;
        }
        return ae;
    }
}
