class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> l1, List<Integer> l2, List<Integer> l3) {
        int[][] arr = new int[k][n];
        int[] stock= new int[n];
         int[] cost= new int[n];
        int[] netcost= new int[k];
        for(int i=0;i<k;i++)
        {
            int tot = 0;
            for(int j=0;j<n;j++)
            {
                arr[i][j]=l1.get(i).get(j);
                stock[j]=l2.get(j);
                cost[j]=l3.get(j);
                tot +=(arr[i][j]*cost[j]);
            }
            netcost[i]=tot;
            
        }
        long max = 0;
        for(int i=0;i<k;i++)
        {
            long l=0;
            long ans = 0;
            long r = 1000000000;
            while(l<=r)
            {
                long mid = (l+r)/2;
                if(check(mid,arr[i],cost,(long)budget,stock))
                {
                    ans = mid;
                    l = mid+1;
                }
                else
                    r = mid-1;
            }
            max = Math.max(max,ans);
        }
        return (int)max;
    }
    public boolean check(long required,int[] arr, int[] cost, long k, int[] stock)
    {
        long curr = 0;
        for(int i=0;i<arr.length;i++)
        {
            long req = Math.max(0,(required* arr[i])-stock[i]);
            curr+= (long)((long)req*(long)cost[i]);
        }
        return curr<=k;
    }
}