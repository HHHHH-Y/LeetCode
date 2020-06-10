import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: java 中, 要想将什么类型的数据转成字符串, 就需要使用 valueOf() 方法
 * User: HHH.Y
 * Date: 2020-06-10
 */
public class ReverseNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuffer stringBuffer = new StringBuffer("");
        /*while (n != 0) {
            int tmp = n % 10;
            stringBuffer.append(tmp);
            n /= 10;
        }
        System.out.println(stringBuffer.toString());*/
       String s = String.valueOf(n);
       StringBuffer tmp = new StringBuffer(s);
       tmp.reverse();
       System.out.println(tmp.toString());



    }
}
