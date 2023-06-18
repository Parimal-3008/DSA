class Solution {
    public int hIndex(int[] arr) {
        Arrays.sort(arr);
        int l = 0;
        int r = arr[arr.length-1];
        int ans = l;
        while(l<=r)
        {
            int mid = (l + r)/2;
            if(check(mid,arr))
            {
                ans = mid;
                l = mid+1;
            }
            else
                r = mid - 1;
        }
        return ans;
    }
    public boolean check(int mid, int[] arr)
    {
        int count = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>=mid)
                count++;
        }
        return count>=mid;
        
    }
}