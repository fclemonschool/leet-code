package io.fclemonschool.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 * Constraints:
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, 0, result, subset);
        return result;
    }

    private static void backtrack(int[] array, int i, List<List<Integer>> result, List<Integer> path) {
        if (i == array.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        path.add(array[i]);
        backtrack(array, i + 1, result, path);
        path.remove(path.size() - 1); // undo - backtracking
        backtrack(array, i + 1, result, path);
    }

    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3, 4, 5});
    }
}
