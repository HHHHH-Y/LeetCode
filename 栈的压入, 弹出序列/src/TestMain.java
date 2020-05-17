/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-16
 */
public class TestMain {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 3, 5, 1, 2};
        System.out.println(solution.IsPopOrder(push, pop));
    }
}
