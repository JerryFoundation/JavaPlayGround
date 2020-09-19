package org.jerry;

import java.util.List;

/**
 * @author zhuqianchao
 * @date 18/9/2020 22:34
 */
public class Test15 {

    public static void main(String[] args) {
        List<String> list = List.of("1","2");

        var a = "222";

        String javadoc = """
                {
               "aaa":"2222"
                }
                """;

        System.out.println(javadoc);

        System.out.println(a);

        System.out.println(list);
    }
}
