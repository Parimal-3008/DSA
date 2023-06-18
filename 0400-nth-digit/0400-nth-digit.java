class Solution {
    public int findNthDigit(int n) {
        long arr[]= new long[11];
        long temp = 9;
        arr[1]=9;
        for(int i=2;i<=10;i++)
        {
             arr[i]=( temp*(long)Math.pow(10,i-1))*(long)i;
           
            // System.out.println(arr[i]);
        }
        long pref[]= new long[11];
        pref[0]=0;
        for(int i=1;i<=10;i++)
            pref[i]=pref[i-1]+arr[i];
        // for(long i:pref)
        //     System.out.print(i+" ");
        int ceil = call(pref, (long)n);
        n-=(int)pref[ceil-1];
        // int p1 = (int)Math.ceil((double)n/(double)ceil);
        int rem = n%ceil;
        int yu = (int)Math.pow(10,ceil-1)-1 + (n/ceil);
         // System.out.println(ceil+" :::"+yu+":::"+n);
        if(rem == 0)
            return yu%10;
        yu++;
       
        char c = String.valueOf(yu).charAt(rem-1);
        return Integer.parseInt(String.valueOf(c));
        
        
        
    }
    public int call(long[] pref, long n)
    {
        for(int i=0;i<11;i++)
        {
            if(pref[i]>=n)
                return i;
        }
        return -1;
    }
}