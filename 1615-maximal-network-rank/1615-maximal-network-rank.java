class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] count = new int[n];
        int[][] directRoad = new int[n][n];
        int rank = 0;
        
        for(int[] road: roads){
            count[road[0]]++;
            count[road[1]]++;
            directRoad[road[0]][road[1]]++;
            directRoad[road[1]][road[0]]++;
        }
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                rank = Math.max(rank, count[i] + count[j] - directRoad[i][j]);
            }
        }
        return rank;
    }
}