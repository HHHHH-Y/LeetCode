import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 两数之和
 * User: HHH.Y
 * Date: 2020-04-20
 */

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return null;
    }
}
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(solution.twoSum(nums,target)));
    }
}
