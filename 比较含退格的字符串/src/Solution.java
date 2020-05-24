import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: 给定 S 和 T 两个字符串, 当他们分别被输入到空白文本编辑器后, 判断二者是否相等, 并返回结果
 * 如: S = "ab#c", T = "ad#c"   返回 true
 *     S = "ab##", T = "c#d#"   返回 true
 *     S = "a##c", T = "#a#c"   返回 true
 *     S = "a#c", T = "b"   返回 false
 * User: HHH.Y
 * Date: 2020-05-24
 */
public class Solution {
    public boolean backspaceCompare(String S, String T) {
        // 分别定义两个栈, 用来存放 S 和 T 中的元素
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            // 如果元素不为 #, 就进栈
            if(S.charAt(i) != '#') {
                stack1.push(S.charAt(i));
            } else {
                // 此时元素 == #
                // 若栈不为空, 就将栈顶元素出栈
                if(!stack1.empty()) {
                    stack1.pop();
                }
            }
        }
        for (int j = 0; j < T.length(); j++) {
            if(T.charAt(j) != '#') {
                stack2.push(T.charAt(j));
            } else {
                // 此时元素 == #
                if(!stack2 .empty()) {
                    stack2.pop();
                }
            }
        }
        // 当两个栈都不为空
        while (!stack1.empty() && !stack2.empty()) {
            if(stack1.peek() == stack2.peek()) {
                stack1.pop();
                stack2.pop();
            } else {
                // 只要扎安定元素不同, 就返回false
                return false;
            }
        }
        // 如果一个栈为空, 一个栈不为空, 就返回false
        if(stack1.empty() && !stack2.empty() || !stack1.empty() && stack2.empty()) {
            return false;
        }
        // 若两个栈都为空, 就返回true
        return true;
    }
}
