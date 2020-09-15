import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 质数又称为素数, 一个大于 1 的自然数, 除了 1 和它自身外, 不能被其他自然数整除的数称为质数, 否则称为合数.
 * 请将一个正整数分解质因数, 如果输入的数不是合数, 打印其本身, 否则将按照从小到大的属性打印出质因子
 * User: HHH.Y
 * Date: 2020-09-15
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入数字
        int inputNum = scanner.nextInt();
        function(inputNum); // 将这个数字拆分
    }

    private static void function(int inputNum) {
        // 定义一个 stringBuffer, 用来保存结果
        StringBuffer stringBuffer = new StringBuffer();
        int num = 2;
        while (num <= inputNum) {
            // 使用辗转相除法
            if(inputNum % num == 0) {
                // 如果能除尽, 则说明是一个质因数
                stringBuffer.append(num);
                inputNum /= num;
                num = 2;
            } else {
                // 如果没有办法整除, 则 num++
                num++;
            }
        }
        String tmp = stringBuffer.substring(0, stringBuffer.toString().length());
        char[] chars = tmp.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }
}
