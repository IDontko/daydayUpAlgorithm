package Imitate;

public class Multiply {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m1 = num1.length();
        int m2 = num2.length();
        int[] ans = new int[m1 + m2];
        for (int i = m1 - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = m2 - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ans[i + j + 1] += x * y;
            }
        }
        for (int i = m1 + m2 - 1; i > 0; i--) {
            ans[i - 1] += ans[i]/10;
            ans[i] %= 10;
        }
        int index = ans[0] == 0 ? 1 : 0;
        StringBuffer result = new StringBuffer();
        while (index < m1 + m2) {
            result.append(ans[index]);
            index++;
        }
        return result.toString();
    }

    /**
     * 官方答案
     * @param num1
     * @param num2
     * @return
     */
    public String answer(String num1, String num2){
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }



    public static void main(String[] args) {
        new Multiply().multiply("123", "132");
    }
}
