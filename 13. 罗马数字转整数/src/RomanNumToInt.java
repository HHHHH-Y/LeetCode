import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 罗马数字转整数
 * 罗马数字包括:
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如: II = 2, XII = 12, XXVII = 27, 一般情况下, 罗马数字中, 小的数字在大的数字右边
 * 但是特殊情况下, 罗马数字中, 小的数字会出现在大的数字的右边, 只有以下6种情况是这样的:
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *
 * 例如: III = 3, IV = 4, LVIII = 58, MCMXCIV = 1994
 * User: HHH.Y
 * Date: 2020-09-05
 */
public class RomanNumToInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(romanToInt(input));
        }
    }
    public static int romanToInt(String s) {
        int length = s.length();
        if(length <= 0) {
            return 0;
        }

        // 使用 HashMap 的求解
        Map<Character, Integer> map = new HashMap<>();
        // 将所有的罗马字符都加入到这个 map 中
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        // 从后向前遍历数组, 如果前一个小于后一个, 就 -, 否则就 +
        int ret = map.get(s.charAt(length - 1));
        for (int i = length - 2; i >= 0; i--) {
            if(map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                ret -= map.get(s.charAt(i));
            } else {
                ret += map.get(s.charAt(i));
            }
        }
        return ret;
    }
}
