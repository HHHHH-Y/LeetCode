package questions1;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 剑指 offer 53. 0 ~ n-1 中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 例子: 输入[0, 1, 3], 输出: 2
 *       输入[0, 1, 2, 3, 4, 5, 6, 7, 9], 输出: 8
 * User: HHH.Y
 * Date: 2020-09-12
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        int ret = missingNumber(nums);
        System.out.println(ret);
    }

    private static int missingNumber(int[] nums) {
        int sum = (nums.length * (nums.length + 1)) / 2;
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = sum - nums[i];
            sum -= nums[i];
        }
        return ret;
    }
}
