class Solution {
    public int search(int[] arr, int k) {
        int l=0; int r=arr.length-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(arr[mid]>k)
                r=mid-1;
            else if(arr[mid]<k)
                l=mid+1;
            else
                return mid;
        }
        return -1;
    }
}