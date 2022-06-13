class Solution {
    public int lengthOfLIS(int[] arr) {
        int len =0;
        int ans[]= new int[arr.length];
        ans[0]=arr[0];
        len++;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]<ans[0])
            {
                ans[0]=arr[i];
            }
            else if(arr[i]>ans[len-1])
                ans[len++]=arr[i];
            
            else
            {
                ans[replace(ans,-1,len,arr[i])]=arr[i];
            }
        }
        return len;
        
    }
    public int replace(int arr[],int l, int r, int k)
    {
        while(r-l>1)
        {
            int mid = l+(r-l)/2;
            if(arr[mid]>=k)
                r = mid;
            else
                l=mid;
            
        }
        return r;
    }
}