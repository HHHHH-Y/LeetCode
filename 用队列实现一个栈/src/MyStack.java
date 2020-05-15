import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description: 用队列实现一个栈
 * User: HHH.Y
 * Date: 2020-05-14
 */
public class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // 1. 判断两个队列是否都为空, 若都为空, 就指定将其放在queue1中
        // 2. 否则就查看哪个队列不为空, 就将元素放在哪个队列中
        if(empty()) {
            queue1.offer(x);
        } else if(!queue1.isEmpty()) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
        return;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // 1. 判断两个队是否都为空, 若都为空, 说明栈为空, 就不可以出栈
        // 2. 否则, 查找不为空的那个队列, 将前n-1个元素放入到第二个队列中, 再将最后一个元素出队
        if(empty()) {
            return -1;
        }
        int q1Size = queue1.size() - 1;
        int q2Size = queue2.size() - 1;
        int ret = 0;
        if(!queue1.isEmpty()) {
           for (int i = 0; i < q1Size; i++) {
               int data = queue1.poll();
               queue2.offer(data);
           }
           ret = queue1.poll();
        }else if(!queue2.isEmpty()) {
           for (int i = 0; i < q2Size; i++) {
               int data = queue2.poll();
               queue1.offer(data);
           }
           ret =  queue2.poll();
        }
        return ret;
    }

    /** Get the top element. */
    public int top() {
        if(empty()) {
            return -1;
        }
        int q1Size = queue1.size();
        int q2Size = queue2.size();
        int ret = 0;
        if(!queue1.isEmpty()) {
            for (int i = 0; i < q1Size; i++) {
                int data = queue1.poll();
                queue2.offer(data);
                ret = data;
            }
        }else if(!queue2.isEmpty()) {
            for (int i = 0; i < q2Size; i++) {
                int data = queue2.poll();
                queue1.offer(data);
                ret = data;
            }
        }
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        }
        return false;
    }
}
