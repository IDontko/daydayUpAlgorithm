package Array.easy;

public class CountAndSay {
    public String countAndSay(int n){
        String str = "1";
        for(int i = 2; i<= n; ++i){
            StringBuilder builder = new StringBuilder();
            int start = 0;
            int  pos = 0;
            while(pos < str.length()){
                while(pos < str.length() && str.charAt(start) == str.charAt(pos)){
                    pos++;
                }
                builder.append(Integer.toString(pos - start)).append(str.charAt(start));
                start = pos;
            }
            str = builder.toString();

        }
        return str;
    }

    public static void main(String[] args) {
        int n = 3;
        new CountAndSay().countAndSay(3);
    }
}
