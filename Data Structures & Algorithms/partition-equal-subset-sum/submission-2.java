class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        int sum = 0;
        for(int n: nums){
            sum += n;
        }
        if(sum % 2 != 0)
        return false;
        target = sum/2;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);


        for(int i = 0; i < nums.length; i++){
            HashSet<Integer> dupSet = new HashSet<>();
            for(int n: set){
                if(n+nums[i] == target)
                return true;

                dupSet.add(n+nums[i]);
                dupSet.add(n);
            }
            set = dupSet;
        }
        return false;
    }
}
