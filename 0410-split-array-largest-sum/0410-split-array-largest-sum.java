class Solution {
    public int splitArray(int[] arr, int k) {
        int l = Integer.MAX_VALUE;
        int r = 0;
        for(int i:arr)
        {
            l= Math.min(l,i);
            r+=i;
        }
        int ans = 0;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(call(mid,arr,k))
            {
                ans  = mid;
                r = mid-1;
            }
            else 
                l = mid+1;
        }
        return ans;
    }
    public boolean call(int mid, int[] arr, int k)
    {
        int count = 1;
        int curr = 0;
        for(int i:arr)
        {
            if(i>mid)
                return false;
            if(curr+i>mid)
            {
               count++;
                curr= i;                    
            }
            else 
                curr+=i;
        }
        if(count>k)
            return false;
        return true;
    }
}