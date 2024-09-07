class Solution {
    public int[] resultsArray(int[][] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int distance[]= new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            int current_distance = Math.abs(arr[i][0])+Math.abs(arr[i][1]);
            pq.add(current_distance);
            if(i<k-1)
                distance[i]=-1;
            else if(i== k-1)
                distance[i]=pq.peek();
            else
            {
                pq.poll();
                distance[i]=pq.peek();
            }
                
        }

        return distance;

    }
}