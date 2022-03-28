class Solution {
    public boolean search(int[] arr, int k) {
        int l=0;
        int r=arr.length-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(arr[mid]==k)
                return true;
            if(arr[l]<arr[mid])
               { 
                if(k<=arr[mid]&&k>=arr[l])
                r=mid-1;
                else
                    l=mid+1;
            }
            else if(arr[mid]<arr[r])
            {
                if(k>=arr[mid]&&k<=arr[r])
                    l=mid+1;
                else
                    r=mid-1;
            }
            else 
            {
                if(arr[r]==k)
                    return true;
                r--;
            }
            
        }
        return false;
    }
}