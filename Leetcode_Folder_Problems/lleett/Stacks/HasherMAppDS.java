import java.util.*;


public class HasherMAppDS {
    
    public static void main(String[] args) {
        
        //have to make our nums array and target integer
        int[] nums = {5,3,2,4};
        int target = 5;

        


        
    }


    public static int[] twoPointer(int[] nums, int target) {
        ///make hashmap
        HashMap<Integer, Integer> map = new HashMap<>();

        for ( int i = 0; i < nums.length; i++ ) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        
        return new int[] {};


    }


}
