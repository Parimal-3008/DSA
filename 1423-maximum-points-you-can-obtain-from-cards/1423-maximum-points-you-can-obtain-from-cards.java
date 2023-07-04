class Solution {
    public int maxScore(int[] arr, int k) {
        int tot = 0;
        for(int i:arr)
            tot+=i;
         k= arr.length-k;
        int ans = 0;
        int curr = 0;
        for(int i=0;i<k;i++)
            curr+=arr[i];
        ans = tot-curr;
        for(int i=k;i<arr.length;i++)
        {
            curr-=arr[i-k];
            curr+=arr[i];
            ans = Math.max(ans,tot-curr);
        }
        return ans;
    }
}