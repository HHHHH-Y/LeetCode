import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description: 最小的 K 个数
 * 输入 n 个整数, 找出其中最小的 K 个数. 例如输入 4, 5, 1, 6, 2, 7, 3, 8这 8 个数字, 则最小的 4 个数字是 1, 2, 3, 4
 *
 * TOPK 问题
 * User: HHH.Y
 * Date: 2020-08-03
 */
public class LeastNumbers {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        if(k > input.length) {
            return list;
        }
        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
        }
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 10;
        ArrayList<Integer> list = GetLeastNumbers_Solution(input, k);
        for (Integer integer:list) {
            System.out.print(integer + " ");
        }
    }
}
