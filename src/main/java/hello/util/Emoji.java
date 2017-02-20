package hello.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/24.
 */
public enum Emoji {
    huaji("huaji.jpg"),yinxian("yinxian.jpg"),rilegou("rilegou.jpg");

    Emoji(String url){
        this.url = "/img/emoji/" + url;
    }
    String url;

    private static Map<Integer,Emoji> emojiMap = new HashMap<>();
    static {
        emojiMap.put(1,huaji);
        emojiMap.put(2,yinxian);
        emojiMap.put(1,rilegou);
    }
    public static String getUrlFromEmoji(int emoji){
        return emojiMap.getOrDefault(emoji,rilegou).toString();
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return url;
    }
}
