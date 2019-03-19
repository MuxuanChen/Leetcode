package map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2019-03-18
 */
public class ValidAnagram242 {
    public static boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        Arrays.sort(sc);
        System.out.println(sc);
        char[] tc = t.toCharArray();
        Arrays.sort(tc);
        System.out.println(tc);
        return Arrays.equals(sc,tc);
    }

    public static boolean isAnagram2(String s, String t) {
        Map<Character,Integer> sm = new HashMap();
        for (char c : s.toCharArray()) {
            if (sm.get(c) == null){
                sm.put(c,1);
            }else{
                Integer count = sm.get(c);
                count++;
                sm.put(c,count);
            }
        }

        Map<Character,Integer> tm = new HashMap();
        for (char c : t.toCharArray()) {
            if (tm.get(c) == null){
                tm.put(c,1);
            }else{
                Integer count = tm.get(c);
                count++;
                tm.put(c,count);
            }
        }

        return sm.equals(tm);
    }

    public static void main(String[] args) {
        boolean anagram = isAnagram2("anagram", "nagaram");

        System.out.println(anagram);
    }

}
