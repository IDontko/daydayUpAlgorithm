package stack.medium;

/**
 * @author gaoayang
 * create by gaoyang on 2020/9/4
 * https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/solution/yan-zheng-er-cha-shu-de-qian-xu-xu-lie-hua-by-leet/
 * 验证 前序遍历
 */
public class VerifyPreOrder {

    public boolean isValidSerialization(String preorder) {
        int slots = 1;

        for(String s : preorder.split(",")){
            --slots;
            if (slots< 0) {
                return false;
            }
            if(!s.equals("#")){
                slots += 2;
            }
        }

        return slots == 0;
    }


}
