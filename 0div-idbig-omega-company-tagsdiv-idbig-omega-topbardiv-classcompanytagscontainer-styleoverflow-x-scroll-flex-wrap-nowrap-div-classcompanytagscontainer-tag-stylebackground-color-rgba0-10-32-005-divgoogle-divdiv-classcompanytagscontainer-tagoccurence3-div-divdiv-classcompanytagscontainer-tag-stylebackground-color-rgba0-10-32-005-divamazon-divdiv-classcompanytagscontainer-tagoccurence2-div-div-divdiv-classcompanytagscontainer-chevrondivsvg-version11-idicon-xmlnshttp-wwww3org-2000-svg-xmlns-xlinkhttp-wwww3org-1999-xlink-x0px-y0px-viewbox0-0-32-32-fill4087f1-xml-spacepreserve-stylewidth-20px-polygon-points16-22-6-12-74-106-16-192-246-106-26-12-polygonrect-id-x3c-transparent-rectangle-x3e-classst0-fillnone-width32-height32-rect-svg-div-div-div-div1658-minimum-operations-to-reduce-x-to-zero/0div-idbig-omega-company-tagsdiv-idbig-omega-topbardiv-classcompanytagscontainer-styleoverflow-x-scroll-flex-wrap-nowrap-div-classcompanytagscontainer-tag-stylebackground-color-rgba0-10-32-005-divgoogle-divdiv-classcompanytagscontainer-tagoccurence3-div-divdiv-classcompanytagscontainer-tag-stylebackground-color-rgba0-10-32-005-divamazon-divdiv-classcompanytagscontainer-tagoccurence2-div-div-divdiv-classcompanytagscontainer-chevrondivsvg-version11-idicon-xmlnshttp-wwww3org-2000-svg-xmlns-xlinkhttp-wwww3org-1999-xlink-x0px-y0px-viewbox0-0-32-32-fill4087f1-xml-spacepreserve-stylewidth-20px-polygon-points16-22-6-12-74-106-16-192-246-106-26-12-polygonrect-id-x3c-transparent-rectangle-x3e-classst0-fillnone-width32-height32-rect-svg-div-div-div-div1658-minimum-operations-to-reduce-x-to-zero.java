class Solution {
    public int minOperations(int[] arr, int x) {
        int tot = 0;
        for(int i:arr)
            tot+=i;
        if(tot<x)
            return -1;
        if(tot == x)
            return arr.length;
        int req = tot - x;
        int max = -1;
       int j=0;
        int curr = 0;
        // System.out.println(req);
        for(int i=0;i<arr.length;i++)
        {
            while(curr>req && j<=i)
                {
                    curr-=arr[j];
                    j++;
                }
             if(curr == req)
                max = Math.max(max,i-j);
            curr+=arr[i];
            // System.out.println(curr+" "+i+" "+j);
            if(curr == req)
                max = Math.max(max,i-j+1);
        }
        while(curr>req && j<=arr.length-1)
                {
                    curr-=arr[j];
                    j++;
                }
         if(curr == req)
                max = Math.max(max,arr.length-1-j+1);
        if(max==-1)
            return -1;
        return arr.length-max;
        
    }
}