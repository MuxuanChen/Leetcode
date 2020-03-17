package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 拼写单词
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-17
 */
public class CountCharacters1160 {

    /**
     * 数组计数法
     * <p>
     * 友情提示：遇到有提示字符串仅包含小写（或者大写）英文字母的题，
     * 都可以试着考虑能不能构造长度为26的每个元素分别代表一个字母的数组，来简化计算
     */
    public static int countCharacters(String[] words, String chars) {
        //保存char中每个字符出现的次数
        int[] count = new int[26];
        for (char c : chars.toCharArray()) {
            count[c - 'a'] += 1;
        }

        int wordLength = 0;
        start:
        for (String word : words) {
            int[] wc = new int[26];
            for (char c : word.toCharArray()) {
                wc[c - 'a'] += 1;
            }
            /**
             * 这里用26比word.length()速度快
             */
            for (int i = 0; i < 26; i++) {
                if (wc[i] > count[i]){
                    continue start;
                }
            }
            wordLength += word.length();
        }

        return wordLength;
    }

    /**
     * 方法二：通过判断chars包含words中的每个字母，并且还要记录重复出现的字母，效率比较低；
     * 可以用计数法，只要chars的中的同一个字母的次数出现得比words中的字母次数多就OK
     * <p>
     * 这是一类经典的题型。凡是和“变位词”、“字母顺序打乱”相关的题目，都考虑统计字母出现的次数。
     */
    public static int countCharacters2(String[] words, String chars) {
        int count = 0;
        for (String word : words) {
            boolean isWord = true;
            Set<Integer> indexs = new HashSet<>();
            for (char c : word.toCharArray()) {
                int i = -1;
                do {
                    //判断是否包含字符
                    i = chars.indexOf(c, i + 1);
                } while (indexs.contains(i));
                if (i == -1) {
                    isWord = false;
                    break;
                } else {
                    indexs.add(i);
                }
            }
            indexs.clear();
            if (isWord) {
                count += word.length();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words = {"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin", "ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb", "ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl", "boygirdlggnh", "xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx", "nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop", "hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx", "juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr", "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo", "oxgaskztzroxuntiwlfyufddl", "tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp", "qnagrpfzlyrouolqquytwnwnsqnmuzphne", "eeilfdaookieawrrbvtnqfzcricvhpiv", "sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz", "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue", "hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv", "cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo", "teyygdmmyadppuopvqdodaczob", "qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs", "qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"};
        String chars = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";
        int res = countCharacters(words, chars);
        System.out.println(res);
    }
}
