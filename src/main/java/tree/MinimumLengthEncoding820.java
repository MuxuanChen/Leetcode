package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 820. 单词的压缩编码
 * <p>
 * Trie字典树的应用
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-28
 */
public class MinimumLengthEncoding820 {
    public int minimumLengthEncoding(String[] words) {
        //根节点
        TrieNode root = new TrieNode();
        //根据字符串首字母保存字符串索引位置
        Map<TrieNode, Integer> letter2Index = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            //每个单词都挂到同一个根节点上，形成一颗字母树
            TrieNode cur = root;
            for (int j = word.length() - 1; j >= 0; j--) {
                cur = cur.get(word.charAt(j));
            }
            letter2Index.put(cur, i);
        }

        int ans = 0;
        for (TrieNode node : letter2Index.keySet()) {
            //只计数完整的单词，不计数前缀
            if (node.count == 0) {
                ans += words[letter2Index.get(node)].length() + 1;
            }
        }
        return ans;
    }

    private class TrieNode {
        //子节点
        TrieNode[] children;
        //子节点计数
        int count;

        public TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }

        public TrieNode get(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
                count++;
            }
            return children[c - 'a'];
        }
    }
}
