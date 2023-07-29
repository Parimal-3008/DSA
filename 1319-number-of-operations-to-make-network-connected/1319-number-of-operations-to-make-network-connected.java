class Solution {
    int cycles = 0;
    int components = 0;
    public int makeConnected(int n, int[][] arr) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=n;i++)
            list.add(new ArrayList<>());
        // components=n;
        for(int i[]:arr)
        {
            list.get(i[0]).add(i[1]);
            list.get(i[1]).add(i[0]);
        }
        boolean[] vis= new boolean[n+1];
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                // System.out.println("comppo"+i);
                components++;
                call(i,list,-1,vis);
            }
        }
        // System.out.println(cycles+" "+components);
        cycles/=2;
        return cycles>=components-1?components-1:-1;
        
    }
    public void call(int i,List<List<Integer>> list , int prev,boolean[] vis)
    {
        vis[i]=true;
        // components--;
        for(int j:list.get(i))
        {
            if(prev == j)
                continue;
            if(!vis[j])
             call(j,list,i,vis);
            else 
              {
                System.out.println(i+"..... "+j);
                cycles++;}
        }
    }
}