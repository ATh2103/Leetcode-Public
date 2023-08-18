class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int rank = 0;   // finding max rank
        for(int i=0; i<n; i++){             //outer loop 
            for(int j=i+1; j<n; j++){       // inner loop
                int count  = 0;
                for(int[] road: roads){
                    // condition for rank (whether node is connected to other road or not)
                    if(road[0] == i || road[0] == j || road[1] == i || road[1] == j)    count++;
                } 
                rank = Math.max(rank , count);
            }
        }
        //returning rank
        return rank;
    }
}