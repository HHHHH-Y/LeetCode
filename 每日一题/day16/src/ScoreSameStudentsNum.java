import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 统计同成绩学生人数
 * 输入N名学生的成绩，将获得某一给定分数的学生人数输出
 *
 * 输入描述：
 * 测试输入包含若干测试用例，每个测试用例的格式为：
 * 第 1 行：N：学生数
 * 第 2 行：N名学生的成绩，相邻两数字用一个空格间隔
 * 第 3 行：给定分数
 * 当读到 N=0 时输入结束。其中 N 不超过 1000， 成绩分数（包含）0到100之间的一个整数
 *
 * 输出描述
 * 对每个测试用例，将获得给定分数的学生人数输出
 *
 * User: HHH.Y
 * Date: 2020-06-18
 */
public class ScoreSameStudentsNum {
    private static void scoreSameNum(int[] scores, int score) {
        int count = 0;
        for (int i = 0; i < scores.length; i++) {
            if(scores[i] == score) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            if(N == 0) {
                break;
            }
            int[] scores = new int[N];
            for (int i = 0; i < N; i++) {
                scores[i] = scanner.nextInt();
            }
            int score = scanner.nextInt();
            scoreSameNum(scores,score);
        }
    }
}
