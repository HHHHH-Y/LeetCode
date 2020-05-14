import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: 括号匹配问题
 * User: HHH.Y
 * Date: 2020-05-14
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); // 访问字符串中的元素
            // 1. 如果是左括号就让它进栈
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                // 如果是右括号, 就和栈中的左括号进行匹配
                // 1. 判断栈是否为空, 如果栈为空, 说明右括号比左括号多
                if(stack.empty()) {
                    System.out.println("右括号多");
                    return false;
                }
                // 2. 如果栈不为空, 就进行括号的匹配
                char ch2 = stack.peek();
                if(ch2 == '(' && ch == ')' || ch2 == '[' && ch == ']' || ch2 == '{' && ch == '}') {
                    // 2.1 如果匹配的话, 就将栈顶的左括号出栈
                    stack.pop();
                } else {
                    // 2.2 如果不匹配, 说明括号匹配错误
                    System.out.println("括号匹配错误");
                    return false;
                }
            }
        }
        if(!stack.empty()) {
            System.out.println("左括号多");
            return false;
        }
        return true;
    }
}
