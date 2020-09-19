package test;

/**
 * @author zhuqianchao
 * @date 2019-03-14 17:40
 */
public class RunTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        BeanTest test = BeanTest.class.newInstance();
        test.setSize(21);
        System.out.println(CheckTest.check(test));

    }
}
