import java.util.HashMap;

//make a 3 index long array name nums
public class TwoSum{


    public static int[] twoSum(int[] nums, int target){

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int complement  = target - nums[i];

            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};

            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int target = 5;
        int[] result = twoSum(nums, target);


        System.out.println("Indices: " + result[0] + ", " + result[1]);}
    }

