import java.util.HashMap;

public class TwoSumJava {

    public static void main (String[] args) {
        int[] nums = { 6,5,2,10,3,4,12};
        int target = 13;

       

        int[] result = TwoSumJava.twoSumSolution(nums, target);
        System.out.println("Indices of the two numbers that add up to target: " + result[0] + ", " + result[1]);
    }

    public static int[] twoSumSolution(int[] nums, int target) {

        //given a nums array (use .length not .length())
        //we are also given an integer called target
        //we need to return the indices of the two numbers such that they add up to target
        HashMap <Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}