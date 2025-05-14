package Day8;

import java.util.Arrays;

class MissingElement {
    public int firstMissingPositive(int[] nums) {

        // using sorting

        Arrays.sort(nums);
        int missing = 1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == missing){
                missing++;
            }
        }

        return missing;


        // using hashset
        // int n=nums.length;
        // HashSet<Integer> set = new HashSet<>();
        // for (int num : nums) {
        //     if (num > 0) {
        //         set.add(num);
        //     }
        // }

        // for (int i = 1; i <= nums.length; i++) {
        //     if (!set.contains(i)) {
        //         return i;
        //     }
        // }
        // return n+1;

    }
}
