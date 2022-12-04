package Array.easy;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = getCommonStr(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }

        return prefix;
    }

    private String getCommonStr(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }else {
            return divideStr(strs, 0 , strs.length - 1);
        }

    }

    private String divideStr(String[] strs, int left, int right){
        if (left == right){
            return strs[left];
        }else {
            int mid = left + (right - left) /2;
            String strLeft = divideStr(strs, left, mid);
            String strRight = divideStr(strs, mid + 1, right);
            return getCommonPrefix(strLeft, strRight);
        }
    }

    private String getCommonPrefix(String strLeft, String strRight){
        int minLength = Math.min(strLeft.length(), strRight.length());
        for (int i = 0; i < minLength; i++) {
            if (strLeft.charAt(i) != strRight.charAt(i)){
                return strLeft.substring(0, i);
            }
        }
        return strLeft.substring(0, minLength);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        new LongestCommonPrefix().longestCommonPrefix2(strs);
    }
}
