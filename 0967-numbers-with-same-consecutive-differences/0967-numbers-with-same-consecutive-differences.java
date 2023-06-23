class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        TreeSet<Integer> list = new TreeSet<>();
        for(int i=1;i<=9;i++)
        {
            call(list,i,1,n,k,i);
        }
        int arr[]= new int[list.size()];
        int i=0;
        for(Integer p:list)
        {
            arr[i++]=p;
        }
        return arr;
    }
    public void call(TreeSet<Integer> list, int num, int curr,int n, int k,int prev)
    {
        if(curr==n)
        {
            list.add(num);    
            return;
        }
        if(prev+k<10)
        call(list,(num*10)+((prev+k)),curr+1,n,k,(prev+k));
        if(prev-k>=0)
        call(list,(num*10)+((prev-k)),curr+1,n,k,(prev-k));
        // if(k-prev>0)
        // call(list,(num*10)+((k-prev)),curr+1,n,k,(-prev+k));
            
        
    }
}