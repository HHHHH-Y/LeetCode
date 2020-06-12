import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 个位数统计问题
 * 输入描述:
 * 每个输入包含1个测试用例，即一个不超过1000位的正整数N。
 * (位数总共 <= 1000 位, 就超过了 int 的数据范围, 因此需要使用一个字符串去接收这个值)
 *
 * 输出描述:
 * 对N中每一种不同的个位数字，以D:M的格式在一行中输出该位数字D及其在N中出现的次数M。要求按D的升序输出。
 *
 * 例如:
 * 输入: 100311
 * 输出: 0 : 2
 *       1 : 3
 *       3 : 1
 * User: HHH.Y
 * Date: 2020-06-12
 */
public class Single_DigitNums {
    private static void statistics(String n) {
        char[] ch = new char[n.length()];
        int index = 0;
        for (int i = 0; i < n.length(); i++) {
            ch[index++] = n.charAt(i);
        }
        Arrays.sort(ch);
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < ch.length) {
            if(ch[i] == ch[j]) {
                count++;
            } else {
                System.out.println(ch[i] - '0' + ":" + count);
                i = j;
                count = 1;
            }
            j++;
        }
        System.out.println(ch[i] - '0' + ":" + count);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        statistics(n);
    }
}
