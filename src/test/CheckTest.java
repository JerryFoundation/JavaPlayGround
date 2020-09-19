package test;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author zhuqianchao
 * @date 2019-03-14 17:42
 */
public class CheckTest {
    public static boolean check(BeanTest test) {
        if (test == null) {
            return false;
        }
        Field[] fields = BeanTest.class.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Hello.class)) {
                Hello hello = field.getAnnotation(Hello.class);
                if (Objects.equals(field.getName(), "size") && Objects.equals(hello.size(), "max")) {
                    if (test.getSize() > 20) {
                        return false;
                    }
                } else if (Objects.equals(field.getName(), "size") && Objects.equals(hello.size(), "min")) {
                    if (test.getSize() > 5) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
