package test.javacore.test;

/**
 * @author zhuqianchao
 * @date 2020/8/29 19:25
 */
public class Man implements PersonInterface {
    @Override
    public void run(int time) {
        System.out.println(time);
    }

    @Override
    public void say() {
        System.out.println("man");
    }
}
