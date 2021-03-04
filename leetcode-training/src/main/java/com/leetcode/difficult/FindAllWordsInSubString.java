package com.leetcode.difficult;

import java.util.*;

/**
 * find the starting position of the substrings in the string consisting of the given array of characters.
 */
public class FindAllWordsInSubString {

    /**
     * Time Limit Exceeded
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        boolean[] isUsed = new boolean[words.length];
        int pos = 0;
        int len = s.toCharArray().length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0;i < words.length;i++) {
            pos = -1;
            while ((pos = s.indexOf(words[i], pos + 1)) > -1) {
                if(map.containsKey(pos)) {
                    map.get(pos).add(i);
                } else {
                    List<Integer> l = new ArrayList<>(Arrays.asList(i));
                    map.put(pos, l);
                }
            }
        }
        int count = 0;
        int lll = -1;
        for(int i = 0;i < len;i++) {
            pos = -1;
            int k = i;
            count = 0;
            while (map.containsKey(k)) {
                List<Integer> list = map.get(k);
                boolean can = false;
                for (Integer li : list) {
                    if(!isUsed[li]) {
                        isUsed[li] = true;
                        can = true;
                        lll = words[li].length();
                        break;
                    }
                }
                if(can == true) {
                    if (pos == -1) {
                        pos = k;
                    }
                    count++;
                    k += lll;
                    if (count == words.length) {
                        result.add(pos);
                        break;
                    }
                } else {
                    break;
                }
            }
            for(int j = 0;j < words.length;j++) {
                isUsed[j] = false;
            }
        }
        return result;
    }

    public static List<Integer> findSubstringByTwoMap(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int len = s.length();
        int wordLen = words.length;
        if(wordLen == 0) {
            return result;
        }
        int wordSize = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0;i < words.length;i++) {
            int value = map.getOrDefault(words[i], 0);
            map.put(words[i], value + 1);
        }

        //遍历所有子串，并不意味着循环len遍，而是仅循环所有子串的第一次pos
        int subStartLen = len - wordLen * wordSize + 1;

        for(int i = 0;i < subStartLen;i++) {
            Map<String, Integer> map2 = new HashMap<>();
            int num = 0;
            for(num = 0;num < wordLen;num++) {
                String subWord = s.substring(i + num * wordSize, i + (num + 1) * wordSize);
                if(map.containsKey(subWord)) {
                    int value = map2.getOrDefault(subWord, 0);
                    map2.put(subWord, value + 1);
                    if(map2.get(subWord) > map.get(subWord)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if(num == wordLen) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findSubstringByTwoMap("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"}));
    }
}
