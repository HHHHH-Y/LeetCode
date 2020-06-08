
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 升序输出 n个数里最小的 k 个
 * topK 问题
 * User: HHH.Y
 * Date: 2020-06-08
 */
public class Least_TopK {
    // 使用大根堆来进行求解
    private static void topK(String input) {
        String[] str = input.split(" ");
        int k = Integer.parseInt(str[str.length - 1]); // 代表最后获得的最小的 K 个数
        int[] array = new int[str.length - 1];
        for (int i = 0; i < str.length - 1; i++) {
            array[i] = Integer.parseInt(str[i]);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 得到 k 个最小的数, 应该建立一个大根堆
        for (int i = 0; i < array.length; i++) {
            if(priorityQueue.size() < k) {
                priorityQueue.offer(array[i]);
            } else {
                int val = priorityQueue.peek();
                if(val > array[i]) {
                    priorityQueue.poll();
                    priorityQueue.offer(array[i]);
                }
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = priorityQueue.poll();
        }
        int i = 0;
        int j = ret.length - 1;
        while (i < j) {
            int tmp = ret[i];
            ret[i] = ret[j];
            ret[j] = tmp;
            i++;
            j--;
        }
        for (int l = 0; l < ret.length; l++) {
            System.out.print(ret[l] + " ");
        }
    }

    // 直接时候 Arrays.sort() 方法进行排序, 然后取出最小的 k 个元素
    /*private static void topK(String input) {
        int k = Integer.parseInt(input.substring(input.length() - 1));
        String[] str = input.split(" ");
        int[] array = new int[str.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(array);
        for (int i = 0; i < k; i++) {
            System.out.print(array[i] + " ");
        }
    }*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); // 3 9 6 8 -10 7 -11 19 30 12 23 5
        topK(input);
    }
}
