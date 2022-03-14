class Solution {
    public int maximumTop(int[] arr, int k) {
        int n =arr.length;
        if(k%2==1&&arr.length==1)
            return -1;
         if(k==arr.length)
         {
             int indofmax=0;
             for(int i=0;i<n;i++)
             {
                 if(arr[indofmax]<arr[i])
                     indofmax=i;
             }
             if(indofmax==n-1)
             {
                 indofmax=0;
             for(int i=0;i<n-1;i++)
             {
                 if(arr[indofmax]<arr[i])
                     indofmax=i;
             }
                 return arr[indofmax];
             }
             else
                 return arr[indofmax];             
         }
        else if(k>arr.length)
        {
            int indofmax=0;
             for(int i=0;i<n;i++)
             {
                 if(arr[indofmax]<arr[i])
                     indofmax=i;
             }
            return arr[indofmax];
        }
        else
        {
            if(k==1)
            {
                if(n>=2)
                    return arr[1];
                return -1;
            }
            int indofmax=0;
             for(int i=0;i<k+1;i++)
             {
                 if(arr[indofmax]<arr[i])
                     indofmax=i;
             }
            if(indofmax==k)
               { return arr[k];}
            int temp=arr[k];
            if(indofmax<k-1)
                return arr[indofmax];
             indofmax=0;
             for(int i=0;i<k-1;i++)
             {
                 if(arr[indofmax]<arr[i])
                     indofmax=i;
             }  
            return Math.max(temp,arr[indofmax]);
        }
        
    }
}