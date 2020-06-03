/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-06-02
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = i + 1;
        int usedSize = nums.length;
        while (j < usedSize) {
            while (nums[i] == nums[j] && j != usedSize) {
                for (int k = i; k < usedSize - 1; k++) {
                    nums[k] = nums[k + 1];
                }
                usedSize--;
            }
            i++;
            j = i + 1;
        }
        return usedSize;
    }
}
