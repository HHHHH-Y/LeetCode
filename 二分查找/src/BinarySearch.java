/**
 * Created with IntelliJ IDEA.
 * Description: 二分查找
 * 给定一个 n 个元素的有序（升序）整形数组 nums 和一个目标值 target，写一个函数搜索 nums 中的 target, 如果目标值存在返回下标，否则返回 -1
 * User: HHH.Y
 * Date: 2020-08-20
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        System.out.println(search(nums, target));
    }
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if(nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
