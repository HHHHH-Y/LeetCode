import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: 数组中出现次数超过一半的数字
 * User: HHH.Y
 * Date: 2020-07-23
 */
public class FindLengthOverStepHalf {
    public int MoreThanHalfNum_Solution(int [] array) {
        int halfNum = array.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(map.get(array[i]) == null) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
            if(entry.getValue() > halfNum) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
