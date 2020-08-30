package huyue;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: 使用栈实现一个队列
 * 初始化两个栈
 * 先入栈 栈1
 * 然后再从栈1 出栈, 入栈到栈2
 * 再从栈2 出栈就可以实现一个队列
 *
 * 实现的队列需要完成的任务: 将元素入队, 将元素出队, 获取队首元素, 判断队列是否为空
 * User: HHH.Y
 * Date: 2020-08-30
 */
public class UseStackRealizeQueue {
   Stack<Integer> stack1 = new Stack<>();
   Stack<Integer> stack2 = new Stack<>();
   public void push(int node) {
      stack1.push(node);
   }

   public void pop() {
      if(stack1.empty() && stack2.empty()) {
         return;
      }
      int size = stack1.size();
      if(stack2.empty()) {
         for (int i = 0; i < size; i++) {
            stack2.push(stack1.pop());
         }
      }
      stack2.pop();
   }
}