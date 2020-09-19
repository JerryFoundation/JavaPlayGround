package test;

import lombok.Data;

/**
 * @author zhuqianchao
 * @date 2019-03-14 17:39
 */
@Data
public class BeanTest {
    @Hello(size = "max")
    Integer size;
}
