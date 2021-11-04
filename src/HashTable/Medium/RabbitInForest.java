package HashTable.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * create by gaoyang on 2019/8/20
 */
public class RabbitInForest {
    public int numRabbits(int[] answers){
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        int count =0;

        for(int i=0; i<answers.length; i++) {

            int value = map.getOrDefault(answers[i], 0);
            if(answers[i] + 1 >= value+1) {
                map.put(answers[i],value+1);
            } else {
                count += answers[i]+1;
                map.put(answers[i], 1);
            }

        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            count += entry.getKey() + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] answers = {0,0,1,1,1};
        RabbitInForest ri = new RabbitInForest();
        ri.numRabbits(answers);

    }
}
