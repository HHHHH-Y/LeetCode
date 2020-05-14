/**
 * Created with IntelliJ IDEA.
 * Description: 设计一个循环队列
 * User: HHH.Y
 * Date: 2020-05-14
 */
public class MyCircularQueue {
    public int[] elem;
    public int front;
    public int rear;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.elem = new int[k + 1];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        // 1. 如果队列已满, 就不能再进行入队操作
        if(isFull()) {
            return false;
        }
        // 2. 如果队列没有满, 就可以进行入队
        this.elem[rear] = value;
        if(this.rear == this.elem.length - 1) {
            this.rear = (this.rear + 1) % this.elem.length;
        } else {
            this.rear++;
        }
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        // 1. 如果这个队列为空, 就不能进行 出队
        if(isEmpty()) {
            return false;
        }
        // 2. 如果这个队列不为空, 才可以进行出队
        if(this.front == this.elem.length - 1) {
            this.front = (this.front + 1) % this.elem.length;
        } else {
            this.front++;
        }
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        // 1. 如果队为空, 就返回-1;
        if(isEmpty()) {
            return -1;
        }
        // 2. 如果队不为空, 才可以返回 队头元素
        return this.elem[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        // 1. 如果队列为空, 就返回-1
        if(isEmpty()) {
            return -1;
        }
        // 2. 如果队列不为空, 才可以获取 队尾元素
        if(this.rear == 0) {
            return this.elem[this.elem.length - 1];
        }
        return this.elem[this.rear - 1];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(this.front == this.rear) {
            return true;
        }
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if((this.rear + 1) % this.elem.length == this.front) {
            return true;
        }
        return false;
    }
}
