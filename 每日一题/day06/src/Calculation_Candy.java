import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 计算糖果问题
 * <p>
 * A,B,C三个人是好朋友,每个人手里都有一些糖果,我们不知道他们每个人手上具体有多少个糖果,但是我们知道以下的信息：
 * A - B, B - C, A + B, B + C. 这四个数值.每个字母代表每个人所拥有的糖果数.
 * 现在需要通过这四个数值计算出每个人手里有多少个糖果,即A,B,C。这里保证最多只有一组整数A,B,C满足所有题设条件。
 * <p>
 * 输入描述:
 * 输入为一行，一共4个整数，分别为A - B，B - C，A + B，B + C，用空格隔开。 范围均在-30到30之间(闭区间)。  1  -2   3   4
 * 输出描述:
 * 输出为一行，如果存在满足的整数A，B，C则按顺序输出A，B，C，用空格隔开，行末无空格。 如果不存在这样的整数A，B，C，则输出No  2  1  3
 * User: HHH.Y
 * Date: 2020-06-06
 */
public class Calculation_Candy {
    /* public static void output(int[] array) {
         int A = (array[0] + array[2]) / 2;
         int B = (array[1] + array[3]) / 2;
         int C = array[3] - B;
         // 如果 % 2 != 0, 说明 / 2 一定是一个小数
         if((array[0] + array[2]) % 2 == 0 && (array[1] + array[3]) % 2 == 0 && A + B == array[2]) {
             System.out.println(A + " " + B + " " + C);
         } else {
             System.out.println("No");
         }
     }*/
    public static void output(int[] array) {
        int A = (array[0] + array[2]) / 2;
        int B = (array[1] + array[3]) / 2;
        int C = (array[3] - array[1]) / 2;
        // 由于 A, B, C全部初始化为一个整型, 若出现小数, 则会将小数舍去
        // 再进行A, B, C 的计算时, 如果A, B, C是舍去小数的整数, 则不会满足条件式.
        if((A - B == array[0]) && (B - C == array[1]) && (A + B == array[2]) && (B + C == array[3])) {
            System.out.println(A + " " + B + " " + C);
        } else {
            System.out.println("No");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.split(" ");
        int[] array = new int[strings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }
        output(array);
    }
}
