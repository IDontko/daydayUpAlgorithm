package Array.easy;

/**
 * @author gaoyang
 * create on 2021/10/15
 * https://leetcode-cn.com/problems/plus-one/
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 输入 : [9] + 1 = [1,0]
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {

        int length = digits.length;
        int[] result = new int[length + 1];
        int currentNum = digits[length - 1] + 1;
        if (currentNum < 10) {
            digits[length - 1] = currentNum;
            return digits;
        }
        int i = length - 1;
        while (i >= 0) {
            int addNum = result[i + 1] + currentNum;
            result[i + 1] = addNum % 10;
            if (addNum >= 10) {
                result[i] = 1;
            }
            if (--i >= 0) {
                currentNum = digits[i];
            }
        }
        int[] finalRes = new int[length];
        if (result[0] == 0) {
            for (int j = 1; j < length; j++) {
                finalRes[j - 1] = result[j];
            }
            return finalRes;
        }
        return result;
    }

    /**
     * 更巧妙的思路 ，牛
     * @param digits
     * @return
     */
    public int[] plusOneTwo(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    public static void main(String[] args) {
        int[] digits = { 9};
        PlusOne.plusOne(digits);
    }
}
