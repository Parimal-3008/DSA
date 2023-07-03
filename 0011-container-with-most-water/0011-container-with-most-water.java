class Solution {
    public int maxArea(int[] arr) {
        int i=0;int j = arr.length-1;
        int ans = 0;
        while(i<j)
        {
            int temp = (j-i)*Math.min(arr[i],arr[j]);
            ans = Math.max(ans,temp);
            if(arr[i]<arr[j])
                i++;
            else
                j--;
            
        }
        return ans;
    }
}