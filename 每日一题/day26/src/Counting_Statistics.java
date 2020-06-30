import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 计票统计
 * User: HHH.Y
 * Date: 2020-06-30
 */
public class Counting_Statistics {
    private static void result(String[] canName, String[] vote) {
        Map<String, Integer> resMap = new HashMap<>();
        int invalidVote = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < canName.length; i++) {
            list.add(canName[i]);
        }
        for (int i = 0; i < canName.length; i++) {
            resMap.put(canName[i], null);
        }
        for (int i = 0; i < vote.length; i++) {
            if(list.contains(vote[i])) {
                if(resMap.get(vote[i]) == null) {
                    resMap.put(vote[i], 1);
                } else {
                    resMap.put(vote[i], resMap.get(vote[i]) + 1);
                }
            } else {
                invalidVote++;
            }
        }
        for (int i = 0; i < canName.length; i++) {
            if(resMap.get(canName[i]) == null) {
                System.out.println(canName[i] + " : " + "0");
            } else {
                System.out.println(canName[i] + " : " + resMap.get(canName[i]));
            }
        }
        System.out.println("Invalid : " + invalidVote);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int canNum = scanner.nextInt(); // 候选人的人数
            String[] canName = new String[canNum]; // 候选人姓名
            for (int i = 0; i < canNum; i++) {
                canName[i] = scanner.next();
            }
            int voteNum = scanner.nextInt(); // 投票人数
            String[] vote = new String[voteNum]; // 投票
            for (int i = 0; i < voteNum; i++) {
                vote[i] = scanner.next();
            }
            result(canName, vote);
        }
    }
}


