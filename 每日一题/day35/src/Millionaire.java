/**
 * Created with IntelliJ IDEA.
 * Description: 百万富翁问题
 * User: HHH.Y
 * Date: 2020-07-10
 */
public class Millionaire {
    public static void main(String[] args) {
        int millionMoney = 0;
        for (int i = 0; i < 30; i++) {
            millionMoney += 10;
        }

        long stranger = 0;
        for (int i = 0; i < 30; i++) {
            stranger += Math.pow(2, i);
        }
        System.out.println(millionMoney + " " + stranger);
    }
}
