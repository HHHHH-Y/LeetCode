import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: 问题描述
 * 对于一个字符串, 请设计一个算法, 判断其是否是一个合法的括号串
 * 给定一个字符串A和它的长度 n, 请返回一个 bool值代表他是否为一个合法的括号串
 * 一个合法的括号串定义为: 1. 只包括括号字符; 2. 左括号右括号一一对应
 * User: HHH.Y
 * Date: 2020-06-03
 */
public class TestDemo2 {
    public static boolean chkParenthesis(String A, int n) {
        for (int i = 0; i < n; i++) {
            if(A.charAt(i) != '(' && A.charAt(i) != ')') {
                return false;
            }
        }
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < n) {
            if(A.charAt(i) == '(') {
                stack.push(A.charAt(i));
            } else {
                if(stack.empty()) {
                    return false;
                }
                stack.pop();
            }
            i++;
        }
        if(!stack.empty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        int len = A.length();
        System.out.println(chkParenthesis(A, len));
    }
}
