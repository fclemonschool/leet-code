package io.fclemonschool.leetCode;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors.
 * '#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Example 1:
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 *
 * Example 2:
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 *
 * Example 3:
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 *
 * Constraints:
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 *
 * Follow up: Can you solve it in O(n) time and O(1) space?
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        return deleteBackspace(s).equals(deleteBackspace(t));
    }

    public String deleteBackspace(String s) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        for (char c : s.toCharArray()) {
            if (c != '#') {
                result.append(c);
                index++;
            } else {
                if (index > 0) {
                    index--;
                }
                if (result.length() > 0) {
                    result.deleteCharAt(index);
                }
            }
        }
        return result.toString();
    }
}
