package io.fclemonschool.leetCode;

/*
Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int result = 0;

        if (target > nums[high]) {
            return nums.length;
        } else if (target < nums[0]) {
            return 0;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                result = mid;
                break;
            }

            if (low > high){
                result = low;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        assert searchInsert(new int[]{1, 3, 5, 6}, 2) == 1;
        assert searchInsert(new int[]{1, 3, 5, 6}, 7) == 4;
    }
}
