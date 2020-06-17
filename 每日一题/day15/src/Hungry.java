import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。
 * 最开始小易在一个初始位置x_0。
 * 对于小易所处的当前位置x，他只能通过神秘的力量移动到 4 * x + 3或者8 * x + 7。
 * 因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000次。
 * 贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1,000,000,007，位置2,000,000,014等)。
 * 小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝壳。
 *
 * 输入描述:
 * 输入一个初始位置x_0,范围在1到1,000,000,006         125000000
 *
 * 输出描述:
 * 输出小易最少需要使用神秘力量的次数，如果使用次数使用完还没找到贝壳，则输出-1    1
 * User: HHH.Y
 * Date: 2020-06-17
 */
public class Hungry {
    private static void eatShell(Long x0) {
        long m = 1000000007;// 贝壳的位置
        long num = 100000; // 小易可以使用神秘力量的次数

        // 走 (4 * x0 + 3) 的情况
        long[] begin = new long[3];
        begin[0] = x0;
        begin[1] = (4 * begin[0] + 3) % m;
        begin[2] = (4 * begin[1] + 3) % m;

        long minCount = num;
        long cur = 0;
        int count = 0;
        for (int i = 0; i < 3; i++) {
            cur = begin[i];
            count = i;
            while (cur != 0 && count < minCount) {
                cur = (8 * cur + 7) % m;
                count++;
            }
            minCount = minCount < count ? minCount : count;
        }
        if(minCount < num) {
            System.out.println(minCount);
        } else {
            System.out.println(-1);
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long x0 = scanner.nextLong();
        eatShell(x0);
    }
}
