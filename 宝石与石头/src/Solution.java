import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description: 给定字符串J表示宝石的类型, 给定字符串S表示你所拥有的石头, 需要知道你所拥有的石头中有几个是宝石
 * 例如: 输入: J = "aA", S = "aAAbbbb"
 *      输出: 3
 * User: HHH.Y
 * Date: 2020-05-29
 */
public class Solution {
    public int numJewelsInStones(String J, String S) {
        // 方法1: 直接遍历法, 比较 J中的元素和 S中的元素是否相同, 若相同, 计数器++
        /*int count = 0;
        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if(J.charAt(i) == S.charAt(j)) {
                    count++;
                }
            }
        }
        return count;*/

        // 方法2: 将 J 中的元素放入一个 Set集合中, 然后遍历 S, 若 S中有元素出现在 J中, 计数器++
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if(set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
