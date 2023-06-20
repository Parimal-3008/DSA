class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int arr[]= new int[10];
        if(n==0)
            return 1;
         arr[1]=10;
        arr[2]=9*9;
        int temp = 8;
        for(int i=3;i<=8;i++)
        {
            arr[i]=arr[i-1]*temp;temp--;
        }
        int ans = 0;
        for(int i=0;i<=n;i++)
            ans+=arr[i];
        return ans;
    }
}