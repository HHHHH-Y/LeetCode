import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 神奇的口袋   问题描述
 * 有一个神奇的口袋，总的容积是40，用这个口袋可以变出一些物品，这些物品的总体积必须是40。
 * John现在有n个想要得到的物品，每个物品的体积分别是：a1, a2, a3 ...
 * John可以从这些物品中选择一些，如果选出的物品的总体积是40，那么利用这个神奇的口袋，John就可以得到这些物品。
 * 现在的问题是，John有多少种选择不同物品的方式
 *
 * 输入：输入的第一行是正整数n(1 <= n <= 20)，表示不同的物品的数目。接下来的n行，每行有一个1到40之间的正整数，分别给出a1,a2,...an的值
 * 输出： 输出不同的选择物品的方式的数目
 *
 * 思路： 用sum表示口袋中剩余的体积
 * 1. 如果sum = 0，表示口袋刚好装满，说明这种取法成功，就返回1
 * 2. 如果sum < 0, 表示口袋装不下了，i == n, 表示如果所有的数都找完了，口袋还没有装， 就返回0；
 * 3. 否则就递归计算装入i + 1 这个数和不装入i + 1 这个数，共有几种装满的方法
 * User: HHH.Y
 * Date: 2020-06-05
 */
public class Magic_Pocket {
    public static int n;

    public static int differentChoiceCount(int[] array,int i, int sum) {
       if(sum == 0) {
           return 1;
       }
       if(i == n || sum < 0) {
           return 0;
       }
       return differentChoiceCount(array, i + 1, sum - array[i]) + differentChoiceCount(array, i + 1, sum);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(differentChoiceCount(array, 0, 40));
    }
}
