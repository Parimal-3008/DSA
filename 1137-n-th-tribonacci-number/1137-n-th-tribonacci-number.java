class Solution {
    public int tribonacci(int n) {
         int arr[]=new int[n+2];
        Arrays.fill(arr,-1);
        return fg(n,arr);
    }
    public int fg(int n,int[] arr)
    {
        if(n==0)
            return 0;
        if(n==1||n==2)
            return 1;
        
        if(arr[n]!=-1)
            return arr[n];
        arr[n]=fg(n-1,arr)+fg(n-2,arr)+fg(n-3,arr);
        return arr[n];
    }
}