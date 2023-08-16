class Solution {
    public int countArrangement(int n) {
        int st[]= new int[n];
        int[] arr= new int[n];
        return call(0,arr,st);
    }
    public int call(int i, int[] arr, int[] st)
    {
        if(i==arr.length)
        {
            return 1;
        }
        int ans = 0;
        for(int j=0;j<arr.length;j++)
        {
            if(st[j]==-1)
                continue;
            if((i+1)%(j+1)==0 || (j+1)%(i+1)==0)
           { 
                arr[i]=j+1;
            st[j]=-1;
             ans+=call(i+1,arr,st);
            st[j]=0;
           }
        }
        return ans;
    }
    public boolean check(int[] arr)
    {
        // for(int i:arr)
        //     System.out.print(i+" ");
        // System.out.println();
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]%(i+1)==0 ||(i+1)%arr[i]==0)
                continue;
            return false;
        }
        return true;
    }
}