import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 电话号码
 * 输入描述:
 * 每组数据第一行包含一个正整数 n (1 <= n , 1024)
 * 紧接着 n 行, 每行包含一个电话号码, 电话号码仅由连字符"-", 数字和大写字母组成
 * 没有连续出现的连字符, 并且排除连字符后长度始终为 7 (美国电话号码只有 7 位)
 *
 * 输出描述:
 * 对应每一组输入, 按照字典顺序输出不重复的标准数字形式电话号码, 即"xxx-xxxx"形式
 * 每个电话号码占一行, 每组数据之后输出一个空行作为间隔符
 * User: HHH.Y
 * Date: 2020-07-20
 */
public class TelephoneNumber {
    public static void main(String[] args) {
        // 将所有的可能出现的字母和数字全部放进字符串中
       String symbol = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
       // 将其对应的字母和数字也放进字符串中
       String number = "222333444555666777788899990123456789";
       Scanner scanner = new Scanner(System.in);;
       while (scanner.hasNext()) {
           int n = scanner.nextInt();
           // 准备一个集合, 用来存放转换好的电话号码
           ArrayList<String> arrayList = new ArrayList<>();
           for (int i = 0; i < n; i++) {
               String str = scanner.next();
               // 将所有的 - 替换成 ""
               str = str.replace("-", "");
               String result = "";
               for (int j = 0; j < 7; j++) {
                   // 遍历电话号的每个字符, 找出其转换后的数字
                   result += number.charAt(symbol.indexOf(str.charAt(j) + ""));
               }
               // 将最终的结果拼接成要求的格式
               result = result.substring(0, 3) + "-" + result.substring(3, 7);
               // 将所有的电话号码去重
               if(!arrayList.contains(result)) {
                   arrayList.add(result);
               }
           }
           // 进行排序
           Collections.sort(arrayList);
           for (int j = 0; j < arrayList.size(); j++) {
               System.out.println(arrayList.get(j));
           }
           System.out.println();
       }
    }
}
