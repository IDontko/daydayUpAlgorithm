package Array.easy;

/**
 * @author gaoyang
 * create on 2022/3/17
 * 数组的相对排序
 * https://leetcode-cn.com/problems/relative-sort-array/
 * 思路：
 * 先搞出数组的顺序来
 * 依次判断arr1中数据的顺序。
 */
public class RelativeSortArray {
    public int countCharacters(String[] words, String chars) {
        int[] charArray  = new int[26];
        for(int i = 0; i< chars.length(); i++){
            charArray[chars.charAt(i) - 'a']++;
        }
        int ans = 0;
        for(String word: words){
            int[] charWordArray = new int[26];
            for(int i = 0; i< word.length(); i++){
                charWordArray[word.charAt(i) - 'a']++;
            }
            boolean flag = true;
            for(int j = 0; j < charWordArray.length && flag; j++){
                if (charWordArray[j] > charArray[j]){
                    flag = false;
                }
            }
            if (flag){
                ans++;
            }
        }
        return ans;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            ++frequency[x];
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;
    }

}
