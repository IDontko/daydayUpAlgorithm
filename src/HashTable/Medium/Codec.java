package HashTable.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * create by gaoyang on 2019/8/7
 */
public class Codec {

    Map<String,String> longToShort = new HashMap<>();
    Map<String,String> shortTolong = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(longToShort.containsKey(longUrl)){
            return longToShort.get(longUrl);
        }
        while (true){
            String shortUrl  =  "http://tinyurl.com/" + generateShortUrl();
            if(!shortTolong.containsKey(shortUrl)){
                shortTolong.put(shortUrl,longUrl);
                longToShort.put(longUrl,shortUrl);
                return shortUrl;
            }
        }

    }

    private String generateShortUrl(){
        String charArr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String res = "";
        for(int i =0;i<6;i++){
            Random rand = new Random();
            int index = rand.nextInt(62);
            res += charArr.charAt(index);
        }
        return res;
    }
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(!shortTolong.containsKey(shortUrl)){
            return null;
        }
        return shortTolong.get(shortUrl);
    }
}
