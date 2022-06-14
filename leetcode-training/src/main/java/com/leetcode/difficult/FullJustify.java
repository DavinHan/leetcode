package com.leetcode.difficult;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<String> tmp = new ArrayList<>();
        List<List<String>> sumStr = new ArrayList<>();
        List<String> result = new ArrayList<>();
        int sum = 0;
        for(int i = 0;i < words.length;i++) {
            if((i < words.length - 1 && sum + words[i].length() + 1 < maxWidth)
                    || sum + words[i].length() < maxWidth) {
                tmp.add(words[i]);
                sum += words[i].length() + 1;
            } else {
                sumStr.add(tmp);
                tmp = new ArrayList<>();
                tmp.add(words[i]);
                sum = words[i].length();
            }
        }
        if(!sumStr.contains(tmp)) {
            sumStr.add(tmp);
        }

        for (int i = 0; i < sumStr.size(); i++) {
            int wLen = 0;
            List<String> strArr = sumStr.get(i);
            for (int j = 0; j < strArr.size(); j++) {
                wLen += strArr.get(j).length();
                if(j != strArr.size() - 1) {
                    wLen += 1;
                }
            }
            if(strArr.size() == 1) {
                StringBuilder sb = new StringBuilder(strArr.get(0));
                char[] ch = new char[maxWidth - sb.length()];
                Arrays.fill(ch, ' ');
                sb.append(ch);
                result.add(sb.toString());
                continue;
            }
            int extra = (maxWidth - wLen) / (strArr.size() - 1);
            int extraL = (maxWidth - wLen) % (strArr.size() - 1);
            StringBuilder sb = new StringBuilder();
            if(extraL == 0) {
                for (int j = 0; j < strArr.size(); j++) {
                    sb.append(strArr.get(j));
                    if(i != sumStr.size() - 1) {
                        if (j != strArr.size() - 1) {
                            char[] ch = new char[extra + 1];
                            Arrays.fill(ch, ' ');
                            sb.append(ch);
                        }
                    } else {
                        if(j != strArr.size() - 1) {
                            sb.append(" ");
                        } else {
                            char[] ch = new char[maxWidth - sb.length()];
                            Arrays.fill(ch, ' ');
                            sb.append(ch);
                        }
                    }
                }
            } else {
                for (int j = 0; j < strArr.size(); j++) {
                    sb.append(strArr.get(j));
                    if(i != sumStr.size() - 1) {
                        if(j == 0) {
                            char[] ch = new char[extraL + 1];
                            Arrays.fill(ch, ' ');
                            sb.append(ch);
                        } else if (j != strArr.size() - 1) {
                            char[] ch = new char[extra + 1];
                            Arrays.fill(ch, ' ');
                            sb.append(ch);
                        }
                    } else {
                        if(j != strArr.size() - 1) {
                            sb.append(" ");
                        } else {
                            char[] ch = new char[maxWidth - sb.length()];
                            Arrays.fill(ch, ' ');
                            sb.append(ch);
                        }
                    }
                }
            }
            result.add(sb.toString());
        }
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
