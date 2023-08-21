class Solution {
    public int gcd(int a, int b)
    {
        if(b==0)
            return a;
       return gcd(b,a%b);
    }
    public boolean isGoodArray(int[] arr) {
        
        int gcd = arr[0];
        for(int i=1;i<arr.length;i++)
            gcd = gcd(gcd,arr[i]);
        
        return gcd==1;
    }
}