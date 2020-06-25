import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 到底买不买
 * 我们用[0 - 9], [a - z], [A - Z] 范围内的字符来表示颜色.
 * 例如: YrR8RrY 是小红想做的珠串; 那么 ppRYYGrrYBR2258 可以买, 因为包含了全部她想要的珠子, 还多了8颗不需要的珠子;
 * ppRYYGrrYB225 不能买, 因为没有黑色珠子, 并且少了一颗红色的珠子.
 *
 * 输入描述:
 * 每个输入包好一个测试用例. 每个测试用例分别在2行中先后给出摊主的珠串和小红 想要做的珠串, 两串都不超过1000个珠子
 *
 * 输出描述:
 * 如果可以买, 则在一行中输出"Yes"以及有多少多余的珠子; 如果不可以买, 则在一行中输出"No"以及缺了多少珠子. 其中以一个空格分隔
 *
 * 输入:
 * ppRYYGrrYBR2258
 * YrR8RrY
 *
 * 输出:
 * Yes 8
 *
 * 思路:
 * 1. 将摊主和小红的珠子全部变成字符数组的形式
 * 2. 将摊主的珠子放进 map 集合中
 * 3. 遍历小红的珠子
 * 4. 如果摊主的 map 集合中有小红的珠子, map中key对应的value应该减1
 * 5. 如果摊主的 map 集合中没有小红的珠子, 就拼接成字符串.
 * 5. 直接返回
 * User: HHH.Y
 * Date: 2020-06-25
 */
public class BuyOrNotBuy {
   private static void canBuyBeads(String host, String customer) {
      Map<Character, Integer> map = new HashMap<>();
      char[] chars = host.toCharArray(); // 将摊主的珠子全部转换成字符数组
       for (char c:chars) { // 将摊主的所有珠子放进一个 map 表中
//           map.put(c, map.getOrDefault(c, 0) + 1);
           if(map.get(c) == null) {
               map.put(c, 1);
           } else {
               map.put(c, map.get(c) + 1);
           }
       }
       StringBuffer stringBuffer = new StringBuffer();
       boolean flag = true;
       char[] chars1 = customer.toCharArray(); // 将小红的珠子全部转换成字符数组
       for (char x:chars1) { // 遍历小红的珠子数组
           if(map.containsKey(x)) { // 如果摊主的 map 中包含小红的珠子
               int num = map.get(x);
               if(num - 1 == 0) {
                   map.remove(x);
               } else {
                   map.put(x, num - 1);
               }
               continue;
           }
           stringBuffer.append(x); // 如果摊主的 map 中没有小红的珠子
           flag = false;
       }
       if(flag == false) {
           System.out.println("No " + stringBuffer.length());
       } else {
           System.out.println("Yes " + map.size());
       }
   }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String host = scanner.nextLine();
            String customer = scanner.nextLine();
            canBuyBeads(host, customer);
        }
    }
}
