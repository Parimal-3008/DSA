class Solution {
    public int minEatingSpeed(int[] arr, int k) {
        int low= 1;
        int high = 0;
        for(int i:arr)
            high=Math.max(high,i);
        int res=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(canEat(mid,arr,k))
            {
                res= mid;
                high=mid-1;
            }
            else
                low=mid+1;

        }
        return res;
    }
    public boolean canEat(int barrier,int[] arr, int k)
    {
        long count=0;
     
        for(int i=0;i<arr.length;i++)
        {
           count+=(long)Math.ceil((double)arr[i]/(double)barrier);
        }
        if(count<=(long)k)
            return true;
        return false;
    }
}