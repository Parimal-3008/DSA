class Solution {
    public boolean isBipartite(int[][] arr) {
        int n= arr.length;
        int pvt[] = new int[n];
        Arrays.fill(pvt,0);
        for(int i=0;i<n;i++)
        {
            if(pvt[i]==0 && !call(arr,pvt,i))
                return false;
        }
        
        return true;
    }
    public boolean call(int[][] arr,int[] pvt, int i1)
    {
         Queue<Integer> q= new LinkedList<>();
        q.add(i1);
        pvt[i1]=1;
        while(!q.isEmpty())
        {
            int e = q.poll();
            for(int i:arr[e])
            {
                if(pvt[i]==0)
                {
                    if(pvt[e]==1)
                        pvt[i]=2;
                    else
                        pvt[i]=1;
                    q.add(i);
                }
                else
                {
                    if(pvt[i]==pvt[e])
                        return false;
                }
                    
            }
        }
        return true;
    }
    
}