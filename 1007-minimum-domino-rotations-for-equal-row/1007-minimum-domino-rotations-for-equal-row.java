class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int arr1[]= new int[7];
        int arr2[]= new int[7];
        int n = tops.length;
        for(int i=0;i<n;i++)
        {          
             arr1[tops[i]]++;
             arr2[bottoms[i]]++;
        }
        List<Integer> l = new LinkedList<>();
        for(int i=1;i<7;i++)
          {
            if(arr1[i]+arr2[i]>=n)
                l.add(i);
        }
        if(l.size()==0)
            return -1;
        int a= l.get(0);
        //System.out.println(l);
        int min=Integer.MAX_VALUE;
        int count=0;        
             for(int i=0;i<n;i++)
            {
             if(tops[i]!=a && bottoms[i]==a)
                 count++;
            else if(tops[i]!=a && bottoms[i]!=a)
              {
                count=Integer.MAX_VALUE;
                break;
              }
            }
             min =Math.min(min,count);
             count=0;        
             for(int i=0;i<n;i++)
            {
               if(tops[i]==a && bottoms[i]!=a)
                  count++;
               else if(tops[i]!=a && bottoms[i]!=a)
                  {
                count=Integer.MAX_VALUE;
                break;
                  }
             }
             min = Math.min(min,count);
        if(l.size()==1)
        {
            if(min==Integer.MAX_VALUE)
                return -1;
            return min;
        }
        a = l.get(1);
         for(int i=0;i<n;i++)
            {
             if(tops[i]!=a && bottoms[i]==a)
                 count++;
            else if(tops[i]!=a && bottoms[i]!=a)
              {
                count=Integer.MAX_VALUE;
                break;
              }
            }
             min =Math.min(min,count);
             count=0;        
             for(int i=0;i<n;i++)
            {
               if(tops[i]==a && bottoms[i]!=a)
                  count++;
               else if(tops[i]!=a && bottoms[i]!=a)
                  {
                count=Integer.MAX_VALUE;
                break;
                  }
             }
             min = Math.min(min,count);
        if(min==Integer.MAX_VALUE)
                return -1;
            return min;
    }
}