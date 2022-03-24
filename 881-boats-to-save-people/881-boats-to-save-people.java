class Solution {
    public int numRescueBoats(int[] arr, int k) {
        int count =0;
        Arrays.sort(arr);
        // the first code would have worked if wecan put infinte persons on th boat
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        int l =0;int r= arr.length-1;
        while(l<=r)
        {
           int  temp=arr[r];
            count++;
            //System.out.println(l+" "+r+" "+temp+"   "+count);
            if(temp==k)
            {
               r--;
                continue;
            }

               if(temp+arr[l]<=k)
                {                   
                   r--;l++; 
                   
                }
               else
                 { 
                     r--;
                 }
            
        }
      
        return count;
        
    }
}