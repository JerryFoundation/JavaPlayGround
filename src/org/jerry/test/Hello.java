package org.jerry.test;

import java.lang.annotation.*;

/**
 * @author zhuqianchao
 * @date 2019-03-14 17:36
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Hello {
    String size() default "";
}
