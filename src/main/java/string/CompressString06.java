package string;

/**
 * 字符串压缩
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-16
 */
public class CompressString06 {
    public String compressString(String S) {
        if (S.isEmpty()){
            return S;
        }
        char current = S.charAt(0);
        StringBuilder sb = new StringBuilder();
        int repeatedNum = 0;
        for (char c : S.toCharArray()) {
            //字符串重复
            if (c != current) {
                sb.append(current);
                sb.append(repeatedNum);
                repeatedNum = 0;
                current = c;
            }
            repeatedNum++;
        }

        sb.append(current);
        sb.append(repeatedNum);
        String res = sb.toString();

        return res.length() >= S.length() ? S : res;
    }
}
