import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 回文串
 * 给定一个字符串, 问是否能通过添加一个字母将其变为回文串.
 *
 * 输入描述:
 * 一行一个由小写字母构成的字符串, 字符串长度小于等于 10
 * 输出描述:
 * 输出答案 YES \ NO
 *
 * 思路:
 * 1. 如果原本就是回文字符串, 则再加上一个字母就不是回文字符串了
 * 2. 如果字符是加在最后的, 例如: coco, 则需要从下标为 1 的字符开始, 判断该子串是否为回文字符串, 如果是, 则加上一个字母就可能是回文字符串, 否则就不是回文字符串
 * 3. 如果字符是加在最前面的, 例如: asddsaf, 则需要判断除最后一个字符外的子串是否是回文串, 如果是, 则加上一个字符就可能是回文字符串, 否则就不是回文字符串
 * User: HHH.Y
 * Date: 2020-07-15
 */
public class Palindromic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            boolean res = isPalindromic(str);
            if(res == true) {
                System.out.println("NO");
            }
            if(isPalindromic(str.substring(1)) == true || isPalindromic(str.substring(0, str.length() - 1)) == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isPalindromic(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
