package backTrack;

import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombination {
    String path;
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        getLetter(digits, map, "");
        System.out.println(ans);
        return ans;
    }

    public void getLetter(String digits, Map<Integer, String> map, String path){
        if (digits.length() == path.length()){
            ans.add(new String(path));
            return;
        }
        char c = digits.charAt(path.length());
        String itemLetter = map.get(c - '0');
        for(Character item: itemLetter.toCharArray()){
            path = path + item.toString();
            getLetter(digits, map, path);
            path = path.substring(0, path.length() - 1);
        }

    }

    public static void main(String[] args) {
        new LetterCombination().letterCombinations("23");
    }
}
