/**
 * Created with IntelliJ IDEA.
 * Description:关于反射
 * User: HHH.Y
 * Date: 2020-09-12
 */
class Student {
    // 私有属性 name
    private String name = "guyueyue";
    // 公有属性 age
    public int age = 21;
    // 不带参数的构造方法
    public Student() {
        System.out.println("Student()");
    }
    // 带参数的私有构造方法
    private Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Student(name, age)");
    }
    // 提供各种方法(共有的方法 和 私有的方法)
    public void eat() {
        System.out.println("I am eat");
    }

    public void sleep() {
        System.out.println("I am sleep");
    }

    private void function(String str) {
        System.out.println(str);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Reflex {
    public static void main(String[] args) {
        // 1. 通过 getClass() 获取 class 对象
        Student student = new Student();
        Class c1 = student.getClass();

        // 2. 直接通过 类名.class 的方式获取
        Class c2 = Student.class;

        // 3. 使用 Class.forName("类的全路径") 获取, 但是可能会抛出 ClassNotFoundException 异常
        Class c3 = null;
        try {
            c3 = Class.forName("Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 在一个 JVM 中只会有一个 Class 实例, 所以对上述产生的 Class 文件进行一个比较
        System.out.println(c1.equals(c2));
        System.out.println(c2.equals(c3));
        System.out.println(c1.equals(c3));
    }
}
