class Solution {
    public int minTime(int n, int[][] arr, List<Boolean> hasApple) {
        List<List<Integer>> list = new ArrayList();
        boolean apple[]= new boolean[n];
        for(int i=0;i<n;i++)
            apple[i]=hasApple.get(i);
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());
        for(int i[]:arr)
        {
            list.get(i[0]).add(i[1]);
            list.get(i[1]).add(i[0]);
        }
        
        return call(list,apple,0,-1);
    }
    public int call(List<List<Integer>> list,boolean app[], int i, int prev)
    {
        int sum=0;
        for(int j:list.get(i))
        {
            if(j!=prev)
            {
                int a=call(list,app, j,i);
                sum+=a;
               // System.out.println(i+" "+j+":"+sum);
            }
        }
        if(sum==0)
        {
            if(app[i]&& prev!=-1)
                return 2;
            else
                return 0;
        }
        if(prev!=-1)
        return sum+2;
        return sum;

    }
}