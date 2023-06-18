class Solution {
    public int beautySum(String str) {
        int ans = 0;
        for(int len = 1;len<=str.length();len++)
        {
            int[] arr= new int[26];
            for(int i=0;i<len;i++)
            {
                arr[(int)str.charAt(i)-97]++;
            }
            ans+=getsum(arr);
            for(int i=len;i<str.length();i++)
            {
                arr[(int)str.charAt(i)-97]++;
                arr[(int)str.charAt(i-len)-97]--;
                ans+=getsum(arr);
            }
        }
        return ans;
        
    }
    public int getsum(int[] arr)
    {
        int ans =0;
        int max =0;int min =10000;
        for(int i:arr)
        {
            if(i>0)
            {
                max = Math.max(max,i);
                min = Math.min(min,i);
            }
        }
        return max-min;
    }
}