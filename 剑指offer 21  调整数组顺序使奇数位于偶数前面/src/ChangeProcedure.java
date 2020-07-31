import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组, 实现一个函数来调整该数组中数字的顺序, 使得所有奇数位于数组的前半段, 所有偶数位于数组的后半段
 * 示例: 输入数组 nums = {1, 2, 3, 4}, 输出: {1, 3, 2, 4} ({3, 1, 2, 4} 也是正确的答案)
 *
 * 思路:
 * 定义两个变量 odds 和 even, 分别从数组的两边向中间进行遍历
 * odds 从前向后遍历, 只要遇见偶数就停止
 * even 从后向前遍历, 只要遇见奇数就停止
 * 然后两个数进行交换
 * 直到 odds >= even 即可, 得到的数组就是奇数位于偶数前面
 * User: HHH.Y
 * Date: 2020-07-31
 */
public class ChangeProcedure {
    public static int[] exchange(int[] nums) {
        int odds = 0;
        int even = nums.length - 1;
        while (odds < even) {
            while (odds < even && nums[odds] % 2 == 1) {
                odds++;
            }
            while (odds < even && nums[even] % 2 == 0) {
                even--;
            }
            int tmp = nums[odds];
            nums[odds] = nums[even];
            nums[even] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 7, 5, 8, 9, 6, 2};
        int[] exchange = exchange(nums);
        System.out.println(Arrays.toString(exchange));
    }
}
