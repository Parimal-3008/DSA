class Solution {
    public int maxProduct(int[] arr) {
        int p=0;
        int s =0;
        int max= arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(p==0)
                p=1;
            p = p*arr[i];
            if(s==0)
                s=1;
            s =  s * arr[arr.length-i-1];
            max = Math.max(max,Math.max(p,s));
            
        }
        return max;
        
    }
}