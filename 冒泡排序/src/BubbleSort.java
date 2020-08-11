import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 冒泡排序
 * 算法思想:
 * 每次比较相邻位置的元素, 如果前者大于后者, 则进行交换, 不断地将最大值向后移动, 直到移到最后的位置
 * User: HHH.Y
 * Date: 2020-08-11
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 3, 6, 4, 5, 8, 0};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
