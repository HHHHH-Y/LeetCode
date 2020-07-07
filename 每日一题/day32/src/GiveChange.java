import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 在霍格沃茨找零钱
 * 如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统 —— 就如海格告诉哈利的：“十七个银西可(Sickle)兑一个加隆(Galleon)，
 * 二十九个纳特(Knut)兑一个西可，很容易。”现在，给定哈利应付的价钱P和他实付的钱A，你的任务是写一个程序来计算他应该被找的零钱。
 *
 * 思路:
 * 将所有的金额值全部统一成纳特, 然后进行计算, 之后再转换为各个面值的金额即可
 * User: HHH.Y
 * Date: 2020-07-07
 */
public class GiveChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            int post = input.indexOf(" ");
            String P = input.substring(0, post); // 应该付的钱
            String A = input.substring(post + 1); // 实际付的钱
            give(P, A);
        }
    }

    private static void give(String p, String a) {
        int[] w = {17 * 29, 29, 1}; // 一个加隆, 一个西可, 一个纳特 对应的纳特值
        String[] splitP = p.split("\\.");
        String[] splitA = a.split("\\.");
        int[] P = {Integer.parseInt(splitP[0]), Integer.parseInt(splitP[1]), Integer.parseInt(splitP[2])};
        int[] A = {Integer.parseInt(splitA[0]), Integer.parseInt(splitA[1]), Integer.parseInt(splitA[2])};
        int P1 = P[0] * w[0] + P[1] * w[1] + P[2] * w[2]; // P 对应的 纳特 数
        int A1 = A[0] * w[0] + A[1] * w[1] + A[2] * w[2]; // A 对应的 纳特 数
        int differentValue = A1 - P1;
        if(differentValue < 0) {
            System.out.print("-");
            differentValue = -differentValue;
        }
        System.out.print(differentValue / w[0] + "." + differentValue % w[0] / w[1] + "." + differentValue % w[0] % w[1] / w[2]);
    }
}
