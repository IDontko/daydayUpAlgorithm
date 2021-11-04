package HashTable.Medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * create by gaoyang on 2019/8/8
 */
public class DailyTemperature {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for(int i = 0 ; i< T.length;i++){
            for(int j = i+1;j<T.length;j++){
                if(T[j]-T[i]>0 ){
                    result[i] = j - i;
                    break;
                }
                result[i] = 0;
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public int[] dailyTemperatures2(int[] T){
        Stack<Integer> stack = new Stack<Integer>();
        int n = T.length;
        int[] result = new int[n];
        for(int i =n-1;i>=0;i--){
            while(!stack.empty()&&T[i]>=T[stack.peek()]){
                stack.pop();
            }
            result[i] = stack.empty()?0:stack.peek()-i;
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemperature dailyTemperature = new DailyTemperature();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        dailyTemperature.dailyTemperatures(T);

    }
}
