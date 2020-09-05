import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 写一个稳定的去除数组中的重复元素
 * 1. 直接创建一个新的数组, 将原数组中不重复的元素全部 copy 到这个新数组中. 但是需要使用一个临时数组进行保存
 * User: HHH.Y
 * Date: 2020-09-04
 */
public class DistinctElements {
    public static void main(String[] args) {
        String[] arr = new String[7];
        arr[0] = "a";
        arr[1] = "a";
        arr[2] = "b";
        arr[3] = "c";
        arr[4] = "d";
        System.out.println(arr.toString());
        for (String s:arr) {
            System.out.println(s);
        }
        System.out.println("=================");
        Object[] s = ifRepeat(arr);
        for (Object o:s) {
            System.out.println(o);
        }
    }

   /* private static Object[] ifRepeat(String[] arr) {
        // 使用 LinkedhashSet 进行过滤
        Set<String> set = new LinkedHashSet<>();
        for (String s:arr) {
            set.add(s);
        }
        return set.toArray();
    }*/



    /*private static Object[] ifRepeat(String[] arr) {
        // 使用 set 集合进行过滤
        Set<String> set = new HashSet<>();
        for (String s:arr) {
            set.add(s);
        }
        return set.toArray();
    }*/


    private static Object[] ifRepeat(String[] arr) {
        // 使用一个集合来存放去重后的数据
        List<String> list = new ArrayList<>();
        // 遍历数组
        for (int i = 0; i < arr.length; i++) {
            // 通过 contains 判断集合中是否已经有相同的数据存在, 如果没有, 则放置进集合中
            if(!list.contains(arr[i])) {
                list.add(arr[i]);
            }
        }
        return list.toArray();
    }

    /*private static Object[] ifRepeat(String[] arr) {
        // 创建一个临时数组, 用来存放去重后的元素, 初始长度设置为 arr 的长度
        Object[] tempArr = new Object[arr.length];
        int index = 0;      // 表示 tempArr 的数组下标

        // 使用双重循环来去掉重复的元素
        for (int i = 0; i < tempArr.length; i++) {
            Boolean isNotSame = true;   // 默认两个元素是不相同的
            for (int j = i + 1; j < tempArr.length; j++) {
                if(arr[j] == arr[i]) {
                    isNotSame = false;
                    break;
                }
            }

            // 只要元素不重复, 就将这个元素存放到临时数组中
            if(isNotSame) {
                tempArr[index++] = arr[i];
            }
        }
        // 创建一个新的数组, 长度为不重复元素的长度
        Object[] newArr = new Object[index];
        // 使用 System.arrayCopy(需要拷贝的数组, 数组的起始下标, 接收的新数组, 起始下标, 结束下标)
        System.arraycopy(tempArr, 0, newArr, 0, index);
        return newArr;
    }*/
}
