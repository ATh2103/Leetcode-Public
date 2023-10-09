class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        
        res[0] = binarySearch(nums, target, false);
        res[1] = binarySearch(nums, target, true);
        return res;
    }

    public static int binarySearch(int[] nums, int target, boolean Lbias){
        int left = 0;
        int right = nums.length-1; 
        int i = -1;
        while(left <= right){
            int mid = (right - left) + left/2;
            if(target > nums[mid])     left = mid+1;
            else if(target < nums[mid])    right = mid-1;
            else{
                i = mid;
                if(Lbias)  left = mid+1;
                else   right = mid-1;
            }
        }
        return i;
    }
}