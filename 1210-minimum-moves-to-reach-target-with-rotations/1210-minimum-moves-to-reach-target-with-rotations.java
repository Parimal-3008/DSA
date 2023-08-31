class Solution {
    public int minimumMoves(int[][] arr) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->Integer.compare(a[3],b[3]));
        pq.add(new int[]{0,1,0,0});
        int m = arr.length;int n = arr[0].length;
        
        boolean[][][] vis= new boolean[m][n][2];
        vis[0][0][0]=true;
        while(!pq.isEmpty())
        {
            int[] temp= pq.poll();
            int i=temp[0];int j=temp[1];int shape= temp[2]; int steps= temp[3];
            if(i==m-1 && j==n-1 && shape==0)
                return steps;
            if(shape==0)// horizontal
        {
              
            if(j+1<n && arr[i][j+1]==0 && !vis[i][j+1][0])
            {   
                pq.add(new int[]{i,j+1,0,steps+1});
                // a = 1+ call(arr,i,j+1,0);
                vis[i][j+1][0]=true;
            }
                
            if(i+1<m && arr[i+1][j]==0 && arr[i+1][j-1]==0 && !vis[i+1][j][0])
           { 
                pq.add(new int[]{i+1,j,0,steps+1});
                vis[i+1][j][0]=true;
            // b = 1 + call(arr,i+1,j,0);
           }
            if(i+1<m &&j-1<n &&  arr[i+1][j-1]==0&& arr[i+1][j]==0 && !vis[i+1][j-1][1]){
                vis[i+1][j-1][1]=true;
                pq.add(new int[]{i+1,j-1,1,steps+1});
            }
               // c = 1 + call(arr,i+1,j-1,1);  
        }
        else // vertical
        {        
          
            if(j+1<n && arr[i][j+1]==0 && arr[i-1][j+1]==0 && !vis[i][j+1][1]){
                pq.add(new int[]{i,j+1,1,steps+1});
               vis[i][j+1][1]=true;
            }
                // a = 1 + call(arr,i,j+1,1);
            if(i+1<m && arr[i+1][j]==0 && !vis[i+1][j][1]){
               vis[i+1][j][1]=true;
                pq.add(new int[]{i+1,j,1,steps+1});
            }
                // b = 1+ call(arr,i+1,j,1);
            if(i-1>=0 &&j+1<n &&  arr[i-1][j+1]==0&& arr[i][j+1]==0  && !vis[i-1][j+1][0]){
                vis[i-1][j+1][0]=true;
                pq.add(new int[]{i-1,j+1,0, steps+1});}
              // d = 1 + call(arr,i-1,j+1,0);
        }
        }
        return -1;
    }
    //shape =0 -> horizontal
    public int call(int[][] arr, int i, int j, int shape)
    {
        int m = arr.length;int n = arr[0].length;
        if(i==m-1 && j== n-1 && shape ==0)
            return 0;
        if(i<0 ||j<0 ||i>=m||j>=n)
            return Integer.MAX_VALUE;
        int a = Integer.MAX_VALUE;
         int b = Integer.MAX_VALUE;
         int c = Integer.MAX_VALUE;
        int d = Integer.MAX_VALUE;
        if(shape==0)// horizontal
        {
              
            if(j+1<n && arr[i][j+1]==0)
                a = 1+ call(arr,i,j+1,0);
            if(i+1<m && arr[i+1][j]==0 && arr[i+1][j-1]==0)
                b = 1 + call(arr,i+1,j,0);
            if(i+1<m &&j-1<n &&  arr[i+1][j-1]==0)
               c = 1 + call(arr,i+1,j-1,1);  
        }
        else // vertical
        {        
          
            if(j+1<n && arr[i][j+1]==0 && arr[i-1][j+1]==0)
                a = 1 + call(arr,i,j+1,1);
            if(i+1<m && arr[i+1][j]==0)
                b = 1+ call(arr,i+1,j,1);
            if(i-1>=0 &&j+1<n &&  arr[i-1][j+1]==0)
              d = 1 + call(arr,i-1,j+1,0);
        }
        return Math.min(a,Math.min(b,Math.min(c,d)));
    }
}