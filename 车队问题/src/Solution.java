import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:车队问题
 * 1. 先按照车原来的初始位置从小到大排序, 同时排序其速度
 * 2. 从离目的地最近的车辆开始(数组的最后位置)计算到达目的地的时间
 * 3. 如果后面的车到达目的地时间小于前面的车, 说明它们一定会相遇, 即时同一车队
 * 4. 若时间大于前面的车的时间, 说明一定不会相遇, 即它们一定不是同一个车队
 * User: HHH.Y
 * Date: 2020-05-27
 */
public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 0) {
            // 说明没有车
            return 0;
        }
        // 1. 建立一个集合, 将车的起始位置和速度存放进去
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], speed[i]);
        }
        // 3. 将集合从小到大排序. 相当于将车的起始位置从远及近进行排序
        Arrays.sort(position);
        // 4. 从离目的地最近的两辆车开始计算其到达目的地的时间

        int near = position.length - 1;
        int far = position.length - 2;
        int count = 0;
        while (far >= 0) {
            double nearTime = (target - position[near]) * 1.0 / map.get(position[near]);
            double farTime = (target - position[far]) * 1.0 / map.get(position[far]);

            if(farTime <= nearTime) {
                // 说明较远的车到达目的地所用时间 <= 较近的车
                far--;
            } else {
                // 说明较远的车到达目的地所用时间 > 较近的车
                count++;
                near = far;
                far = near - 1;
            }
        }
        return count + 1;
    }
}
