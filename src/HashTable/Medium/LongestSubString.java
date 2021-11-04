package HashTable.Medium;

/**
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 最长不重复子串
 */
public class LongestSubString {
    public static int lengthOfLongestSubstring(String s) {
        int result  = 0;
        if(s.length()==0){
            System.out.println(result);
            return 1;
        }
        char[] sArray = s.toCharArray();
        for(int i = 0;i<sArray.length;i++){
            String tempString = String.valueOf(sArray[i]);
            for(int j = i+1;j<sArray.length;j++){
                result = Math.max(tempString.length(),result);
                if(tempString.indexOf(sArray[j])<0) {
                    tempString+=sArray[j];
                }else{
                    break;
                }

            }


        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        String b = "";
        int output = 3;
        LongestSubString.lengthOfLongestSubstring(s);
    }
}