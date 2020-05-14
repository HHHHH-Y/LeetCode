/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-14
 */
public class TestMain {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(2);
        myCircularQueue.enQueue(4);
        /*myCircularQueue.enQueue(23);
        myCircularQueue.enQueue(34);
        myCircularQueue.enQueue(45);
        myCircularQueue.enQueue(56);
        myCircularQueue.enQueue(67);*/
        System.out.println(myCircularQueue.Rear());
        myCircularQueue.enQueue(9);
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.isEmpty());
        System.out.println(myCircularQueue.deQueue());
        myCircularQueue.enQueue(6);
        myCircularQueue.enQueue(4);
    }
}
