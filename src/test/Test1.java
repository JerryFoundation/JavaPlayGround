package test;

/**
 * @author zhuqianchao
 * @date 2020/8/23 16:04
 */
public class Test1 {

    public static void main(String[] args) {

        TestBean testBean = new TestBean();
        TestBean testBean2 = new TestBean();
        TestBean testBean3 = new TestBean();

        testBean.setParam("aaaa");
        testBean.setNext(testBean2);

        testBean2.setParam("bbbbbb");

        testBean2.setNext(testBean3);

        testBean3.setParam("ccccc");
        testBean3.setNext(null);


        a(testBean);


    }

    public static void a(TestBean testBean) {

        System.out.println(testBean.getParam());
        if (testBean.getNext() != null) {
            a(testBean.getNext());
        }

    }


    static class TestBean {

        private String param;

        private TestBean next;


        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public TestBean getNext() {
            return next;
        }

        public void setNext(TestBean next) {
            this.next = next;
        }
    }
}
