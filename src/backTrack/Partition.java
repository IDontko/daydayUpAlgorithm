package backTrack;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class Partition {

    private List<List<String>> ans = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return ans;
    }

    private void backTracking(String s,  int startIndex){
        if (startIndex >= s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)){
                String str = s.substring(startIndex, i + 1);
                path.add(str);
            } else {
                continue;
            }
            backTracking(s, i +  1);
            path.remove(path.size() -1 );
        }
    }

    private boolean isPalindrome(String s, int startIndex, int end){
        for (int i = startIndex, j = end; i < j ; i++, j--) {
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
