class Solution {
    public int findMinFibonacciNumbers(int k) {
        TreeSet<Integer> list = new TreeSet<>();
        list.add(1);list.add(1);
        int prev1= 1;
        int prev2 = 1;
        while(prev1+prev2<=999999999)
        {
            list.add(prev1+prev2);
            int sum = prev1+prev2;
            prev2 = prev1;
            prev1=sum;
        }
       return call(k,list);
        
        
    }
    public int call(int k, TreeSet<Integer> set)
    {
        if(k<=1)
            return k;
        Integer p = set.floor(k);
        return 1+ call(k-p,set);
    }
}