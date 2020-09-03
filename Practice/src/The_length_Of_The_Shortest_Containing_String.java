import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 最短包含字符串的长度
 * 输出 str1 的字符串中含有 str2 所有字符的最小字符串长度, 如果不存在请输出 0
 * 例如: abcde ac   输出: 3
 *      12345 344   输出: 0
 *
 *
 * User: HHH.Y
 * Date: 2020-09-03
 */
public class The_length_Of_The_Shortest_Containing_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            int ret = theShortestContainingString(str1, str2);
            System.out.println(ret);
        }
    }

    private static int theShortestContainingString(String str1, String str2) {
        if(str1 == null || str2 == null || str1.length() < str2.length()) {
            return 0;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < chars2.length; i++) {
            map[chars2[i]]++; // 将 str2 中的所有字符都加入到 map 中
        }
        int left = 0;
        int right = 0;
        int minLine = Integer.MAX_VALUE;
        int match = str2.length();
        while (right < str1.length()) {
            map[chars1[right]]--;
            if(map[chars1[right]] >= 0) {
                match--;
            }
            if(match == 0) {
                while (map[chars1[left]] < 0) {
                    map[chars1[left++]]++;
                }
                minLine = Math.min(minLine, right - left + 1);
                match++;
                map[chars1[left++]]++;
            }
            right++;
        }
        return minLine == Integer.MAX_VALUE ? 0 : minLine;
    }
}
