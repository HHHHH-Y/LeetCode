import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 * User: HHH.Y
 * Date: 2020-05-24
 */
public class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            // 字符串的比较使用 equals
            if(ops[i].equals("C")) {
                stack.pop();
            } else if(ops[i].equals("D")) {
                stack.push(2*stack.peek());
            } else if(ops[i].equals("+")) {
                int con = 0;
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else {
                stack.push(Integer.parseInt(ops[i]));
            }
        }
        int sum = 0;
        while (!stack.empty()) {
            sum = sum + stack.peek();
            stack.pop();
        }
        return sum;
    }
}
