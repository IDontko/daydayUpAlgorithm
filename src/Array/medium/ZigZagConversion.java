package Array.medium;

import java.util.Arrays;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < res.length; i++) {
            res[i] = new StringBuilder();
        }
        int len = s.length();
        int index = 0;
        int rows = 0;
        while(index < len){
            while (index < len && rows < numRows){
                char ch = s.charAt(index++);
                res[rows].append(ch);
                rows++;
            }
            rows = numRows -2 ;
            while (index < len && rows >=0 ){
                char ch = s.charAt(index++);
                res[rows--].append(ch);
            }
            rows = 1;
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<numRows; i++){
            ans.append(res[i]);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        int a =10;
        int b = 4;
        int c = 20;
        int d = 6;
        System.out.println(a++*b+c*--d);
    }
}
