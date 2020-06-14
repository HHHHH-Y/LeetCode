import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 超长正整数相加
 * 请设计一个算法完成两个超长正整数的加法
 * 输入参数：
 *  String addend：加数
 *  String augend：被加数
 * 返回值：加法结果
 * public String AddLongInteger(String addend, String augend)
 *  {
 *      在这里实现功能
 *    return null;
 *  }
 *
 *  输入描述:
 * 输入两个字符串数字
 *
 * 输出描述:
 * 输出相加后的结果，string型
 *
 * 思路：字符串中的数值进行相加，就是用逢 10 进 1 的方法进行计算。
 *       在可以使用 BigInteger 的情况下可以直接使用 BigInteger 进行计算
 * User: HHH.Y
 * Date: 2020-06-14
 */
public class AddSuperLongIntegers {
    public String AddLongInteger(String addend, String augend) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = addend.length() - 1; // i表示从输入加数的最后一位开始
        int j = augend.length() - 1; // j表示从输入被加数的最后一位开始
        int carry = 0; // 表示进位
        while (i >= 0 || j >= 0) {
            int add = (i >= 0 ? addend.charAt(i) - '0' : 0);
            int aug = (j >= 0 ? augend.charAt(j) - '0' : 0);
            int tmp = add + aug + carry;
            carry = tmp / 10;
            stringBuffer.append(tmp % 10);
            i--;
            j--;
        }
        if(carry == 1) {
            stringBuffer.append("1");
        }
        return stringBuffer.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String addend = scanner.nextLine();
            String augend = scanner.nextLine();
            AddSuperLongIntegers a = new AddSuperLongIntegers();
            System.out.println(a.AddLongInteger(addend, augend));
        }
    }
}
