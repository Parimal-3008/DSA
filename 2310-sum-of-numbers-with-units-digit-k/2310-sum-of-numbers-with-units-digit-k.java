class Solution {
    public int minimumNumbers(int n, int k) {
        if(n==0)
            return 0;
        if(n<k)
            return -1;
        if(n==k)
            return 1;
        int rem = n%10;
       boolean flag = true;
        for(int i=1;i<=10;i++)
        {
            if((k*i)%10==rem && k*i<=n)
               return i;
            else if((k*i)%10==rem)
                return -1;
        }
        
            return -1;
        
    }
}