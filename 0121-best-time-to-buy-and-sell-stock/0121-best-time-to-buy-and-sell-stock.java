class Solution {
    public int maxProfit(int[] arr) {
        int max=0;
        int cp =arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>cp)
            {
                max = Math.max(max,arr[i]-cp);
            }
            else
                cp= arr[i];
        }
        return max;
    }
}