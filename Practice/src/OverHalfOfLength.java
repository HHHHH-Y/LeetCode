import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description: 数组中出现次数超过一半的数字
 * User: HHH.Y
 * Date: 2020-09-05
 */
public class OverHalfOfLength {
    public int majorityElement(int[] nums) {
        // 使用 map 求解
        int len = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i:nums) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
            if(entry.getValue() > len) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
