package Array.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author gaoyang
 * create on 2022/4/18
 */
public class Test {

    private static List<Student> list = new ArrayList<>();

    static {
        Student s1 = new Student("1", "老大");
        Student s2 = new Student("1", "老二");
        Student s3 = new Student("2", "老三");
        Student s4 = new Student("2", "老四");
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
    }

    public static void main(String[] args) {
        ArrayList<Student> collect1 = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getId))), ArrayList::new));
        List<Student> collect = list.stream().filter(item -> item.getId().equals("1")).collect(Collectors.toList());
        list.removeIf(item -> item.getId().equals("1"));
        for (int i = 0; i < collect.size() ; i++) {
            if (collect.get(i).getClass().equals("老大")){
                System.out.println("匹配到老大");
                Student student = new Student("3","老大换了");

            }
        }
        collect1.forEach(x -> System.out.println(x.getId() + "-" + x.getName()));

    }

}
