package io.fclemonschool.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 * Constraints:
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 */
public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> pMap = new HashMap<>();
        makeCharacterMap(p, pMap);

        int index = 0;
        HashMap<Character, Integer> tempMap = new HashMap<>();
        while (index <= s.length() - p.length()) {
            if (tempMap.isEmpty()) {
                makeCharacterMap(s.substring(index, index + p.length()), tempMap);
            } else {
                char before = s.charAt(index - 1);
                putOrAddKeyValue(tempMap, s.charAt(index + p.length() - 1));
                if (tempMap.containsKey(before)) {
                    if (tempMap.get(before) == 1) {
                        tempMap.remove(before);
                    } else {
                        tempMap.put(before, tempMap.get(before) - 1);
                    }
                }
            }
            if (tempMap.equals(pMap)) {
                result.add(index);
            }
            index++;
        }

        return result;
    }

    private void makeCharacterMap(String p, HashMap<Character, Integer> pMap) {
        for (char c : p.toCharArray()){
            putOrAddKeyValue(pMap, c);
        }
    }

    private void putOrAddKeyValue(HashMap<Character, Integer> pMap, char c) {
        if (pMap.containsKey(c)) {
            pMap.put(c, pMap.get(c) + 1);
        } else {
            pMap.put(c, 1);
        }
    }
}
