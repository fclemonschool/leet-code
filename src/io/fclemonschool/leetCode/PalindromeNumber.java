package io.fclemonschool.leetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.IntStream;

public class PalindromeNumber {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    char[] original = String.valueOf(x).toCharArray();
    char[] target = new char[original.length];
    Deque<Character> charDeque = new ArrayDeque<>();
    for (char c : original) {
      charDeque.push(c);
    }
    IntStream.range(0, charDeque.size()).forEach(i -> target[i] = charDeque.pop());
    return Arrays.toString(original).equals(Arrays.toString(target));
  }
}
