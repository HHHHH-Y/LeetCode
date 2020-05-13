/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-13
 */
class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class MyLinkedList {
    public Node head;

    // 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    public void addAtHead(int val) {
        Node node = new Node(val);
        // 1. 如果单链表为空, 就直接插入
        if(this.head == null) {
            this.head = node;
            return;
        }
        // 2. 如果不是第一次插入, 直接插到头节点之前
        node.next = this.head;
        this.head = node;
    }

    public int size() {
        int count = 0;
        Node cur = this.head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    // 获取链表中第 index 个节点的值。如果索引无效，则返回-1
    public int get(int index) {
        // 1. 判断index是否合法
        if(index < 0 || index >= size()) {
            return -1;
        }
        Node cur = this.head;
        // 找第几个下标的元素, 就让cur走几步
        for (int i = index; i > 0; i--) {
            cur = cur.next;
        }
        return cur.val;
    }

    // 将值为 val 的节点追加到链表的最后一个元素。
    public void addAtTail(int val) {
        Node node = new Node(val);
        Node cur = this.head;
        // 如果是第一次插入, 链表为空, 就直接插入即可
        if(this.head == null) {
            this.head = node;
            return;
        }
        // 如果链表不为空, 先找到最后一个节点, 再进行插入
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    // 在链表中的第 index 个节点之前添加值为 val 的节点。
    // 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
    // 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
    public void addAtIndex(int index, int val) {
        if(index == size()) {
            // 1. 如果index等于链表的长度, 就将其插到链表的末尾
            addAtTail(val);
            return;
        }
        if(index <= 0) {
            // 2. 如果index小于0, 就将其插在头部
            addAtHead(val);
            return;
        }
        if(index > size()) {
            return;
        }
        // 先找到index节点的前一个节点
        Node node = new Node(val);
        Node cur = this.head;
        for (int i = index - 1; i > 0; i--) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
    }

    // 如果索引 index 有效，则删除链表中的第 index 个节点。
    public void deleteAtIndex(int index) {
        // 1. 判断index是否有效
        if(index < 0 || index >= size()) {
            return;
        }
        if(index == 0) {
            this.head = this.head.next;
        } else {
            Node cur = this.head;
            for (int i = index - 1; i > 0; i--) {
                cur = cur.next;
            }
            if(index != size() - 1) {
                cur.next = cur.next.next;
            } else if(index == size() - 1) {
                cur.next = null;
            }
        }
    }

    public void print() {
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
