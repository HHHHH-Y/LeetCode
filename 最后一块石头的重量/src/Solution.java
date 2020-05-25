import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-24
 */
public class Solution {
    public int lastStoneWeight(int[] stones) {
        // 1. 将 priorityQueue 的底层编程一个大根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // 将所有的元素都放进这个大根堆中
        for(int i = 0; i < stones.length; i++) {
            priorityQueue.offer(stones[i]);
        }
        // 当堆中的元素个数大于1时
        while (priorityQueue.size() > 1) {
            // 2. 取出堆顶元素, 并算出它们之间的差值
            int x = priorityQueue.poll();
            int y = priorityQueue.poll();
            int ret = Math.abs(x - y);
            // 3. 只要差值不为0, 就将差值入堆
            if(ret != 0) {
                priorityQueue.offer(ret);
            }
        }
        // 若只剩下一块石头, 就返回这一块石头的重量
        if(priorityQueue.size() == 1) {
            return priorityQueue.peek();
        }
        // 否则说明没有剩下石头, 返回 0
        return 0;
    }

}
