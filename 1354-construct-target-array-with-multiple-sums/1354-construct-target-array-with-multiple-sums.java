class Solution {
    public boolean isPossible(int[] arr) {
        PriorityQueue<Long> pq = new PriorityQueue<Long>((a,b)->Long.compare(b,a));
        long sum = 0;
        if(arr.length==1)
        {
            return arr[0]==1;
        }
        for(int i:arr)
            sum+=(long)i;
        for(int i=0;i<arr.length;i++)
            pq.add((long)arr[i]);
       while (pq.peek() != 1) {
		long curr = pq.poll();
		if (sum - curr == 1) return true;

		long x = curr % (sum - curr);
		sum = sum - curr + x;

		if (x == 0 || x == curr) return false;
		else pq.add(x);
	}

        return true;
        
    }
}