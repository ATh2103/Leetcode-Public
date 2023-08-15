class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length)    return nums;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>((n1 , n2) -> map.get(n1) - map.get(n2));
        for(int n: map.keySet()){
            queue.offer(n);
            if(queue.size() > k)    queue.poll();
        }

        int[] res = new int[k];
        for(int i=k-1; i>=0; i--){
            res[i] = queue.poll();
        }
        return res;
    }
}