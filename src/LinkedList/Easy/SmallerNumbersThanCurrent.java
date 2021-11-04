package LinkedList.Easy;

/**
 * @author gaoayang
 * create by gaoyang on 2020/3/2
 */
public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
                if (j == nums.length - 1) {
                    result[i] = count;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
///*        int[] nums1 = {6, 5, 4, 8};
//        int[] nums = {8, 1, 2, 2, 3};
//        SmallerNumbersThanCurrent sn = new SmallerNumbersThanCurrent();
//        int[] result = sn.smallerNumbersThanCurrent(nums);
//        System.out.println(Arrays.toString(result));*/
        String str = "物品已经回寄，生成换货订单：S1237669276851986432";
        System.out.println(str.split("物品已经回寄，生成换货订单：").length);
        if(str.split("物品已经回寄，生成换货订单：").length > 1){
            System.out.println(str.split("物品已经回寄，生成换货订单：")[1]);
        }

    }


}
