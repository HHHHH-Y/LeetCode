/**
 * Created with IntelliJ IDEA.
 * Description: 单例模式之饿汉模式
 * User: HHH.Y
 * Date: 2020-09-05
 */
public class SingletonStarve {
    // 懒汉模式, 单例对象一开始就已经创建好了
    private static final SingletonStarve instance;
    static {
        instance = new SingletonStarve();
    }
    public static SingletonStarve getInstance() {
        return instance;
    }
    private SingletonStarve() {};
}
