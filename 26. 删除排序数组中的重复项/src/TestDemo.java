import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-06-02
 */
public class TestDemo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1,2,2};
        System.out.println(solution.removeDuplicates(array));
        System.out.println(Arrays.toString(array));
    }
}
