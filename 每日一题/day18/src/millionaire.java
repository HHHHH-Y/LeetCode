/**
 * Created with IntelliJ IDEA.
 * Description: 百万富翁问题
 * 一个百万富翁遇到一个陌生人，陌生人找他谈了一个换钱计划。该计划如下：
 * 我每天给你 10 万元，你第一天给我 1 分钱，第二天 2 分，第三天 4 分。。。
 * 注意交换 30 天后，百万富翁交出了多少钱？ 陌生人交出了多少钱？
 * （注意：一个是万元，一个是分）
 *
 * 输入描述：
 * 该题没有输入
 *
 * 输出描述：
 * 输出两个整数，分别代表百万富翁交出的钱数和陌生人交出的钱数，富翁交出的钱以万元做单位，陌生人交出的钱以分做单位
 *
 * User: HHH.Y
 * Date: 2020-06-19
 */
public class millionaire {
    public static void main(String[] args) {
        int rich = 0;
        int stranger = 1;
        for (int i = 0; i < 30; i++) {
            rich += 10;
        }
        int money = 1;
        for (int i = 1; i < 30; i++) {
            money = 2 * money;
            stranger += money;
        }
        System.out.println(rich + " " + stranger);

    }
}
