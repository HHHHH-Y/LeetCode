/**
 * Created with IntelliJ IDEA.
 * Description: 设计一个单链表
 * User: HHH.Y
 * Date: 2020-07-30
 */
class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class MyLinkedList {
    // 定义一个头节点
    public ListNode head;

    // 初始化这个单链表
    public MyLinkedList() {
       this.head = null;
    }

    public int getSize() {
        ListNode cur = this.head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }
    // 获取链表中第 index 个节点的值, 如果索引无效, 则返回 -1
    public int get(int index) {
        int size = getSize();
        if(index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    // 头插法
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        if(this.head == null) {
            // 如果是第一次插入
            this.head = node;
            return;
        }
        // 如果不是第一次插入
        node.next = this.head;
        this.head = node;
    }

    // 尾插法
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if(this.head == null) {
            // 如果是第一次插入
            this.head = node;
            return;
        }
        // 如果不是第一次插入
        ListNode prev = this.head;
        // 找到最后一个节点
        while (prev.next != null) {
            prev = prev.next;
        }
        prev.next = node;
    }

    // 在链表的第 index 个节点之前添加值为 val 的节点.
    // 如果 index 等于链表的长度, 则该节点将附加到链表的末尾
    // 如果 index 大于链表的长度, 则不会插入节点. 如果 index 小于 0, 则在头部插入节点
    public void addAtIndex(int index, int val) {
        int size = getSize();
        if(index == size) {
            addAtTail(val);
            return;
        }
        if(index > size) {
            return;
        }
        if(index <= 0) {
            addAtHead(val);
            return;
        }
        ListNode node = new ListNode(val);
        ListNode prev = this.head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        node.next = prev.next;
        prev.next = node;
    }

    // 如果索引有效, 就删除链表中第 index 个节点
    // 如果 index < 0 || index >= size, 说明索引无效, 就返回
    // 如果 index = 0, 说明需要删除的是头节点
    // 找出要删除节点的前一个节点位置 pre
    // 如果 index = size - 1, 说明删除的是尾结点, 直接让 pre.next = null
    // 否则则是删除中间节点
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= getSize()) {
            return;
        }
        if(index == 0) {
            this.head = this.head.next;
        } else {
            ListNode prev = this.head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            if(index == getSize() - 1) {
                prev.next = null;
            } else if(index != getSize() - 1){
                prev.next = prev.next.next;
            }
        }
    }

    // 打印单链表
    public void print() {
        ListNode cur = this.head;
        while (cur!= null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
