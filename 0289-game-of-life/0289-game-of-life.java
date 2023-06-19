class Solution {
    public void gameOfLife(int[][] arr) {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                Map<Integer,Integer> mp = getmap(arr,i,j);
                int a = arr[i][j];
               
                   if(arr[i][j]==1)
                   {
                       if(mp.get(1)<2)
                       arr[i][j]=6;
                       else if(mp.get(1)==2|| mp.get(1)==3)
                       arr[i][j]=5;
                       else 
                           arr[i][j]=6;                      
                   }
                else
                {
                    if(mp.get(1)==3)
                        arr[i][j]=4;
                    else
                        arr[i][j]=7;
                }
                
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j]==6 || arr[i][j]==7)
                    arr[i][j]=0;
                else
                    arr[i][j]=1;
            }
        }
    }
    public Map<Integer,Integer> getmap(int[][] arr, int i, int j)
    {
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(4,0);mp.put(1,0);mp.put(5,0);mp.put(0,0);mp.put(6,0);mp.put(7,0);
        if(i-1>=0&& j-1>=0)
        {
            int a = arr[i-1][j-1];
            if(a==4 || a== 7)
                a=0;
            else if(a==5 || a == 6)
                a = 1;
            mp.put(a,mp.get(a)+1);
        }
        if(i-1>=0)
        {
            int a = arr[i-1][j];
            if(a==4 || a== 7)
                a=0;
            else if(a==5 || a == 6)
                a = 1;
            mp.put(a,mp.get(a)+1);
        }
        if(i-1>=0 && j+1<arr[0].length)
        {
            int a = arr[i-1][j+1];
            if(a==4 || a== 7)
                a=0;
            else if(a==5 || a == 6)
                a = 1;
            mp.put(a,mp.get(a)+1);
        }
        if(j-1>=0)
        {
            int a= arr[i][j-1];
            if(a==4 || a== 7)
                a=0;
            else if(a==5 || a == 6)
                a = 1;
            mp.put(a,mp.get(a)+1);
        }
        if(j+1<arr[0].length)
        {
            int a = arr[i][j+1];
           if(a==4 || a== 7)
                a=0;
            else if(a==5 || a == 6)
                a = 1;
            mp.put(a,mp.get(a)+1);
        }
        if(i+1<arr.length && j-1>=0)
        {
            int a = arr[i+1][j-1];
           if(a==4 || a== 7)
                a=0;
            else if(a==5 || a == 6)
                a = 1;
            mp.put(a,mp.get(a)+1);
        }
        if(i+1<arr.length)
        {
            int a  = arr[i+1][j];
           if(a==4 || a== 7)
                a=0;
            else if(a==5 || a == 6)
                a = 1;
            mp.put(a,mp.get(a)+1);
            
        }
        if(i+1<arr.length && j+1<arr[0].length)
        {
            int a= arr[i+1][j+1];
            if(a==4 || a== 7)
                a=0;
            else if(a==5 || a == 6)
                a = 1;
            mp.put(a,mp.get(a)+1);
            
        }
        return mp;
    }
}