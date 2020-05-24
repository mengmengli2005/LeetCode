package Array;
/**双指针：Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * */
public class Two_Sum_II_167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] indices = new int[2];
        if (numbers == null || numbers.length < 2) return indices;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                indices = new int[]{i + 1, j + 1};
                return indices;
            } else if (sum < target) i++;
            else j--;
        }
        return indices;
    }
}
