package com.leetcode.difficult;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * @author yanhanf
 */
public class FullJustify {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> wordList = new ArrayList<>();
        int i = 0, len = words.length;
        int tmpLen = 0;
        List<String> tmpWords = new ArrayList<>();
        wordList.add(tmpWords);
        while(i < len) {
            int wordLen = words[i].length();
            if(tmpLen + wordLen <= maxWidth) {
                if(tmpLen + wordLen + 1 < maxWidth) {
                    tmpWords.add(words[i]);
                    tmpLen += wordLen + 1;
                    i++;
                } else if (tmpLen + wordLen == maxWidth) {
                    tmpWords.add(words[i]);
                    tmpLen += wordLen;
                    i++;
                }
            } else {
                tmpLen = 0;
                tmpWords = new ArrayList<>();
                wordList.add(tmpWords);
            }
        }

        System.out.println(wordList);

        List<String> result = new ArrayList<>();



        return result;
    }

    public static void main(String[] args) {
        System.out.println("[" +
                " \"This  is  an\"," +
                " \"example of text\"," +
                " \"justification. \"" +
                "] ---> " + fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println("[" +
                " \"What  must  be\"," +
                " \"acknowledgment \"," +
                " \"shall be    \"" +
                "] ---> " + fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
        System.out.println("[" +
                " \"Science is what we\"," +
                "  \"understand   well\"," +
                " \"enough to explain to\"," +
                " \"a computer. Art is\"," +
                " \"everything else we\"," +
                " \"do         \"" +
                "] ---> " + fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"}, 20));
    }

}
