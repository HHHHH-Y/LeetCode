import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 统计回文字符串
 *
 * 要求: 每组输入数据共两行
 *       第一行为字符串A (aba)
 *       第二行为字符串B (b)
 *       字符串长度均小于100且只包含小写字母
 * 输出描述: 输出一个数字, 表示把字符串B插入字符串A中构成一个回文串的方法数
 * User: HHH.Y
 * Date: 2020-06-01
 */
public class TestDemo {
    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() -1;
        while (i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        String B = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            StringBuffer sb = new StringBuffer(A); // 将 sb 初始化为 A
            if(isPalindrome(sb.insert(i, B).toString())) {
                count++;
            }
        }
        System.out.println(count);
    }
}
