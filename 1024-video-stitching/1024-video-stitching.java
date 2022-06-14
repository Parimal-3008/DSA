class Solution {
    public int videoStitching(int[][] arr, int k) {
        Arrays.sort(arr,new Comparator<int[]>(){
            @Override
            public int compare(int[]o1, int[] o2)
            {
                int res = Integer.compare(o1[0],o2[0]);
                if(res==0)
                    res = Integer.compare(o2[1],o1[1]);
                return res;
            }            
        });
        int dp[][] = new int[arr.length][arr.length+10];
        
        int max=-1;
        for(int i=0;i<arr.length;i++)
       {  
            Arrays.fill(dp[i],-1);
            max=Math.max(max,arr[i][1]);
        //    System.out.print("["+arr[i][0]+","+arr[i][1]+"]"+"..");
        }
       if(arr[0][0]!=0||max<k)
           return -1;
        int ans= call(0,-1,arr,k,dp);
        if(ans>10000)
            return -1;
        return ans;
    }
    public int call(int i, int j, int[][] arr, int k,int[][] dp)
    {
        if(j!=-1&&arr[j][1]>=k)
            return 0;
        if(i==arr.length)
            return Integer.MAX_VALUE-1000;
        if(dp[i][j+1]!=-1)
            return dp[i][j+1];
        int a = Integer.MAX_VALUE;
        if( j==-1 )
        {
            return 1 + call(i+1,i,arr,k,dp);   
        }
        if (arr[j][1]<arr[i][0])
            return Integer.MAX_VALUE-1000;
        if(arr[j][1]>=arr[i][0] && arr[j][1]<arr[i][1])
             a= 1+ call(i+1,i,arr,k,dp);
        int b = call(i+1,j,arr,k,dp);
        return dp[i][j+1]  = Math.min(a,b);
    }
}