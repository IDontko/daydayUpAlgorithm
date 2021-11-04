package stack.medium;

import java.util.Arrays;
import java.util.List;

/**
 * 迷你语法分析器
 * https://leetcode-cn.com/problems/mini-parser/
 */
public class Miniparse {

    public NestedInteger deserialize(String s) {
        NestedInteger record = new NestIntegerImpl();
//        Stack<>
        return null;
    }

    public static void main(String[] args) {
        String s = "[123,[456,[789]]]";
        for(String str:  s.split(",")){
            System.out.println(str);
        }
        for(String str:  s.split("\\[")){
            System.out.println(str);
        }
        for(String str:  s.split("\\]")){

            System.out.println(str);
        }
        System.out.println(Arrays.toString(s.split(",")));
    }
}
class
NestIntegerImpl implements NestedInteger{

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return null;
    }

    @Override
    public void setInteger(int value) {

    }

    @Override
    public void add(NestedInteger ni) {

    }

    @Override
    public List<NestedInteger> getList() {
        return null;
    }
}


