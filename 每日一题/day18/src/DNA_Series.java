import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: DNA 序列
 * 输入描述：
 * 输入一个string型基因序列，和int型子串的长度
 *
 * 输出描述：
 * 找出GC比例最高的子串，如果有多个输入第一个的子串
 *
 * 输入：AACTGTGCACGACCTGA   5
 * 输出：GCACG
 * User: HHH.Y
 * Date: 2020-06-19
 */
public class DNA_Series {
    private static void output(String str, int len) {
        int k = 0;
        int max = 0;
        for (int i = 0; i < str.length() - len; i++) {
            int count = 0;
            for (int j = i; j < i + len; j++) {
                if(str.charAt(j) == 'C' || str.charAt(j) == 'G') {
                    count++;
                }
            }
            if(count > max) {
                max = count;
                k = i;
            }
        }
        for (int i = k; i < k + len; i++) {
            System.out.print(str.charAt(i));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int len = scanner.nextInt();
        output(str, len);
    }
}
