import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description: 实现反射类
 * User: HHH.Y
 * Date: 2020-09-12
 */
public class ReflectClass {
    // 1. 创建对象
    public static void reflectNewInstance() {
        try {
            Class classStudent = Class.forName("Student"); // 通过 Class.forName("类的全路径") 获得 class 对象
            Object objectStudent = classStudent.newInstance(); // 通过 class 对象创建一个对象
            Student student = (Student) objectStudent; // 将这个对象转成 Student 的类型
            System.out.println("获取到学生对象" + student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2. 反射私有的构造方法
    public static void reflectPrivateConstructor() {
        // 通过 Class.forName("类的全路径") 获得 class 对象
        try {
            Class classStudent = Class.forName("Student");
            Constructor declaredConstructorStudent = classStudent.getDeclaredConstructor(String.class, int.class); // 传入对应的参数
            declaredConstructorStudent.setAccessible(true);  // 设置为 true 后可修改访问权限
            Object objectStudent = declaredConstructorStudent.newInstance("kiki", 18); // 修改姓名和年龄
            Student student = (Student) objectStudent;
            System.out.println("获得私有构造函数并且修改姓名和年龄" + student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. 反射私有属性
    private static void reflectPrivateField() {
        // 通过 Class.forName("类的全路径") 获得 class 对象
        try {
            Class classStudent = Class.forName("Student");
            Field field = classStudent.getDeclaredField("name");
            field.setAccessible(true); // 修改为 true 后可以修改访问权限
            Object objectStudent = classStudent.newInstance();
            Student student = (Student) objectStudent;
            field.set(student, "shaking");
            String name = (String)field.get(student);
            System.out.println("反射私有属性修改name为" + name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4. 反射私有方法
    public static void reflectPrivateMethod() {
        try {
            Class classStudent = Class.forName("Student");
            Method method = classStudent.getDeclaredMethod("function", String.class);
            System.out.println("私有方法名为" + method.getName());
            method.setAccessible(true); // 设置为 true 后可以修改私有访问权限
            Object objectStudent = classStudent.newInstance();
            Student student = (Student) objectStudent;
            method.invoke(student, "参数");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
