class Solution {
    Map<String,Integer> mp = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int cost[]= new int[price.size()];
        int req[]= new int[needs.size()];
        int[][] offers= new int[special.size()][cost.length+1];
        for(int i=0;i<cost.length;i++)
            cost[i]=price.get(i);
         for(int i=0;i<req.length;i++)
            req[i]=needs.get(i);
        for(int i=0;i<offers.length;i++)
        {
            for(int j=0;j<=cost.length;j++)
            {
                offers[i][j]=special.get(i).get(j);
            }
        }
        return call(cost,req,offers);
    }
    public int call(int[] cost, int[] req,int[][] offers)
    {
        if(check(req))
            return 0;
        String str="";
        for(int i:req)
            str= str+","+ String.valueOf(i);
        if(mp.containsKey(str))
            return mp.get(str);
        int ans = 0;
        for(int i=0;i<cost.length;i++)
        {
            ans= ans + (cost[i]*req[i]);
        }
        for(int i=0;i<offers.length;i++)
        {
            boolean isapp= check2(offers[i],req);
            if(isapp)
            {
                update(req,'-',offers[i]);
                ans = Math.min(ans,offers[i][cost.length]+ call(cost,req,offers));
                update(req,'+',offers[i]);
            }
        }
        mp.put(str,ans);
        return ans;
    }
    public void update(int[] req,char ch, int[] offer)
    {
        for(int i=0;i<req.length;i++)
        {
            if(ch=='+')
                req[i]=req[i]+offer[i];
            else
                req[i]=req[i]-offer[i];
        }
    }
    public boolean check2(int[] offer,int[] req)
    {
        for(int i=0;i<req.length;i++)
        {
            if(req[i]<offer[i])
                return false;
        }
        return true;
    }
    public boolean check(int[] arr)
    {
        for(int i:arr)
        {
            if(i!=0)
                return false;
        }
        return true;
    }
}