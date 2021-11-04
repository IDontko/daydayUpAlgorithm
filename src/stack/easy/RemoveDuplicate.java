package stack.easy;


/**
 * @author gaoayang
 * create by gaoyang on 2020/8/3
 */
public class RemoveDuplicate {

    public String removeDuplicates1(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1)) {
                sb.deleteCharAt(sbLength-- - 1);
            } else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }


    public String removeDuplicates2(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && String.valueOf(character).toLowerCase() == String.valueOf(sb.charAt(sbLength - 1))) {
                sb.deleteCharAt(sbLength-- - 1);
            } else {
                sb.append(character);
                sbLength++;
            }
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        String s1 = "leEeetcode";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(i);
        }
        stringBuilder.replace(1, 5, "");
        System.out.println(stringBuilder.toString());
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        removeDuplicate.removeDuplicates2(s1);
    }
}
