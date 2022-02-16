package Array.easy;

/**
 * @author gaoyang
 * create on 2022/2/16
 * https://leetcode-cn.com/problems/can-place-flowers/
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanPlaceFlowers {
    //错误解题 没有包含 flowerbed = [0], n =1的情况
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //相邻花会争夺死去。所以花的结构必须是 1 0 1 0 1 这种结构
        for (int i = 0; i < flowerbed.length && n>0 ; i++) {
            if (checkPlace(flowerbed,i)){
                flowerbed[i] = 1;
                n--;
            }
        }
        if (n == 0){
            return true;
        }
        return false;
    }

    private boolean checkPlace(int[] flowerbed, int index){
        if (index == 0 && flowerbed[0] == 0 && flowerbed[1] == 0){
            return true;
        }else if (index == flowerbed.length -1 && flowerbed[index] == 0 &&  flowerbed[flowerbed.length - 2] == 0){
            return true;
        } else {
            if (flowerbed[index] == 0 && flowerbed[index - 1] != 1 && flowerbed[index + 1] != 1){
                return true;
            }
        }
        return false;
    }


    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        for (int i = 0, len = flowerbed.length; i < len && n > 0; ) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                n--;
                i += 2;
            } else {
                i += 3;
            }
        }
        return n <= 0;
    }


    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,0,0,0,1};
        int n = 2;
        CanPlaceFlowers obj = new CanPlaceFlowers();
        obj.canPlaceFlowers(flowerbed, n);

    }
}

