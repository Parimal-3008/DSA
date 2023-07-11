class Solution {
    public int search(int[] arr, int k) {
        int l = 0;
        int r = arr.length-1;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(k==arr[mid])
                return mid;
            
                if(arr[l]<=arr[mid])
                {
                    if(k<=arr[mid] && k>=arr[l])
                        r=mid-1;
                    else
                        l= mid+1;
                }
                else
                {
                    if(k<=arr[r] && k>=arr[mid])
                        l= mid+1;
                    else
                        r= mid-1;
                }
            
            // System.out.println(l+" "+r);

        }
        return -1;
    }
}