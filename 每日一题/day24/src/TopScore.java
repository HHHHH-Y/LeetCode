import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 最高分是多少
 * 老师想知道从某某同学当中,分数最高的是多少, 现在请你编程模拟老师的询问.
 * 当然, 老师有时候需要更新某位同学的成绩
 * User: HHH.Y
 * Date: 2020-06-27
 */
public class TopScore {
    private static int print_The_Highest_Score(String c, int A, int B, int[] students) {
        int max = 0;
        if(c.equals("Q")) {
            if(A <= B) {
                for (int i = A; i <= B; i++) {
                    max = Math.max(students[i], max);
                }
            } else {
                for (int i = B; i <= A; i++) {
                    max = Math.max(students[i], max);
                }
            }
            return max;

        } else {
           students[A] = B;
           return 0;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] students = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                students[i] = scanner.nextInt();
            }
            for (int i = 0; i < m; i++) {
                String c = scanner.next();
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                if(print_The_Highest_Score(c, A, B, students) == 0) {
                    continue;
                } else {
                    System.out.println(print_The_Highest_Score(c, A, B, students));
                }
            }
        }
    }
}
