import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 学分绩点
 * 实际成绩和绩点的关系:
 * 90 - 100: 4.0
 * 85 - 89: 3.7
 * 82 - 84: 3.3
 * 78 - 81: 3.0
 * 75 - 77: 2.7
 * 72 - 74: 2.3
 * 68 - 71: 2.0
 * 64 - 67: 1.5
 * 60 - 63: 1.0
 * 60以下: 0
 * 1. 一门课程的学分绩点 = 该课绩点 * 该课学分
 * 2. 总评绩点 = 所有学科绩点之和 / 所有课程学分之和
 * 请求出某人 A 的总评绩点(GPA)
 *
 * 输入描述:
 * 第一行: 总的课程数 n (n < 10)
 * 第二行: 相应课程的学分(两个学分用空格隔开)
 * 第三行: 对应课程的实际得分
 *
 * 输出描述:
 * 输出一行, 总评绩点, 精确到小数点后2位小数.
 * (printf("%.2f", GPA);)
 * User: HHH.Y
 * Date: 2020-06-29
 */
public class Grade_Point {
    private static void total_Grade_Point(int[] credit, int[] actScore) {
        int sumCredit = 0; // 所有课程的学分之和
        double totalGPA = 0; // 所有学科绩点之和
        double sumGPA = 0; // 总评绩点
        double GPA = 0; // 绩点

        for (int i = 0; i < credit.length; i++) {
            sumCredit += credit[i]; // 16
        }
        for (int i = 0; i < actScore.length; i++) {
            if(actScore[i] >= 90 && actScore[i] <= 100) {
                GPA = 4.0;
            } else if(actScore[i] >= 85 && actScore[i] <= 89) {
                GPA = 3.7;
            } else if(actScore[i] >= 82 && actScore[i] <= 84) {
                GPA = 3.3;
            } else if(actScore[i] >= 78 && actScore[i] <= 81) {
                GPA = 3.0;
            } else if(actScore[i] >= 75 && actScore[i] <= 77) {
                GPA = 2.7;
            } else if(actScore[i] >= 72 && actScore[i] <= 74) {
                GPA = 2.3;
            } else if(actScore[i] >= 68 && actScore[i] <= 71) {
                GPA = 2.0;
            } else if(actScore[i] >= 64 && actScore[i] <= 67) {
                GPA = 1.5;
            } else if(actScore[i] >= 60 && actScore[i] <= 63) {
                GPA = 1.0;
            } else {
                GPA = 0;
            }
            double gradePoint = GPA * credit[i]; // 学分绩点
            totalGPA += gradePoint; // 40.3
        }
        sumGPA = totalGPA / sumCredit;
        System.out.printf("%.2f", sumGPA);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] credit = new int[n]; // 课程学分
        int[] actScore = new int[n]; // 课程实际得分
        for (int i = 0; i < n; i++) {
            credit[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            actScore[i] = scanner.nextInt();
        }
        total_Grade_Point(credit, actScore);
    }
}
