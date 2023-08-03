class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        int[] odd = new int[n];
        int[] even = new int[n];
        Arrays.fill(odd,-1);
        Arrays.fill(even,-1);
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        for(int i=n-1;i>=0;i--)
        {
            Integer a = mp.ceilingKey(arr[i]);
            if(a!=null)
                odd[i]=mp.get(a);
            Integer b = mp.floorKey(arr[i]);
            if(b!=null)
                even[i]=mp.get(b);            
            mp.put(arr[i],i);
        }
        
        // for(int i:odd)
        //     System.out.print(i+" ");
        // System.out.println();
        // for(int i:even)
        //     System.out.print(i+" ");
        // System.out.println();
        int[][] dp = new int[n][2];
        for(int i[]:dp)
            Arrays.fill(i,Integer.MIN_VALUE);
        for(int i=0;i<n;i++)
        {
            // int st = 9;
            // if(dp[i]==-1)
                 dp[i][1]= call(arr,odd,even,i,1,dp);
        }
        int count = 0;
        for(int i=0;i<n;i++)
        {
            System.out.print(i+" ");
            if(dp[i][1]>=0)
                count++;
        }
        // System.out.println();
        return count;
        
    }
    public int call(int[] arr,int[] odd,int[] even,int i,int curr,int[][] dp)
    {
        if(i==arr.length-1)
            return 0;
        if(dp[i][curr]!=Integer.MIN_VALUE)
            return dp[i][curr];
        if(curr%2==1&&odd[i]!=-1)
         dp[i][curr]= 1+ call(arr,odd,even,odd[i],0,dp);
        else if(curr%2==0&&even[i]!=-1)
         dp[i][curr]= 1 + call(arr,odd,even,even[i],1,dp);
          // System.out.println(i+":"+curr+":::"+dp[i]);
        return dp[i][curr] ;
    }
}