import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 移动 0
 * 给定一个数组 nums, 编写一个函数将所有的 0 移动到数组的末尾, 同时保持非零元素的相对顺序
 * 例如: [0, 1, 0, 3, 12]
 *       [1, 3, 12, 0, 0]
 *
 * 解题思路:
 * 1. 定义两个变量 i, j
 * 2. i 遍历数组, 只要 nums[i] 不为 0, 就将它赋值给 nums[j], j++
 * 3. 数组遍历完之后, j 所指的位置就是最后一个不为 0 的数的下一个位置
 * 4. 将后面的位置上全部补 0 即可
 * User: HHH.Y
 * Date: 2020-09-05
 */
public class MoveZero {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0 ,3, 12};
        moveZero(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZero(int[] nums) {
        int i = 0;
        int j = 0;
        for (; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int k = j; k < nums.length; k++) {
            nums[k] = 0;
        }
    }
}
