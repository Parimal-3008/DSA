class Solution {
    public int xorOperation(int n, int s) {
        if(n==1)
            return s;
       int arr[]= new int[n];
        int res=(s)^(s+2);
        for(int i=2;i<n;i++)
        {
            res = res^(s+(2*i));
        }
        return res;
    }
}