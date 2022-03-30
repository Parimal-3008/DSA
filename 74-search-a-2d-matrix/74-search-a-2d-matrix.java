class Solution {
    public boolean searchMatrix(int[][] arr, int k) {
        int i=0;int j=arr.length-1;
        while(i<=j)
        {
            int mid =(i+j)/2;
           
            if(arr[mid][0]<=k&&arr[mid][arr[0].length-1]>=k)
             {   // System.out.println(mid);
                return call(k,mid,arr);
             }
            if(k>arr[mid][arr[0].length-1])
                 i=mid+1;
            
            else if(k<arr[mid][0])
                j=mid-1;
        }
        return false;
    }
    public boolean call(int k, int i, int[][] arr)
    {
        int l=0;
       // System.out.println("call ");
        int r= arr[i].length-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(arr[i][mid]==k)
                return true;
            if(arr[i][mid]>k)
                r=mid-1;
            else
                l=mid+1;
        }
        return false;
    }
}