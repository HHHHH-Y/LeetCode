/**
 * Created with IntelliJ IDEA.
 * Description: 单例模式之懒汉模式
 * 使用 volatile + synchronized + 双重判断 保证懒汉模式的线程安全
 * User: HHH.Y
 * Date: 2020-09-05
 */
public class SingletonLazy {
    // 先创建一个变量, 使用 volatile 修饰
    private static volatile SingletonLazy instance = null;
    // 调用这个方法的时候再创建, 使用双重判断 + synchronized
    public static SingletonLazy getInstance() {
        if(instance == null) {
            synchronized (SingletonLazy.class) {
                if(instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
    private SingletonLazy() {}
}
