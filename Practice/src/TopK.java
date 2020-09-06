import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description: 有一组数据为 [6, 1, 2, 7, 9, 3, 4, 5, 10, 8], 输出前 4 个最小的元素
 *
 * 分析: 因为输出的是前 4 个最小的元素, 所以应该构建一个大根堆
 * 1. 从下标为 k 的元素开始比较
 *    如果 该元素 < 堆顶元素, 就移除堆顶元素, 并把这个元素加入到堆中, 重新调整堆
 *    如果 该元素 >= 堆顶元素, 就继续比较后一个元素
 * User: HHH.Y
 * Date: 2020-09-06
 */
public class TopK {
    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        int k = 4;
        int[] ret = topK(arr, k);
        System.out.println(Arrays.toString(ret));
    }

    private static int[] topK(int[] arr, int k) {
        // 由于 priorityQueue 底层是一个小根堆, 所以需要使用比较器将其转换成大根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // 将前 k 个元素加入到优先级队列中
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }
        // 从第 k 个元素开始比较
        for (int i = k; i < arr.length; i++) {
            // 如果 arr[i] < 堆顶元素, 就将堆顶元素移除, 将 arr[i] 加入到堆中
            if(arr[i] < priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        // 这时堆中所存储的元素就是前 k 个最小的元素了
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = priorityQueue.poll();
        }
        return ret;
    }
}
