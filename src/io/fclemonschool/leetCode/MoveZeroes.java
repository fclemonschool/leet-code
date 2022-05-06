package io.fclemonschool.leetCode;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1

Follow up: Could you minimize the total number of operations done?
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int tempArrayCount = 0;
        int[] tempArray = new int[nums.length];

        for (int num : nums) {
            if (num != 0) {
                tempArray[tempArrayCount] = num;
                tempArrayCount++;
            }
        }
        System.arraycopy(tempArray, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        moveZeroes(new int[] {0, 1, 0, 3, 12});
    }
}
