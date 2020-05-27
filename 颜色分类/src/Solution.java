import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 颜色分类问题, 使用选择排序即可解答
 * User: HHH.Y
 * Date: 2020-05-27
 */
public class Solution {
    public static void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
