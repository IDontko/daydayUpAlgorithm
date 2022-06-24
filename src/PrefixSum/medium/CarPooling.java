package PrefixSum.medium;

/**
 * @author gaoyang
 * create on 2022/6/24、
 * 车上最初有capacity个空座位。车只能向一个方向行驶（也就是说，不允许掉头或改变方向）
 *
 * 给定整数capacity和一个数组 trips , trip[i] = [numPassengersi, fromi, toi]表示第 i 次旅行有numPassengersi乘客，
 * 接他们和放他们的位置分别是fromi和toi。这些位置是从汽车的初始位置向东的公里数。
 *
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回true，否则请返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/car-pooling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int[] sum = new int[1000];

        for (int i = 0; i < n; i++) {
            int numPassenger = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];
            for (int j = from ; j < to ; j++){
                sum[j] += numPassenger;
                if (sum[j] > capacity){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 差分法 牛，比前缀和更好一点
     * @param trips
     * @param capacity
     * @return
     */
    public boolean carPooling2(int[][] trips, int capacity) {
        int[] diff=new int[1001];
        for(int[] trip:trips){
            diff[trip[1]]+=trip[0];
            if(trip[2]<diff.length){
                diff[trip[2]]-=trip[0];
            }
        }
        //先单独判断diff[0]是否超载
        if(diff[0]>capacity) return false;
        for(int i=1;i<diff.length;i++){
            diff[i]+=diff[i-1];
            if(diff[i]>capacity){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        int[][] trips = {{2,1,5},{3,5,7}};
        int capacity  = 3;
        new CarPooling().carPooling(trips, capacity);
    }
}
