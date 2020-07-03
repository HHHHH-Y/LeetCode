import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 密码验证合格程序
 * 密码要求:
 * 1. 长度超过 8 位
 * 2. 包括大小写字母,数字,其他符号, 以上四种至少三种
 * 3. 不能有相同长度超 2 的子串重复
 *    说明: 长度超过 2 的子串
 *
 * 输入描述:
 * 一组或多组长度超过2的字符串, 每组占一行
 * 输出描述:
 * 如果符合要求输出: OK, 否则输出 NG
 * User: HHH.Y
 * Date: 2020-07-03
 */
public class CheckPasswordIsOk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String password = scanner.nextLine();
            if(judgeLength(password) && judgeKinds(password) && judgeRepeat(password)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }

    // 判断是否有重复的密码组成部分(重复的字符串长度必须 >= 3, 也就是说后两个字符不需要再进行判断)
    // subString() 为左闭右开区间的函数
    private static boolean judgeRepeat(String password) {
        for (int i = 0; i < password.length() - 2; i++) {
            String target = password.substring(i, i + 3); // 要找的目标字符串
            if(password.substring(i + 1).contains(target)) {
                return false;
            }
        }
        return true;
    }

    // 判断密码种类是否符合要求
    private static boolean judgeKinds(String password) {
        char[] chars = password.toCharArray();
        int n = 0;
        int a = 0;
        int A = 0;
        int simple = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= '0' && chars[i] <= '9') {
                n = 1;
            } else if(chars[i] >= 'a' && chars[i] <= 'z') {
                a = 1;
            } else if(chars[i] >= 'A' && chars[i] <= 'Z') {
                A = 1;
            } else {
                simple = 1;
            }
        }
        if((n + a + A + simple) >= 3) {
            return true;
        } else {
            return false;
        }
    }

    // 判断密码长度是否符合要求 (密码长度必须 > 8)
    private static boolean judgeLength(String password) {
        if(password.length() > 8) {
            return true;
        } else {
            return false;
        }
    }

}
