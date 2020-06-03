import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 问题描述
 * 读入一个字符串str, 输出字符串str中的连续最长的数字串
 *
 * 例如: 输入  abcd12345ed125ss123456789
 *       输出 123456789
 * User: HHH.Y
 * Date: 2020-06-03
 */
public class TestDemo {
    public static void func(String str) {
        StringBuffer sb = new StringBuffer();
        String[] strings = new String[100];
        int usedSize = 0;
        // str = abcd12345ed125ss123456789
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                sb.append(str.charAt(i));
            } else if(sb.length() != 0) {
                strings[usedSize] = sb.toString();
                usedSize++;
                sb.delete(0, sb.length());
            }
        }
        if(sb.length() != 0) {
            strings[usedSize] = sb.toString();
            usedSize++;
        }
        int maxlen = strings[0].length();
       /* String str1 = "";
        for (int i = 1; i < usedSize; i++) {
            if(strings[i].length() > maxlen) {
                maxlen = strings[i].length();
                str1 = strings[i];
            }
        }
        System.out.println(str1);*/

        for (int i = 1; i < usedSize; i++) {
            if(strings[i].length() > maxlen) {
                maxlen = strings[i].length();
            }
        }
        for (int i = 0; i < usedSize; i++) {
            if(strings[i].length() == maxlen) {
                System.out.println(strings[i]);
                return;
            }
        }
        // 在 Java中, 使用 Integer.parseInt() 方法可以将String类型直接转换成int类型
       /* int[] array = new int[usedSize];
        for (int i = 0; i < usedSize; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }
        int max = array[0];
        for (int i = 1; i < usedSize; i++) {
            if(array[i] > max) {
                max = array[i];
            }
        }
        System.out.println(max);*/
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        func(str);
    }
}
