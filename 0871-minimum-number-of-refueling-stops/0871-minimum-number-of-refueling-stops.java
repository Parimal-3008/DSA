class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
     PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        int ret = 0; int stationId = 0; int range = startFuel;
        while (range < target) {
            while (stationId < stations.length && stations[stationId][0] <= range) {
                pq.offer(stations[stationId++][1]);
            }
            if (pq.isEmpty()) return -1;
            range += pq.peek();
            pq.poll();
            ++ret;
        }
        return ret;
    }
}