class Solution {
    public int searchInsert(int[] arr, int k) {
        int l = 0;int r = arr.length-1;
        // if(k<arr[0])
        //     return 0;
        int ans = arr.length;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(arr[mid]==k)
                return mid;
            if(arr[mid]>k)
            {
                ans = mid;
                r = mid-1;
            }
            else
                l= mid+1;
        }
        return ans;
    }
}