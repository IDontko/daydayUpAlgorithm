package StreamTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 流用法测试
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl","aaa");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        /**
         * forEach提供了新的方法 'forEach' 来迭代流中的每个数据, ::冒号前面是调用的对象，后面是所要调的方法。
         */
        strings.forEach(StreamTest::print);

        /**
         * map方法用于映射每个元素到对应的结果，下面代码结果
         * [abcabc, , bcbc, efgefg, abcdabcd, jkljkl]
         */
        List<String> twoStringResult = strings.stream().map((i -> i+i)).distinct().collect(Collectors.toList());
        System.out.println(twoStringResult);

        /**
         * filter通过设置的条件过滤出元素。。
         */
        Long count = strings.stream().filter(i -> i.isEmpty()).count();
        System.out.println(count);

        /**
         *limit是限制数量，以下结果打印出字符串中的前三个
         *
         * limit使用指南----------
         * abc
         *
         * bc
         * ----------------------
         */
        System.out.println("limit使用指南----------");
        strings.stream().limit(3).forEach(StreamTest::print);
        System.out.println("----------------------");

        /**
         * sorted 方法用于对流进行排序。
         * 如下结果是对字符串按照字母表顺序排序
         * Result:
         * Sorted使用指南----------
         *
         *
         * aaa
         * abc
         * abcd
         * bc
         * efg
         * jkl
         * ----------------------
         */
        System.out.println("Sorted使用指南----------");
        strings.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        }).forEach(StreamTest::print);
        System.out.println("----------------------");

        /**
         * Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。
         * Result:
         * Collect使用指南----------
         * [abc, bc, efg, abcd, jkl, aaa]
         * ----------------------
         */
        System.out.println("Collect使用指南----------");
        List<String> collectResult = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(collectResult.toString());
        System.out.println("----------------------");

    }

    public static void print(String str){
        System.out.println(str);
    }

    public static void square(int x){
        System.out.println(x*x);
    }
}
