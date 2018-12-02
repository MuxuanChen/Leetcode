package string;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2018-11-21
 */
public class LowLetter709 {
    public static String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];
            if (originalChar >= 'A' && originalChar <= 'Z'){
                int distance  = 'A' - 'a';
                chars[i] -= distance;
            }
        }
        String upString = String.valueOf(chars);
        return upString;
    }

    public static void main(String[] args) {
        String lowLetter = toLowerCase("abcDASasEd");
        System.out.println(lowLetter);
    }
}
