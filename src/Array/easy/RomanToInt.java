package Array.easy;

import com.sun.deploy.nativesandbox.NativeSandboxBroker;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
        if (s == null || s == ""){
            return 0;
        }
        Map<Character,Integer> map  = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] arrays = s.toCharArray();
        int prev = -1;
        int result = 0;
        for(int i = 0; i< arrays.length; i++){
            int current = map.get(arrays[i]);
            if (prev != -1){
                if (prev < current){
                    result -= (prev * 2);
                }
            }
            result += current;
            prev = current;
        }
        return result;

    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        new RomanToInt().romanToInt(s);
    }
}
