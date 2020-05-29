import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 前 k 个高频单词
 * TopK 问题: 需要建立一个小堆
 * User: HHH.Y
 * Date: 2020-05-28
 */
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // 1. 将所有单词以及它的频度都存放在 Map 集合中.
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if(map.get(words[i]) == null) {
                map.put(words[i], 1);
            } else {
                int num = map.get(words[i]);
                map.put(words[i], num + 1);
            }
        }
        // 由于 PriorityQueue 底层就已经是一个小根堆了
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 在进堆时对其进行比较, 以频度从高到低的顺序进堆, 频度相同的单词, 比较其首字母
                return map.get(o1).equals(map.get(o2)) ? o2.compareTo(o1) : map.get(o1) - map.get(o2);
            }
        });
        // 将所有的 key 值全部放入优先级队列中
        // 但是要保证优先级队列中只有 k 个单词.
        for (String str:map.keySet()) {
            priorityQueue.offer(str);
            if(priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        // 再将优先级队列中的元素全部放入list集合中
        // 由于优先级队列底层是小堆, 所以在放入list集合时, 是按照频度递增的顺序排放的, 因此, 需要进行反转
        List<String> list = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        while (!priorityQueue.isEmpty()) {
            stack.push(priorityQueue.poll());
            list.add(priorityQueue.poll());
        }
//        Collections.reverse(list);
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
