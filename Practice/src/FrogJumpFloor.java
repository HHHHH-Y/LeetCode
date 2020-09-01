/**
 * Created with IntelliJ IDEA.
 * Description: 青蛙跳台阶问题
 * User: HHH.Y
 * Date: 2020-09-01
 */
public class FrogJumpFloor {
    public int JumpFloor(int target) {
        if(target <= 2) {
            return target;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);

    }
}
