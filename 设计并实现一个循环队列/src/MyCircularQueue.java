/**
 * Created with IntelliJ IDEA.
 * Description: 设计并实现一个循环队列
 * User: HHH.Y
 * Date: 2020-08-10
 */
public class MyCircularQueue {
    public int[] elem;
    public int front;
    public int rear; // rear 表示的是队列中最后一个元素位置的下一个位置
    // 实现构造方法, 设置队列的长度为 k
    public MyCircularQueue(int k) {
        this.elem = new int[k + 1];
    }

    // 向循环队列插入一个元素
    public boolean enQueue(int value) {
        // 如果循环队列已满, 就不可以插入元素
        if(isFull()) {
            return false;
        }
        elem[rear] = value;
        if(rear == elem.length - 1) {
            rear = (rear + 1) % elem.length;
        } else {
            rear++;
        }
        return true;
    }

    // 从循环队列中删除一个元素
    public boolean deQueue() {
        // 如果队列为空, 就不可以删除元素
        if(isEmpty()) {
            return false;
        }
        if(front == elem.length - 1) {
            front = (front + 1) % elem.length;
        } else {
            front++;
        }
        return true;
    }

    // 获取队首元素, 如果队列为空, 则返回 -1
    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        return elem[front];
    }

    // 获取队尾元素, 如果队列为空, 则返回 -1
    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        if(rear == 0) {
            return elem[elem.length - 1];
        } else {
            return elem[rear - 1];
        }
    }

    // 检查循环队列是否为空
    public boolean isEmpty() {
        if(front == rear) {
            return true;
        }
        return false;
    }

    // 检查循环队列是否已满
    public boolean isFull() {
        if((rear + 1) % elem.length == front) {
            return true;
        }
        return false;
    }
}
